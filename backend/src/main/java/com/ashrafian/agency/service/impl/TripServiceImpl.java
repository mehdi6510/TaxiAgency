package com.ashrafian.agency.service.impl;

import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.model.entity.Trip;
import com.ashrafian.agency.repository.TripRepository;
import com.ashrafian.agency.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
    
    private final TripRepository tripRepository;

    @Override
    public Trip getTripById(Long tripId) throws ResourceNotFoundException {
        log.info("Try to find trip with this id : {}", tripId);
        Trip trip = tripRepository.findById(tripId).orElseThrow(() ->
                new ResourceNotFoundException("Trip not found for this id :: " + tripId));

        log.info("Trip loaded. Trip id : {}", tripId);
        log.debug("Loaded trip detail: {}", trip);
        return trip;
    }

    @Override
    public List<Trip> getAllTrips() {
        log.info("Try to load all trips.");
        List<Trip> trips = tripRepository.findAll();

        log.info("Trips has been loaded. Size of result : {}", trips.size());
        log.debug("Loaded trips detail: {}", trips);
        return trips;
    }

    @Override
    public Trip createTrip(Trip trip) {
        log.info("Try to save trip : {}", trip);
        tripRepository.save(trip);
        log.info("Trip saved : {}", trip);
        return trip;
    }

    @Override
    public Trip updateTrip(Long tripId, Trip tripDetails) throws ResourceNotFoundException {
        log.info("Try to update trip with this trip id: {} and new detail: {}", tripId, tripDetails);
        Trip oldTrip = tripRepository.findById(tripId).orElseThrow(() ->
                new ResourceNotFoundException("Trip not found for this id :: " + tripId));
        log.info("Existing trip data id db has been loaded with this details : {}", oldTrip);


        //mapper.fillUpdatingDetails(oldTrip, tripDetails);
        Trip updatedTrip = tripRepository.save(oldTrip);

        log.info("Trip updated with this details : {}", updatedTrip);
        return updatedTrip;
    }

    @Override
    public void deleteTrip(Long tripId) throws ResourceNotFoundException {
        log.info("Try to delete trip with this trip id: {}", tripId);
        Trip trip = tripRepository.findById(tripId).orElseThrow(() ->
                new ResourceNotFoundException("Trip not found for this id :: " + tripId));
        log.info("Existing trip has been loaded with this details : {}", trip);

        tripRepository.delete(trip);
        log.info("Trip deleted. Removing Date : {}", new Date());
    }

}
