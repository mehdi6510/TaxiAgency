package com.ashrafian.agency.service.impl;

import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.model.entity.Passenger;
import com.ashrafian.agency.repository.PassengerRepository;
import com.ashrafian.agency.service.PassengerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    
    private final PassengerRepository passengerRepository;

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
    public Passenger updatePassenger(Long passengerId, Passenger passengerDetails) throws ResourceNotFoundException {
        log.info("Try to update passenger with this passenger id: {} and new detail: {}", passengerId, passengerDetails);
        Passenger oldPassenger = passengerRepository.findById(passengerId).orElseThrow(() ->
                new ResourceNotFoundException("Passenger not found for this id :: " + passengerId));
        log.info("Existing passenger data id db has been loaded with this details : {}", oldPassenger);


        //mapper.fillUpdatingDetails(oldPassenger, passengerDetails); 
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
