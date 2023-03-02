package com.ashrafian.agency.service.impl;

import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.model.entity.Driver;
import com.ashrafian.agency.repository.DriverRepository;
import com.ashrafian.agency.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    
    private final DriverRepository driverRepository;

    @Override
    public Driver getDriverById(Long driverId) throws ResourceNotFoundException {
        log.info("Try to find driver with this id : {}", driverId);
        Driver driver = driverRepository.findById(driverId).orElseThrow(() ->
                new ResourceNotFoundException("Driver not found for this id :: " + driverId));

        log.info("Driver loaded. Driver id : {}", driverId);
        log.debug("Loaded driver detail: {}", driver);
        return driver;
    }

    @Override
    public List<Driver> getAllDrivers() {
        log.info("Try to load all drivers.");
        List<Driver> drivers = driverRepository.findAll();

        log.info("Drivers has been loaded. Size of result : {}", drivers.size());
        log.debug("Loaded drivers detail: {}", drivers);
        return drivers;
    }

    @Override
    public Driver createDriver(Driver driver) {
        log.info("Try to save driver : {}", driver);
        driverRepository.save(driver);
        log.info("Driver saved : {}", driver);
        return driver;
    }

    @Override
    public Driver updateDriver(Long driverId, Driver driverDetails) throws ResourceNotFoundException {
        log.info("Try to update driver with this driver id: {} and new detail: {}", driverId, driverDetails);
        Driver oldDriver = driverRepository.findById(driverId).orElseThrow(() ->
                new ResourceNotFoundException("Driver not found for this id :: " + driverId));
        log.info("Existing driver data id db has been loaded with this details : {}", oldDriver);


        //mapper.fillUpdatingDetails(oldDriver, driverDetails); 
        Driver updatedDriver = driverRepository.save(oldDriver);

        log.info("Driver updated with this details : {}", updatedDriver);
        return updatedDriver;
    }

    @Override
    public void deleteDriver(Long driverId) throws ResourceNotFoundException {
        log.info("Try to delete driver with this driver id: {}", driverId);
        Driver driver = driverRepository.findById(driverId).orElseThrow(() ->
                new ResourceNotFoundException("Driver not found for this id :: " + driverId));
        log.info("Existing driver has been loaded with this details : {}", driver);

        driverRepository.delete(driver);
        log.info("Driver deleted. Removing Date : {}", new Date());
    }

}
