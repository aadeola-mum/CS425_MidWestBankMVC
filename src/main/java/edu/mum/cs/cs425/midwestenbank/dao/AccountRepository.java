/**
 * 
 */
package edu.mum.cs.cs425.midwestenbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.midwestenbank.model.Account;

/**
 * @author miu
 *
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query("SELECT SUM(balance) FROM accounts WHERE acc_type = ?1")
	public double totalSumOfAccountType(int accountTypeId);

}
