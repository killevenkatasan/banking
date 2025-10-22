package com.example.banking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Entity
public class BankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank (message = "Name is Mandatory")
    private String name;
    @Email(message = "email should be valid")
    private String email;
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private Double phoneNumber;
    @NotBlank (message = "address is Mandatory")
    private String address;
    @NotBlank (message = "date is Mandatory")
    private LocalDate date;
    @NotBlank (message = "dateOfBirth is Mandatory")
    private LocalDate dateOfBirth;
    @NotBlank (message = "country is Mandatory")
    private String country;
    @NotBlank (message = "city is Mandatory")
    private String city;
    @NotNull(message = "Income is mandatory")
    @Min(value = 0, message = "Income must be positive")
    private Long income;
    @NotNull(message = "Age is mandatory")
    @Min(value = 18, message = "Customer must be at least 18 years old")
    private Long age;
    private boolean active = true;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {

    }

    public void setAge(long age) {
    }
}
