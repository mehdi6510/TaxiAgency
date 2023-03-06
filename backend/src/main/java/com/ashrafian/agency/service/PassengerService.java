package com.ashrafian.agency.service;

import com.ashrafian.agency.model.entity.Passenger;
import com.ashrafian.agency.model.exception.ResourceNotFoundException;

import java.util.List;

public interface PassengerService {

    Passenger getPassengerById(Long passengerId) throws ResourceNotFoundException;

    List<Passenger> search(String firstName, String lastName, String phone);

    List<Passenger> getAllPassengers();

    Passenger createPassenger(Passenger passenger);

    Passenger updatePassenger(Long passengerId, Passenger passenger) throws ResourceNotFoundException;

    void deletePassenger(Long passengerId) throws ResourceNotFoundException;

}
