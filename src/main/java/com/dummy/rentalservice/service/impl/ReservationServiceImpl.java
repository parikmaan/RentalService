package com.dummy.rentalservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.rentalservice.dao.ReservationDAO;
import com.dummy.rentalservice.dao.VehicleDAO;
import com.dummy.rentalservice.model.Reservation;
import com.dummy.rentalservice.model.Vehicle;
import com.dummy.rentalservice.service.api.ReservationService;

/**
 * @author Parik
 */
@Service
public class ReservationServiceImpl implements ReservationService {

	private VehicleDAO vehicleDAO;
	private ReservationDAO reservationDAO;

	/**
	 * @param reservationDAO
	 */
	@Autowired
	public ReservationServiceImpl(
			VehicleDAO vehicleDAO, ReservationDAO reservationDAO) {

		this.vehicleDAO = vehicleDAO;
		this.reservationDAO = reservationDAO;
	}

	@Override
	public Reservation create(Reservation reservation) {

		Reservation result = null;

		if (checkAvailability(reservation)) {

			result = reservationDAO.save(reservation);
		}

		return result;
	}

	@Override
	public List<Reservation> findAll() {

		return reservationDAO.findAll();
	}

	@Override
	public Optional<Reservation> findById(Long reservationId) {

		return reservationDAO.findById(reservationId);
	}

	@Override
	public Reservation update(
			Long reservationId, Reservation reservationObject) {

		Reservation reservation = reservationDAO.findById(reservationId).get();

		if (checkAvailability(reservationObject)) {

			reservation.setStartDate(reservationObject.getStartDate());
			reservation.setEndDate(reservationObject.getEndDate());
			reservation.setType(reservationObject.getType());

			return reservationDAO.save(reservation);
		} else {

			return null;
		}
	}

	@Override
	public List<Reservation> delete(Long reservationId) {

		reservationDAO.deleteById(reservationId);

		return reservationDAO.findAll();
	}

	private boolean checkAvailability(Reservation reservation) {

		Vehicle vehicle = vehicleDAO.findByType(reservation.getType());

		int count = reservationDAO.findReservationCountByType(
				reservation.getType(), 
				reservation.getStartDate(), 
				reservation.getEndDate());

		return vehicle.getQuantity() > count;
	}
}