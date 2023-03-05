package com.ashrafian.agency.repository;

import com.ashrafian.agency.model.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    String GET_PASSENGER_BY_NAME_AND_ID = "GET_PASSENGER_BY_NAME_AND_ID";
    String PASSENGER = " passenger";

    @Query(name = GET_PASSENGER_BY_NAME_AND_ID,
            value = "select   * from " + PASSENGER + "  where firstName=:firstName and lastName=:lastName ", nativeQuery = true)
    Passenger getPassengerByNameAndLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);


}
