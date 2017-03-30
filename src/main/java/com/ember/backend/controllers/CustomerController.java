package com.ember.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ember.backend.assembler.CustomerResourceAssembler;
import com.ember.backend.beans.Customer;
import com.ember.backend.exception.EntityNotFoundException;
import com.ember.backend.store.CustomersFakeRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private final CustomersFakeRepository customersRepository;
	private final CustomerResourceAssembler customerResourceAssembler;

	@Autowired
	public CustomerController(CustomerResourceAssembler customerResourceAssembler, CustomersFakeRepository repository) {
		this.customerResourceAssembler = customerResourceAssembler;
		this.customersRepository = repository;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Resource<Customer>> getCustomer(@PathVariable("id") Integer id) {
		Customer customer = customersRepository.findById(id);
		if (customer == null) {
			throw new EntityNotFoundException("Customer not found - id: " + id);
		}
		Resource<Customer> resource = customerResourceAssembler.toResource(customer);
		return ResponseEntity.ok(resource);
	}

}
