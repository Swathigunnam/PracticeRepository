package com.abc.banking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abc.banking.entities.Account;
import com.abc.banking.entities.Customer;
import com.abc.banking.entities.Transaction;
import com.abc.banking.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;


public interface AccountService {

   
    
    Account createAccount(Account account, Long customerId);
   
    
    List<Account> getAccountsById(Customer customer);
    List<Account> createAccountsForCustomer(Long customerId, List<String> accountNumbers);
    Transaction processTransaction(Transaction transaction);
    
    
    
    
    
    
    
//
//    public Account createAccount(Account account) {
//        return accountRepository.save(account);
//    }
//
//    public Optional<Account> getAccount(Long id) {
//        return accountRepository.findById(id);
//    }

 
//    
//    public Account deposit(Long id, double amount) {
//        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
//        account.setBalance(account.getBalance() + amount);
//        return accountRepository.save(account);
//    }
//
//    public Account withdraw(Long id, double amount) {
//        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
//        if (account.getBalance() < amount) {
//            throw new RuntimeException("Insufficient funds");
//        }
//        account.setBalance(account.getBalance() - amount);
//        return accountRepository.save(account);
//    }
}