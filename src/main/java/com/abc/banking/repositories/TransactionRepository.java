package com.abc.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.abc.banking.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	

}
