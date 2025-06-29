package com.vikash.crm.controller;

import com.vikash.crm.entity.Customer;
import com.vikash.crm.service.CustomerService;
import com.vikash.crm.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * CustomerController - Handles all customer-related HTTP requests.
 * Author: Vikash Kumar
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // Automatically trim leading/trailing whitespace from form input
        StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, trimmer);
    }

    @GetMapping("/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String listCustomers(@RequestParam(name = "sortBy", required = false) String sortBy, Model model) {
        List<Customer> customers;

        if (sortBy != null) {
            int sort = Integer.parseInt(sortBy);
            customers = customerService.getCustomers(sort);
        } else {
            customers = customerService.getCustomers(SortUtils.SortByLastName.getValue());
        }

        model.addAttribute("search", null);
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam(required = false) String search, Model model) {
        if (search != null && !search.trim().isEmpty()) {
            model.addAttribute("search", search);
            model.addAttribute("customers", customerService.searchCustomer(search));
            return "customer-list";
        }
        return "redirect:/customer/list";
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
