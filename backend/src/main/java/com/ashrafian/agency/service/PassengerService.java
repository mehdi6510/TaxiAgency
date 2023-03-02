package com.ashrafian.agency.service;

import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.model.entity.Passenger;

import java.util.List;

public interface PassengerService {

    Passenger getPassengerById(Long passengerId) throws ResourceNotFoundException;

    List<Passenger> getAllPassengers();

    Passenger createPassenger(Passenger passenger);

    Passenger updatePassenger(Long passengerId, Passenger passengerDetails) throws ResourceNotFoundException;

    void deletePassenger(Long passengerId) throws ResourceNotFoundException;
    
}
