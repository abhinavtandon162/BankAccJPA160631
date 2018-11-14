package com.cg.bam.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Column
	private String custName;
	
	@Id
	@Column(name="mobile_no")
	private String custMobileNo;
	
	@Column
	private float custAge;
	
	@Column(name="init_bal")
	private double custInitialBalance;
	
	public Customer() {
	
	}

	public Customer(String name, String mobileNo, float age,
			double initialBalance) {
	
		this.custName = name;
		this.custMobileNo = mobileNo;
		this.custAge = age;
		this.custInitialBalance = initialBalance;
	}

	public String getName() {
		return custName;
	}

	public void setName(String name) {
		this.custName = name;
	}

	public String getMobileNo() {
		return custMobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.custMobileNo = mobileNo;
	}

	public float getAge() {
		return custAge;
	}

	public void setAge(float age) {
		this.custAge = age;
	}

	public double getInitialBalance() {
		return custInitialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.custInitialBalance = initialBalance;
	}	
	
	
}
