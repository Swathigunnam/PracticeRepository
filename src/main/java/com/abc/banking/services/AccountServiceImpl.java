package com.abc.banking.services;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.abc.banking.entities.Account;
import com.abc.banking.entities.Customer;
import com.abc.banking.entities.Transaction;
import com.abc.banking.repositories.AccountRepository;
import com.abc.banking.repositories.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Validated
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TransactionService transactionService;


	@Override
	@Transactional
	public Account createAccount(Account account, Long customerId) {

		Customer customer = new Customer();
		customer.setId(customerId);
		account.setCustomer(customer);
		return accountRepository.save(account);
	}



	@Override
	public List<Account> createAccountsForCustomer(Long customerId, List<String> accountNumbers) {
		// TODO Auto-generated method stub
		return null;
	}

	



	@Override
	@Transactional
	public List<Account> getAccountsById(Customer customer){
		return accountRepository.findByCustomer(customer);
	}



	@Override
public Transaction processTransaction(Transaction transaction) {
	switch(transaction.getTransactionType()) {

		case "DEPOSIT":

		long targetId = transaction.getTargetAcc();
		double amount = transaction.getAmount();

		
		Account target= accountRepository.getById(targetId);
		
		target.setCurrentBalance(target.getCurrentBalance()+amount);
		transaction.setAccount(target);
		accountRepository.save(target);

		return transactionService.createTransaction(transaction);

	case "WITHDRAW":

		long withdrawId= transaction.getSourceAcc();
		double withdrawAmount = transaction.getAmount();

			Account withdrawTarget= accountRepository.getById(withdrawId);
		//Account withdrawTarget = accountRepository.findById(withdrawId).orElse(null);
		
		
	transaction.setAccount(withdrawTarget);
	withdrawTarget.setCurrentBalance(withdrawTarget.getCurrentBalance()-withdrawAmount);
		accountRepository.save(withdrawTarget);

		return transactionService.createTransaction(transaction);

		case "TRANSFER":

		long fromAccount= transaction.getSourceAcc();
		long toAccount= transaction.getTargetAcc();

		double transactionAmount = transaction.getAmount();

			Account fromAccountObj= accountRepository.getById(fromAccount);
		Account toAccountObj= accountRepository.getById(toAccount);

			fromAccountObj.setCurrentBalance(fromAccountObj.getCurrentBalance()-transactionAmount);

		toAccountObj.setCurrentBalance(toAccountObj.getCurrentBalance()+transactionAmount);
		transaction.setAccount(fromAccountObj);

			Transaction toTransaction = new Transaction();
		toTransaction.setAmount(transactionAmount);
			toTransaction.setSourceAcc(toAccount);
			toTransaction.setTargetAcc(fromAccount);
			toTransaction.setAccount(toAccountObj);
			toTransaction.setTransactionType("DEPOSIT");
		transactionService.createTransaction(toTransaction);

		accountRepository.save(fromAccountObj);


			accountRepository.save(toAccountObj);


			return transactionService.createTransaction(transaction);



		}
		return null;
	}
}


	//public Account getAccount(Long id) {
	//	        return accountRepository.findById(id)
	//	                .orElse(null); // Handle the case where the account is not found
	//	    }

	//	@Override
	//    public List<Account> getAccountsById(Long customerId) {
	//        return accountRepository.findByCustomerId(customerId);
	//    }



	//    
	//    @Override
	//    public List<Account> createAccountsForCustomer(Long Id, List<String> accNo) {
	//        // Find the customer by ID
	//        Customer customer = customerRepository.findById(Id)
	//            .orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + Id));
	//        
	//     // Create a list of accounts and associate them with the customer
	//        List<Account> accounts = new ArrayList<>();
	//        for (String accNos : accNo) {
	//            Account account = new Account();
	//            account.setAccNo(accNo);
	//            account.setCustomer(customer);
	//            accounts.add(account);
	//        }

	// Save the accounts
	// return accountRepository.saveAll(accounts);










	