package com.abc.banking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.banking.entities.Customer;
import com.abc.banking.entities.Transaction;
import com.abc.banking.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	 @Autowired
	    private TransactionRepository transactionRepository;
	 
	 @Override
	    public Transaction createTransaction(Transaction transaction) {
	        
//	       return customerRepository.save(customer);
	    	
	    	return transactionRepository.save(transaction);
	    
	    	
	    	
	    }
}
