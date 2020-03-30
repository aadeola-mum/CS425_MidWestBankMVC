/**
 * 
 */
package edu.mum.cs.cs425.midwestenbank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.midwestenbank.model.Customer;

/**
 * @author miu
 *
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Optional<Customer> findByCustomerNumber(long customerNumber);
	public List<Customer> findAllByOrderByLastNameAsc();
}
