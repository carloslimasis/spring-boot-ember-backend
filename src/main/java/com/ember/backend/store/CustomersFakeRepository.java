package com.ember.backend.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ember.backend.beans.Customer;

@Repository
public class CustomersFakeRepository {

	private static List<Customer> customers = new ArrayList<>(3);
	static {
		customers.add(new Customer(1, "Edsger Dijkstra", "11-111-111"));
		customers.add(new Customer(2, "Ada Lovelace", "22-222-222"));
		customers.add(new Customer(3, "Alan Turing", "33-333-333"));
	}

	public Customer findById(int id) {
		for (Customer c : customers) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

}
