package com.abc.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.banking.entities.Account;
import com.abc.banking.entities.Customer;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	// List<Account> findAccountsById(Long id, List<String> accNo);
	
	List<Account> findByCustomer(Customer customer);
	
	
}
