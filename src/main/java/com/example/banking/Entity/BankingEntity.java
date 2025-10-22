package com.example.banking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
@Data
@Entity
public class BankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is Mandatory")
    private String name;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Email should be valid")
    private String email;
    @NotNull(message = "Phone number is mandatory")
    @Digits(integer = 10, fraction = 0, message = "Phone number must be 10 digits")
    private Double phoneNumber;
    @NotBlank(message = "address is Mandatory")
    private String address;

    private LocalDate date;

    @NotBlank(message = "country is Mandatory")
    private String country;
    @NotBlank(message = "city is Mandatory")
    private String city;
    @NotNull(message = "Income is mandatory")
    @Min(value = 0, message = "Income must be positive")
    private Long income;

    private LocalDate dateOfBirth;


    private Long age;

    private boolean active = true;
}