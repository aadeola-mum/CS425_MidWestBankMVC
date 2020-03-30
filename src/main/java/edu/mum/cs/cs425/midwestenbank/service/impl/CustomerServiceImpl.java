package edu.mum.cs.cs425.midwestenbank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.midwestenbank.dao.CustomerRepository;
import edu.mum.cs.cs425.midwestenbank.model.Customer;
import edu.mum.cs.cs425.midwestenbank.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	/**
	 * @param customerRepository
	 */
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Optional<Customer> get(long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

	@Override
	public Customer save(Customer c) {
		// TODO Auto-generated method stub
		return customerRepository.save(c);
	}

	@Override
	public Optional<Customer> getCustomerByNumber(long customerNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerNumber(customerNumber);
	}

}
