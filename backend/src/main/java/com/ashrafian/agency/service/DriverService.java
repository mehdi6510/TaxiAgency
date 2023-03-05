package com.ashrafian.agency.service;

import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.model.entity.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DriverService {

    Driver getDriverById(Long driverId) throws ResourceNotFoundException;

    List<Driver> getAllDrivers();

    Driver createDriver(Driver driver);

    Driver updateDriver(Long driverId, Driver driverDetails) throws ResourceNotFoundException;

    void deleteDriver(Long driverId) throws ResourceNotFoundException;

}
