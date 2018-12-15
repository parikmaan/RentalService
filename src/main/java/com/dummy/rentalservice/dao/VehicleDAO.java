package com.dummy.rentalservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.rentalservice.model.Vehicle;
import com.dummy.rentalservice.model.VehicleType;

/**
 * @author Parik
 */
public interface VehicleDAO extends JpaRepository<Vehicle, Long>{

	Vehicle findByType(VehicleType type);
}