/**
 * 
 */
package edu.mum.cs.cs425.midwestenbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.midwestenbank.model.Account;

/**
 * @author miu
 *
 */

public interface AccountService {
	public List<Account> getAll();
	public Optional<Account> get(long id);
	public Account save(Account a);
	public double totalSavings();
	public double totalCheckings();
	public double totalLoans();
}
