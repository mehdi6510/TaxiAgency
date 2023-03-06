package com.ashrafian.agency.repository;

import com.ashrafian.agency.model.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query(value = "from Trip t where " +
            "           t.price = :price " +
            "       or t.startPoint like %:startPoint% " +
            "       or t.destination like %:destination% " +
            "       or t.description like %:description% " +
            "       or t.passenger.firstName like %:passengerFirstName% " +
            "       or t.passenger.lastName like %:passengerLastName% " +
            "       or t.driver.firstName like %:driverFirstName% " +
            "       or t.driver.lastName like %:driverLastName% " +
            "       or t.driver.plate like %:driverPlate% ")
    List<Trip> search(
            @Param("price") Long price,
            @Param("startPoint") String startPoint,
            @Param("destination") String destination,
            @Param("description") String description,
            @Param("passengerFirstName") String passengerFirstName,
            @Param("passengerLastName") String passengerLastName,
            @Param("driverFirstName") String driverFirstName,
            @Param("driverLastName") String driverLastName,
            @Param("driverPlate") String driverPlate
    );

}
