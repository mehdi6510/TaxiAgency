package com.ashrafian.agency.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "trip")
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;
    private Date time;
    private String startPoint;
    private String destination;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastUpdated;

    public Trip() {
    }

    public Trip(Long id, Long price, Date time, String startPoint, String destination, String description, Passenger passenger, Driver driver, Date createdDate, Date lastUpdated) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.startPoint = startPoint;
        this.destination = destination;
        this.description = description;
        this.passenger = passenger;
        this.driver = driver;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }

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

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) && Objects.equals(price, trip.price) && Objects.equals(time, trip.time) && Objects.equals(startPoint, trip.startPoint) && Objects.equals(destination, trip.destination) && Objects.equals(description, trip.description) && Objects.equals(passenger, trip.passenger) && Objects.equals(driver, trip.driver) && Objects.equals(createdDate, trip.createdDate) && Objects.equals(lastUpdated, trip.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, time, startPoint, destination, description, passenger, driver, createdDate, lastUpdated);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", price=" + price +
                ", time=" + time +
                ", startPoint='" + startPoint + '\'' +
                ", destination='" + destination + '\'' +
                ", description='" + description + '\'' +
                ", passenger=" + passenger +
                ", driver=" + driver +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

}
