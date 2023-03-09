package com.ashrafian.agency.service;

import com.ashrafian.agency.model.entity.Trip;
import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripService {

    List<Trip> search(Long price,
                      String startPoint,
                      String destination,
                      String description,
                      String passengerFirstName,
                      String passengerLastName,
                      String driverFirstName,
                      String driverLastName,
                      String driverPlate);

    Trip getTripById(Long tripId) throws ResourceNotFoundException;

    List<Trip> getAllTrips();

    Trip createTrip(Trip trip);

    Trip updateTrip(Long tripId, Trip tripDetails) throws ResourceNotFoundException;

    void deleteTrip(Long tripId) throws ResourceNotFoundException;

}
