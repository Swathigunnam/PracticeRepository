package com.abc.banking.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "trans_tbl")
	public class Transaction {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "trans_id")
		private long tranID;

		
		@CreationTimestamp
		@Column(name = "trans_date")
		private LocalDate tranDate;

		@Column(name = "source_acc")
		private long sourceAcc;
		
		@Column(name = "transaction_type")
		private String transactionType;
		

		@Column(name = "target_acc")
		private long targetAcc;

		@Column(name = "amount")
		private double amount;

		@ManyToOne
		@JoinColumn(name="acc_id")
		@JsonIgnore
		private Account account;

		public long getTranID() {
			return tranID;
		}

		public void setTranID(long tranID) {
			this.tranID = tranID;
		}

		public LocalDate getTranDate() {
			return tranDate;
		}

		public void setTranDate(LocalDate tranDate) {
			this.tranDate = tranDate;
		}

		public long getSourceAcc() {
			return sourceAcc;
		}

		public void setSourceAcc(long sourceAcc) {
			this.sourceAcc = sourceAcc;
		}

		public long getTargetAcc() {
			return targetAcc;
		}

		public void setTargetAcc(long targetAcc) {
			this.targetAcc = targetAcc;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}
		

		public String getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}

		

		public Transaction(long tranID, LocalDate tranDate, long sourceAcc, String transactionType, long targetAcc,
				double amount, Account account) {
			super();
			this.tranID = tranID;
			this.tranDate = tranDate;
			this.sourceAcc = sourceAcc;
			this.transactionType = transactionType;
			this.targetAcc = targetAcc;
			this.amount = amount;
			this.account = account;
		}

		public Transaction() {
			super();
		}

		@Override
		public String toString() {
			return "Transaction [tranID=" + tranID + ", tranDate=" + tranDate + ", sourceAcc=" + sourceAcc
					+ ", transactionType=" + transactionType + ", targetAcc=" + targetAcc + ", amount=" + amount
					+ ", account=" + account + "]";
		}

		
	
	
		
	
}




