package com.ashrafian.agency.service;

import com.ashrafian.agency.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {

    Driver getUserById(Long driverId) throws ResourceNotFoundException;

    List<Driver> getAllDrivers();

    Driver createDriver(com.ashrafian.agency.model.entity.Driver driver);

    Driver updateUser(Long driverId, Driver driverDetails) throws ResourceNotFoundException;

    void deleteDriver(Long driverId) throws ResourceNotFoundException;
}
