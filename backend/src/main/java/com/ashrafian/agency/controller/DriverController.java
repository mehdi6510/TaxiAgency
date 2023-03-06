package com.ashrafian.agency.controller;

import com.ashrafian.agency.model.entity.Driver;
import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/taxi-agency/api/driver")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(value = "/drivers/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable(value = "id") Long driverId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(driverService.getDriverById(driverId));
    }

    @GetMapping(value = "/drivers")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok().body(driverService.getAllDrivers());
    }

    @PostMapping(value = "/drivers")
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        return ResponseEntity.ok().body(driverService.createDriver(driver));
    }

    @PutMapping(value = "/drivers/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable(value = "id") Long driverId, @RequestBody Driver driverDetails)
            throws ResourceNotFoundException {
        Driver updatedDriver = driverService.updateDriver(driverId, driverDetails);
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping(value = "/drivers/{id}")
    public Map<String, Boolean> deleteDriver(@PathVariable(value = "id") Long driverId) throws ResourceNotFoundException {
        driverService.deleteDriver(driverId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
