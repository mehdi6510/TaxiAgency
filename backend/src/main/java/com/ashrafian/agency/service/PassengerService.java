package com.ashrafian.agency.service;

import com.ashrafian.agency.model.entity.Passenger;
import com.ashrafian.agency.model.exception.ResourceNotFoundException;

import java.util.List;

public interface PassengerService {

    public Passenger getPassengerById(Long passengerId) throws ResourceNotFoundException;

    public Passenger getPassengerByFirstNameAndLastName(String firstName, String LastName);

    public List<Passenger> getAllPassengers();

    public Passenger createPassenger(Passenger passenger);

    public Passenger updatePassenger(Long passengerId, Passenger passengerDetails) throws ResourceNotFoundException;

    public void deletePassenger(Long passengerId) throws ResourceNotFoundException;

}
