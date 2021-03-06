package com.cg.bam.ui;

import java.util.Scanner;

import com.cg.bam.dto.Customer;
import com.cg.bam.exception.BamException;
import com.cg.bam.service.BamServiceImpl;



public class Client {

	public static void main(String[] args) throws BamException {
		BamServiceImpl service = new BamServiceImpl();

		Scanner sc = new Scanner(System.in);

		String name,mobileNo;
		float age;
		double amount;
		int ch = 0;
		do{
			System.out.println("1.Add Customer\n2.Deposit amount\n3.Withdraw Amount\n4.Fund transfer\n5.Check balance\n6.Print Transaction\n7.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			Customer customer = new Customer();
			switch(ch){
			case 1 :
										

				do{
					System.out.println("Enter customer name : ");
					name = sc.next();
					if(!service.validateName(name))
						System.err.println("Name not valid\n");
					else
						break;
				}while(true);
				
				do{
					System.out.println("Enter mobile no. : ");
					mobileNo = sc.next();
					if(!service.validateMoileNo(mobileNo))
						System.out.println("Mobile number not valid!!!");
					else if(service.validateAccount(mobileNo))
						System.out.println("Account already exist with this number!\nPlease try again!!");
					else
						break;								
				}while(true);
				
				do{
					System.out.println("Enter age : ");
					age = sc.nextFloat();
					if(service.validateAge(age))
						break;
				}while(true);
				
				do{
					System.out.println("Enter initial amount : ");
					amount = sc.nextDouble();
					if(!service.validateAmount(amount))
						System.out.println("Amount not valid!!!");
					else
						break;							
				}while(true);



				customer.setName(name);
				customer.setMobileNo(mobileNo);
				customer.setAge(age);
				customer.setInitialBalance(amount);

				service.createAccount(customer);						

				break;

			case 2 :
				do{
					System.out.println("Enter your mobile number : ");
					mobileNo = sc.next();
					if(!service.validateMoileNo(mobileNo))
						System.out.println("Please enter valid mobile number!!!");
					else if(!service.validateAccount(mobileNo))
						System.out.println("Account already exist with this number!\nPlease try again!!");
					else
						break;
				}while(true);
				
				do{
					System.out.println("Enter the amount you want to deposit");
					amount = sc.nextDouble();
					if(!service.validateAmount(amount))
						System.out.println("Amount not valid!!!");														
					else
						break;

				}while(true);

				service.deposit(mobileNo, amount);					

				break;

			case 3 :
				do{
					System.out.println("Enter your mobile number : ");
					mobileNo = sc.next();
					if(!service.validateMoileNo(mobileNo))
						System.out.println("Please enter a valid mobile number!!!!!");
					else if(!service.validateAccount(mobileNo))
						System.out.println("Account already exist with this number!\nPlease try again!!");
					else
						break;
				}while(true);
				do{
					System.out.println("Enter the amount you want to withdraw : ");
					amount = sc.nextDouble();
					if(service.validateMoileNo(mobileNo) && service.validateAmount(amount)){
						if(service.validateAccount(mobileNo))
							break;
					}
				}while(true);

				service.withdraw(mobileNo, amount);

				break;

			case 4 :
				String mobileNoReciever;
				do{
					System.out.println("Enter your mobile number : ");
					mobileNo = sc.next();

					System.out.println("Enter the amount you want to transfer : ");
					amount = sc.nextDouble();

					System.out.println("Enter receivers mobile number : ");
					mobileNoReciever = sc.next();
					if(mobileNo.equals(mobileNoReciever)){								
						System.out.println("Both numbers are same!\nPlease enter unique numbers...");
						continue;
					}
					if(service.validateMoileNo(mobileNo) && service.validateMoileNo(mobileNoReciever) && service.validateAmount(amount)){
						if(service.validateAccount(mobileNoReciever) && service.validateAccount(mobileNo))
							break;
					}
				}while(true);
				service.fundTransfer(mobileNo, mobileNoReciever, amount);

				break;

			case 5 :
				do{
					System.out.println("Enter the moible id to check balance");
					mobileNo = sc.next();
					if(service.validateMoileNo(mobileNo)){
						if(service.validateAccount(mobileNo))																	
							break;
						else
							System.out.println("Mobile number not found.\nPlease enter correct mobile number.");
					}
					else{
						System.out.println("Mobile number not valid!!!");
					}
				}while(true);

				System.out.println("Current Amount is Rs."+service.checkBalance(mobileNo));

				break;

			case 6 :
				do{
					System.out.println("Enter the moible id to get transaction");
					mobileNo = sc.next();
					if(service.validateMoileNo(mobileNo)){
						if(service.validateAccount(mobileNo))																	
							break;
						else
							System.out.println("Mobile number not found.\nPlease enter correct mobile number.");
					}
					else{
						System.out.println("Please enter valid mobile number!!!");
					}
				}while(true);

				service.getTransactionList(mobileNo);
				break;

			case 7 :
				System.exit(0);
				break;
			default : System.out.println("Invalid input!");
			}

		}while(ch != 7);



	}

}
