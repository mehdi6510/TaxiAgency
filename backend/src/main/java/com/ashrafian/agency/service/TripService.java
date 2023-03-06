package com.ashrafian.agency.service;

import com.ashrafian.agency.model.entity.Trip;
import com.ashrafian.agency.model.exception.ResourceNotFoundException;

import java.util.List;

public interface TripService {

    List<Trip> search(Trip trip);

    Trip getTripById(Long tripId) throws ResourceNotFoundException;

    List<Trip> getAllTrips();

    Trip createTrip(Trip trip);

    Trip updateTrip(Long tripId, Trip tripDetails) throws ResourceNotFoundException;

    void deleteTrip(Long tripId) throws ResourceNotFoundException;

}
