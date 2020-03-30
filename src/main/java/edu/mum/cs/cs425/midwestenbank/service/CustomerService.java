package edu.mum.cs.cs425.midwestenbank.service;

import java.util.List;
import java.util.Optional;

import edu.mum.cs.cs425.midwestenbank.model.Customer;


public interface CustomerService {
	public List<Customer> getAll();
	public Optional<Customer> get(long id);
	public Optional<Customer> getCustomerByNumber(long customerNumber);
	public Customer save(Customer c);
}
