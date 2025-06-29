package com.vikash.crm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Customer - Entity representing a customer in the CRM system.
 * Author: Vikash Kumar
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotNull(message = "First name is required")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name is required")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "Email is required")
    private String email;

    // Default constructor
    public Customer() {
    }

    // Parameterized constructor
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString for debugging/logging
    @Override
    public String toString() {
        return "Customer{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
