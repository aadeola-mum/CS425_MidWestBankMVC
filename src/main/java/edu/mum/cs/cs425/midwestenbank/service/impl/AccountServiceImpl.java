package edu.mum.cs.cs425.midwestenbank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.midwestenbank.dao.AccountRepository;
import edu.mum.cs.cs425.midwestenbank.model.Account;
import edu.mum.cs.cs425.midwestenbank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	
	
	/**
	 * @param accountRepository
	 */
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public Optional<Account> get(long accountId) {
		return accountRepository.findById(accountId);
	}

	@Override
	public Account save(Account a) {
		return accountRepository.save(a);
	}

	@Override
	public double totalSavings() {
		// TODO Auto-generated method stub
		return accountRepository.totalSumOfAccountType(3);
	}

	@Override
	public double totalCheckings() {
		// TODO Auto-generated method stub
		return accountRepository.totalSumOfAccountType(1);
	}

	@Override
	public double totalLoans() {
		// TODO Auto-generated method stub
		return accountRepository.totalSumOfAccountType(2);
	}

}
