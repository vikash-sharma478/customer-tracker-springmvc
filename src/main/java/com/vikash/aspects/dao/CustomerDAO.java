package com.vikash.crm.dao;

import com.vikash.crm.entity.Customer;
import java.util.List;

/**
 * CustomerDAO - Interface for performing database operations on Customer entities.
 * Author: Vikash Kumar
 */
public interface CustomerDAO {

    /**
     * Saves a new customer to the database.
     * @param customer the Customer entity to add
     */
    void addCustomer(Customer customer);

    /**
     * Retrieves a customer by ID.
     * @param id the customer ID
     * @return the matching Customer entity, or null if not found
     */
    Customer getCustomer(int id);

    /**
     * Retrieves a sorted list of customers.
     * @param sortBy field used for sorting (e.g., firstName, lastName)
     * @return sorted list of customers
     */
    List<Customer> getCustomers(int sortBy);

    /**
     * Deletes a customer from the database.
     * @param id ID of the customer to delete
     */
