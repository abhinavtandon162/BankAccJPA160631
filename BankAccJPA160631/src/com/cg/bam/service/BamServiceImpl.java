package com.cg.bam.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.bam.dao.BamDAOImpl;
import com.cg.bam.dto.Customer;
import com.cg.bam.exception.BamException;


public class BamServiceImpl implements BamService {

	BamDAOImpl dao = new BamDAOImpl();
	
	@Override
	public void createAccount(Customer customer) {
		dao.createAccount(customer);
		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		dao.deposit(mobileNo, amount);
		
	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		dao.withdraw(mobileNo, amount);
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		
		return dao.checkBalance(mobileNo);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		dao.fundTransfer(sender, reciever, amount);
		
	}

	@Override
	public boolean validateAccount(String mobileNo) throws BamException {
		
		return dao.validateAccount(mobileNo);
	}

	@Override
	public boolean validateName(String name) throws BamException {
		try{
			if(name == null)
				throw new BamException("Null value found");
			Pattern p = Pattern.compile("[A-Z]{1}[a-z]{3,20}");
			Matcher m = p.matcher(name); 
			if(!m.matches())
				System.out.println("Name invalid!, please enter correct name..");
			return m.matches();
		}catch(BamException e){
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean validateAge(float age) throws BamException {
		try{
			// TODO Auto-generated method stub
			if(age == 0)
				throw new BamException("Age cannot be  null");
			else if(age < 0)
				throw new BamException("Age cannot be a negative number");
			else if(age >17)
				return true;
			
		
	} catch (Exception e) {
		System.out.println(e);
	}
		return false;
	}

	@Override
	public boolean validateMoileNo(String mobileNo) throws BamException {
		try{
			// TODO Auto-generated method stub
			if(mobileNo == null)
				throw new BamException("Null value found");
			Pattern p = Pattern.compile("[0-9]{10}");
			Matcher m = p.matcher(mobileNo);
			if(!m.matches())
				System.out.println("Mobile Number Invalid!");
			return m.matches();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean validateAmount(double amount) throws BamException {
		try{
			if(amount == 0)
				throw new BamException("Null value found, please enter monbile no again");
			String am = String.valueOf(amount);
			if(!am.matches("\\d{1,9}\\.\\d{0,3}"))
				System.out.println("Invalid Amount!");
			return (am.matches("\\d{1,9}\\.\\d{0,3}"));
		}catch(BamException e){
			System.out.println(e);
		}
		return false;
	}

	@Override
	public void getTransactionList(String mobileNo) {
		dao.getTransactionList(mobileNo);
		
	}

}
