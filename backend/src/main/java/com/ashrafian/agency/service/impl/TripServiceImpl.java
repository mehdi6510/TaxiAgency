package com.ashrafian.agency.service.impl;


import com.ashrafian.agency.model.entity.Trip;
import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.repository.TripRepository;
import com.ashrafian.agency.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TripServiceImpl implements TripService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> search(Long price,
                             String startPoint,
                             String destination,
                             String description,
                             String passengerFirstName,
                             String passengerLastName,
                             String driverFirstName,
                             String driverLastName,
                             String driverPlate) {
        return tripRepository.search(
                price,
                startPoint,
                destination,
                description,
                passengerFirstName,
                passengerLastName,
                driverFirstName,
                driverLastName,
                driverPlate
        );
    }

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
        if (Objects.isNull(trip.getTime())) {
            trip.setTime(new Date());
        }

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

        oldTrip.setPrice(tripDetails.getPrice());
        oldTrip.setDescription(tripDetails.getDescription());
        oldTrip.setStartPoint(tripDetails.getStartPoint());
        oldTrip.setDestination(tripDetails.getDescription());
        if (Objects.nonNull(tripDetails.getTime()))
            oldTrip.setTime(tripDetails.getTime());
        oldTrip.setDriver(tripDetails.getDriver());
        oldTrip.setPassenger(tripDetails.getPassenger());

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
