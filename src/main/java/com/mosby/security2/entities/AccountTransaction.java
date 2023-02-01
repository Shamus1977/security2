package com.mosby.security2.entities;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_transaction")
public class AccountTransaction {

	@Id
	private String transactionId;
	
	private Integer accountNumber;
	
	private Integer userId;
	
	private Date transactionDt;
	
	private String transactionSummary;
	
	private String transactionType;
	
	private Integer transactionAmt;
	
	private Integer closingBalance;
	
	private Date createDt;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

	public String getTransactionSummary() {
		return transactionSummary;
	}

	public void setTransactionSummary(String transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(Integer transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public Integer getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Integer closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public String toString() {
		return "AccountTransaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", userId="
				+ userId + ", transactionDt=" + transactionDt + ", transactionSummary=" + transactionSummary
				+ ", transactionType=" + transactionType + ", transactionAmt=" + transactionAmt + ", closingBalance="
				+ closingBalance + ", createDt=" + createDt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(transactionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountTransaction other = (AccountTransaction) obj;
		return Objects.equals(transactionId, other.transactionId);
	}
	
}
