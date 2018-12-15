package com.dummy.rentalservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.rentalservice.dao.VehicleDAO;
import com.dummy.rentalservice.model.Vehicle;
import com.dummy.rentalservice.service.api.VehicleService;

/**
 * @author Parik
 */
@Service
public class VehicleServiceImpl implements VehicleService {

	private VehicleDAO vehicleDAO;

	/**
	 * @param vehicleDAO
	 */
	@Autowired
	public VehicleServiceImpl(VehicleDAO vehicleDAO) {

		this.vehicleDAO = vehicleDAO;
	}

	@Override
	public Vehicle create(Vehicle vehicle) {

		return vehicleDAO.save(vehicle);
	}

	@Override
	public List<Vehicle> findAll() {

		return vehicleDAO.findAll();
	}

	@Override
	public Optional<Vehicle> findById(Long vehicleId) {

		return vehicleDAO.findById(vehicleId);
	}

	@Override
	public Vehicle update(Long vehicleId, Vehicle vehicleObject) {

		Vehicle vehicle = vehicleDAO.findById(vehicleId).get();

		vehicle.setQuantity(vehicleObject.getQuantity());

		return vehicleDAO.save(vehicle);
	}

	@Override
	public List<Vehicle> delete(Long vehicleId) {

		vehicleDAO.deleteById(vehicleId);

		return vehicleDAO.findAll();
	}
}