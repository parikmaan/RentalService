package com.dummy.rentalservice.service.api;

import java.util.List;
import java.util.Optional;

import com.dummy.rentalservice.model.Reservation;

/**
 * @author Parik
 */
public interface ReservationService {

	public Reservation create(Reservation reservation);

	public List<Reservation> findAll();

	public Optional<Reservation> findById(Long reservationId);

	public Reservation update(
			Long reservationId, Reservation reservationObject);

	public List<Reservation> delete(Long reservationId);
}