package com.cg.bam.service;

import com.cg.bam.dto.Customer;
import com.cg.bam.exception.BamException;



public interface BamService {
	
	
public void createAccount(Customer customer);
	
	public void deposit(String mobileNo, double amount);
	
	public void withdraw(String mobileNo, double amount);
	
	public double checkBalance(String mobileNo);
	
	public void fundTransfer(String sender, String reciever, double amount);
	
	
	public boolean validateAccount(String mobileNo) throws BamException;
	
	public boolean validateName(String name) throws BamException;
	
	public boolean validateAge(float age) throws BamException;
	
	public boolean validateMoileNo(String mobileNo) throws BamException;
	
	public boolean validateAmount(double amount) throws BamException;
			
	public void getTransactionList(String mobileNo);

}
