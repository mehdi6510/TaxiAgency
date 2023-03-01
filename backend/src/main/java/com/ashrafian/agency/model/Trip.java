package com.ashrafian.agency.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;
    private Date time;
    private String startPoint;
    private String destination;
    private String description;

    public Trip() {
    }
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private com.ashrafian.agency.model.entity.Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private com.ashrafian.agency.model.entity.Driver driver;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.ashrafian.agency.model.entity.Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(com.ashrafian.agency.model.entity.Passenger passenger) {
        this.passenger = passenger;
    }

    public com.ashrafian.agency.model.entity.Driver getDriver() {
        return driver;
    }

    public void setDriver(com.ashrafian.agency.model.entity.Driver driver) {
        this.driver = driver;
    }
}
