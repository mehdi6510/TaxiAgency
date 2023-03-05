package com.ashrafian.agency.controller;

import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.model.entity.Passenger;
import com.ashrafian.agency.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/taxi-agency/api/passenger")
public class PassengerController {

    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping(value = "/passengers/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable(value = "id") Long passengerId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(passengerService.getPassengerById(passengerId));
    }

    @GetMapping(value = "/passengersByFirstAndLastName/{firstName}/{lastName}")
    public ResponseEntity<Passenger> getPassengerByFirstNameAndLastName(@PathVariable (value = "firstName") String firstName,@PathVariable (value = "lastName") String lastName) throws ResourceNotFoundException {
        return ResponseEntity.ok().body( passengerService.getPassengerByFirstNameAndLastName(firstName,lastName));
    }

    @GetMapping(value = "/passengers")
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.ok().body(passengerService.getAllPassengers());
    }

    @PostMapping(value = "/passengers")
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        return ResponseEntity.ok().body(passengerService.createPassenger(passenger));
    }

    @PutMapping(value = "/passengers/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable(value = "id") Long passengerId, @RequestBody Passenger passengerDetails)
            throws ResourceNotFoundException {
        Passenger updatedPassenger = passengerService.updatePassenger(passengerId, passengerDetails);
        return ResponseEntity.ok(updatedPassenger);
    }

    @DeleteMapping(value = "/passengers/{id}")
    public Map<String, Boolean> deletePassenger(@PathVariable(value = "id") Long passengerId) throws ResourceNotFoundException {
        passengerService.deletePassenger(passengerId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
