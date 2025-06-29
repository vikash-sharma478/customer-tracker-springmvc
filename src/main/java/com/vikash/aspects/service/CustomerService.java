package com.vikash.crm.service;

import com.vikash.crm.entity.Customer;
import java.util.List;

/**
 * CustomerService - Interface for business logic related to Customer operations.
 * Author: Vikash Kumar
 */
public interface CustomerService {

    /**
     * Adds or updates a customer record.
     * @param customer the customer to save
     */
    void addCustomer(Customer customer);

    /**
     * Retrieves a customer by their ID.
     * @param id the customer ID
     * @return the customer object
     */
    Customer getCustomer(int id);

    /**
     * Returns a list of customers, optionally sorted.
     * @param sortBy sorting option (0 = first name, 1 = last name, 2 = email)
     * @return list of customers
     */
    List<Customer> getCustomers(int sortBy);

    /**
     * Deletes a customer from the system.
     * @param id the ID of the customer to delete
     */
    void deleteCustomer(int id);

    /**
     * Searches customers by name or email.
     * @param searchString the keyword to search
     * @return list of matching customers
     */
    List<Customer> searchCustomer(String searchString);
}
