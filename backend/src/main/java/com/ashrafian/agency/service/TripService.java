package com.ashrafian.agency.service;

import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.model.entity.Trip;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TripService {

    Trip getTripById(Long tripId) throws ResourceNotFoundException;

    List<Trip> getAllTrips();

    Trip createTrip(Trip trip);

    Trip updateTrip(Long tripId, Trip tripDetails) throws ResourceNotFoundException;

    void deleteTrip(Long tripId) throws ResourceNotFoundException;
    
}
