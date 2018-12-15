package com.dummy.rentalservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.rentalservice.model.Vehicle;
import com.dummy.rentalservice.service.api.VehicleService;

/**
 * @author Parik
 */
@RequestMapping("/vehicles")
@RestController
public class VehicleController {

	@Autowired
	private VehicleService service;

	@PostMapping
	public Vehicle create(@RequestBody Vehicle vehicle) {

		return service.create(vehicle);
	}

	@GetMapping
	public List<Vehicle> findAll() {

		return service.findAll();
	}

	@GetMapping("/{vehicle_id}")
	public Optional<Vehicle> findById (
			@PathVariable("vehicle_id") Long vehicleId) {

		return service.findById(vehicleId);
	}

	@PutMapping("/{vehicle_id}")
	public Vehicle update(
			@PathVariable("vehicle_id") Long vehicleId, 
			@RequestBody Vehicle vehicleObject) {

		return service.update(vehicleId, vehicleObject);
	}

	@DeleteMapping("/{vehicle_id}")
	public List<Vehicle> delete(@PathVariable("vehicle_id") Long vehicleId) {

		return service.delete(vehicleId);
	}
}