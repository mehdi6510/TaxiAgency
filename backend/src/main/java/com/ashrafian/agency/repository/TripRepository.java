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
            "          (:price is null or t.price = :price) " +
            "       and (:startPoint is null or t.startPoint like %:startPoint%) " +
            "       and (:destination is null or t.destination like %:destination%) " +
            "       and (:description is null or t.description like %:description%) " +
            "       and (:passengerFirstName is null or t.passenger.firstName like %:passengerFirstName%) " +
            "       and (:passengerLastName is null or t.passenger.lastName like %:passengerLastName%) " +
            "       and (:driverFirstName is null or t.driver.firstName like %:driverFirstName%) " +
            "       and (:driverLastName is null or t.driver.lastName like %:driverLastName%) " +
            "       and (:driverPlate is null or t.driver.plate like %:driverPlate%) "
    )
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
