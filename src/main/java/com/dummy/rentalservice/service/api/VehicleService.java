package com.dummy.rentalservice.service.api;

import java.util.List;
import java.util.Optional;

import com.dummy.rentalservice.model.Vehicle;

/**
 * @author Parik
 */
public interface VehicleService {

	public Vehicle create(Vehicle vehicle);

	public List<Vehicle> findAll();

	public Optional<Vehicle> findById(Long vehicleId);

	public Vehicle update(Long vehicleId, Vehicle vehicleObject);

	public List<Vehicle> delete(Long vehicleId);
}