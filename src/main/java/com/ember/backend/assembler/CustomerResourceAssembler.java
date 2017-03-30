package com.ember.backend.assembler;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.ember.backend.beans.Customer;

@Component
public class CustomerResourceAssembler implements ResourceAssembler<Customer, Resource<Customer>> {

	@Override
	public Resource<Customer> toResource(Customer customer) {
		Resource<Customer> resource = new Resource<>(customer);
		resource.add(new Link("http://localhost:8080/customers/" + customer.getId()).withSelfRel());
		return resource;
	}

}
