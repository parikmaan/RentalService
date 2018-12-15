package com.dummy.rentalservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dummy.rentalservice.model.Reservation;
import com.dummy.rentalservice.service.api.ReservationService;

/**
 * @author Parik
 */
@RequestMapping("/reservations")
@RestController
public class ReservationController {

	@Autowired
	private ReservationService service;

	@PostMapping
	public Reservation create(@RequestBody Reservation reservation) {

		Reservation result = service.create(reservation);

		if (result != null) 
			return result;
		else 
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "No cars available");
	}

	@GetMapping
	public List<Reservation> findAll() {

		return service.findAll();
	}

	@GetMapping("/{reservation_id}")
	public Optional<Reservation> findById (
			@PathVariable("reservation_id") Long reservationId) {

		return service.findById(reservationId);
	}

	@PutMapping("/{reservation_id}")
	public Reservation update(
			@PathVariable("reservation_id") Long reservationId, 
			@RequestBody Reservation reservationObject) {

		Reservation result = service.update(reservationId, reservationObject);

		if (result != null) 
			return result;
		else 
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "No cars available");
	}

	@DeleteMapping("/{reservation_id}")
	public List<Reservation> delete(
			@PathVariable("reservation_id") Long reservationId) {

		return service.delete(reservationId);
	}
}