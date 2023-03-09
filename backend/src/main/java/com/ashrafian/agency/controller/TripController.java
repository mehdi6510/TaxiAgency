package com.ashrafian.agency.controller;

import com.ashrafian.agency.model.entity.Trip;
import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/taxi-agency/api/trip")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<Trip>> search(@RequestParam(value = "price", required = false) Long price,
                                             @RequestParam(value = "startPoint", required = false) String startPoint,
                                             @RequestParam(value = "destination", required = false) String destination,
                                             @RequestParam(value = "description", required = false) String description,
                                             @RequestParam(value = "passengerFirstName", required = false) String passengerFirstName,
                                             @RequestParam(value = "passengerLastName", required = false) String passengerLastName,
                                             @RequestParam(value = "driverFirstName", required = false) String driverFirstName,
                                             @RequestParam(value = "driverLastName", required = false) String driverLastName,
                                             @RequestParam(value = "driverPlate", required = false) String driverPlate) {
        return ResponseEntity.ok(tripService.search(
                price,
                startPoint,
                destination,
                description,
                passengerFirstName,
                passengerLastName,
                driverFirstName,
                driverLastName,
                driverPlate)
        );
    }

    @GetMapping(value = "/trips/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable(value = "id") Long tripId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(tripService.getTripById(tripId));
    }

    @GetMapping(value = "/trips")
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok().body(tripService.getAllTrips());
    }

    @PostMapping(value = "/trips")
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok().body(tripService.createTrip(trip));
    }

    @PutMapping(value = "/trips/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable(value = "id") Long tripId, @RequestBody Trip tripDetails)
            throws ResourceNotFoundException {
        Trip updatedTrip = tripService.updateTrip(tripId, tripDetails);
        return ResponseEntity.ok(updatedTrip);
    }

    @DeleteMapping(value = "/trips/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value = "id") Long tripId) throws ResourceNotFoundException {
        tripService.deleteTrip(tripId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
