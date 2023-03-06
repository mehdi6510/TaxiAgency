package com.ashrafian.agency.service.impl;

import com.ashrafian.agency.model.entity.Passenger;
import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.repository.PassengerRepository;
import com.ashrafian.agency.service.PassengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger getPassengerById(Long passengerId) throws ResourceNotFoundException {
        log.info("Try to find passenger with this id : {}", passengerId);
        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(() ->
                new ResourceNotFoundException("Passenger not found for this id :: " + passengerId));

        log.info("Passenger loaded. Passenger id : {}", passengerId);
        log.debug("Loaded passenger detail: {}", passenger);
        return passenger;
    }

    @Override
    public List<Passenger> search(String firstName, String lastName, String phone) {
        return passengerRepository.search(firstName, lastName, phone);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        log.info("Try to load all passengers.");
        List<Passenger> passengers = passengerRepository.findAll();
        log.info("Passengers has been loaded. Size of result : {}", passengers.size());
        log.debug("Loaded passengers detail: {}", passengers);
        return passengers;
    }


    @Override
    public Passenger createPassenger(Passenger passenger) {
        log.info("Try to save passenger : {}", passenger);
        passengerRepository.save(passenger);
        log.info("Passenger saved : {}", passenger);
        return passenger;
    }

    @Override
    public Passenger updatePassenger(Long passengerId, Passenger passenger) throws ResourceNotFoundException {
        log.info("Try to update passenger with this passenger id: {} and new detail: {}", passengerId, passenger);
        Passenger oldPassenger = passengerRepository.findById(passengerId).orElseThrow(() ->
                new ResourceNotFoundException("Passenger not found for this id :: " + passengerId));
        log.info("Existing passenger data id db has been loaded with this details : {}", oldPassenger);

        oldPassenger.setFirstName(passenger.getFirstName());
        oldPassenger.setLastName(passenger.getLastName());
        oldPassenger.setAddress(passenger.getAddress());
        oldPassenger.setPhone(passenger.getPhone());

        Passenger updatedPassenger = passengerRepository.save(oldPassenger);

        log.info("Passenger updated with this details : {}", updatedPassenger);
        return updatedPassenger;
    }

    @Override
    public void deletePassenger(Long passengerId) throws ResourceNotFoundException {
        log.info("Try to delete passenger with this passenger id: {}", passengerId);
        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(() ->
                new ResourceNotFoundException("Passenger not found for this id :: " + passengerId));
        log.info("Existing passenger has been loaded with this details : {}", passenger);

        passengerRepository.delete(passenger);
        log.info("Passenger deleted. Removing Date : {}", new Date());
    }

}
