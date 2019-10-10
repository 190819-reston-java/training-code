package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Account implements Serializable {

	private static final long serialVersionUID = 3532624247166303363L;

	private int amount;

	public Account() {
		super();
	}

	public Account(int amount) {
		super();
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public boolean deposit(int amount) {
		this.amount += amount;
		return true;
	}
	
	public boolean withdraw(int amount) throws ArithmeticException {
		if(this.amount < amount) {
			throw new ArithmeticException();
		} else {
			this.amount -= amount;
		}
		
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		return amount == other.amount;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + "]";
	}
}
