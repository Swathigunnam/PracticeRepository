package com.abc.banking.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


	
	@Entity
	@Table(name = "account_tbl")
	public class Account {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "acc_id")
		private int accId;
//
//		@Column (name = "acc_no")
//		private String accNo;

		@Column(name = "balance")
		private double currentBalance;

		@ManyToOne
		@JoinColumn(name="id")
		@JsonIgnore
		private Customer customer;

		@OneToMany(mappedBy="account" ,cascade = CascadeType.ALL)
		private List<Transaction> transaction;

		public int getAccId() {
			return accId;
		}

		public void setAccId(int accId) {
			this.accId = accId;
		}

//		public String getAccNo() {
//			return accNo;
//		}

//		public void setAccNo(String accNo) {
//			this.accNo = accNo;
//		}

		public double getCurrentBalance() {
			return currentBalance;
		}

		public void setCurrentBalance(double currentBalance) {
			this.currentBalance = currentBalance;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<Transaction> getTransaction() {
			return transaction;
		}

		public void setTransaction(List<Transaction> transaction) {
			this.transaction = transaction;
		}

		public Account(int accId, String accNo, double currentBalance, Customer customer, List<Transaction> transaction) {
			super();
			this.accId = accId;
			//this.accNo = accNo;
			this.currentBalance = currentBalance;
			this.customer = customer;
			this.transaction = transaction;
		}

		public Account() {
			super();
		}

		@Override
		public String toString() {
			return "Account [accId=" + accId  + ", currentBalance=" + currentBalance + ", customer="
					+ customer + ", transaction=" + transaction + "]";
		}

		
		
			
	    
	   
	}


