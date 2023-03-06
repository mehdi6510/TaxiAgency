package com.ashrafian.agency.repository;

import com.ashrafian.agency.model.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Query(value = "select " +
            "               * " +
            "       from " +
            "               passenger p " +
            "       where " +
            "               (:firstName is null or p.first_name like %:firstName%) " +
            "               and (:lastName is null or p.last_name like %:lastName%)" +
            "               and (:phone is null or p.phone like %:phone%) ",
            nativeQuery = true)
    List<Passenger> search(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("phone") String phone);

}
