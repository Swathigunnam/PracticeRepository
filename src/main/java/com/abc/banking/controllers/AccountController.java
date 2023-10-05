package com.abc.banking.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abc.banking.entities.Account;
import com.abc.banking.entities.Customer;
import com.abc.banking.entities.Transaction;
import com.abc.banking.repositories.TransactionRepository;
import com.abc.banking.services.AccountService;
import com.abc.banking.services.CustomerService;

import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

	@RestController
	@RequestMapping("/accounts")
	public class AccountController {

	    @Autowired
	    private AccountService accountService;
	    
	    @Autowired
	    private CustomerService customerService;
	    
	   
	    @PostMapping("/{id}/createaccount")
	    public Account createAccount(@RequestBody Account account ,@PathVariable Long id ) {
	        return accountService.createAccount(account,id);
	    }

	    @PostMapping("/transaction")
	    public Transaction depositAmount(@RequestBody Transaction transaction ) {
	        return accountService.processTransaction(transaction);
	    }
	    
	  
	    
	    @GetMapping("/customer/{id}")
	    public ResponseEntity<List<Account>>getAccountsforCustomer(@PathVariable Long id){
	    	
	    	Customer customer = customerService.getById(id);
	    	 if (customer == null) {
	    	        return ResponseEntity.notFound().build();
	    	    }

	    	    List<Account> accounts = accountService.getAccountsById(customer);
	    	    return ResponseEntity.ok(accounts);
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    @PostMapping("/{customerId}")
//	    public ResponseEntity<List<Account>> createAccountsForCustomer(
//	            @PathVariable Long customerId,
//	            @RequestBody List<String> accountNumbers
//	    ) {
//	        List<Account> createdAccounts = accountService.createAccountsForCustomer(customerId, accNo);
//
//	        if (createdAccounts.isEmpty()) {
//	            // No accounts were created, return an appropriate response
//	            return ResponseEntity.badRequest().build();
//	        }
//
//	        // Return the list of created accounts with a "201 Created" status
//	        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccounts);
//	    }
	    
	   
	        
	    

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

//	    @PostMapping("/{id}/deposit")
//	    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//	        Double amount = request.get("amount");
//	        return accountService.deposit(id, amount);
//	    }
//
//	    @PostMapping("/{id}/withdraw")
//	    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//	        Double amount = request.get("amount");
//	        return accountService.withdraw(id, amount);
//	    }
	}


