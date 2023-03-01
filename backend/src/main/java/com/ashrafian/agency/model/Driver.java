package com.ashrafian.agency.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver {


    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String plate;

    public Driver() {
    }

    public Driver(Long id, String firstName, String lastName, String phone, String plate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.plate = plate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) &&
                Objects.equals(firstName, driver.firstName) &&
                Objects.equals(lastName, driver.lastName) &&
                Objects.equals(phone, driver.phone) &&
                Objects.equals(plate, driver.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone, plate);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", plate='" + plate + '\'' +
                '}';
    }
}
