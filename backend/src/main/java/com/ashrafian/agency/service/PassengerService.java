package com.ashrafian.agency.service;

import com.ashrafian.agency.model.exception.ResourceNotFoundException;
import com.ashrafian.agency.model.entity.Passenger;
import com.ashrafian.agency.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor
public interface PassengerService {

  private  final   PassengerRepository passengerRepository;


    public Passenger getPassengerById(Long passengerId) throws ResourceNotFoundException;

    public List<Passenger> getAllPassengers();

    public default Passenger getPassengerByFirstNameAndLastName(String firstName, String LastName) {
        Passenger passenger = (Passenger) passengerRepository.getPassengerByNameAndLastName(firstName, LastName);
        return passenger;
    }

    public Passenger createPassenger(Passenger passenger);

    public Passenger updatePassenger(Long passengerId, Passenger passengerDetails) throws ResourceNotFoundException;

    public void deletePassenger(Long passengerId) throws ResourceNotFoundException;

}
