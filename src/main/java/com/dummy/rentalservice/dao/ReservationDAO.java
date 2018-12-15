package com.dummy.rentalservice.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dummy.rentalservice.model.Reservation;
import com.dummy.rentalservice.model.VehicleType;

/**
 * @author Parik
 */
public interface ReservationDAO extends JpaRepository<Reservation, Long>{

	@Query("SELECT COUNT(R.id) FROM Reservation R WHERE R.type = :type "
			+ "AND :startDate <= R.endDate AND :endDate >= R.startDate")
	int findReservationCountByType(
			@Param("type") VehicleType type, 
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);
}