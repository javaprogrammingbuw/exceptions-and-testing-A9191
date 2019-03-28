package exceptions;

import java.util.Random;

	public class BankAccount {
	private static final String bic = "ABCDDEFFXXX" ;
	private String iban = "DE00123456780000000000";
	private int securityNumber;
	private Person owner;
	private double limit;
	private double balance;
	
	public BankAccount(Person owner, double limit, double balance){
		this.owner=owner;
		this.balance=balance;		
		if(this.limit>0){
			this.limit=limit;
		}
		String j = "";
		Random randomno = new Random();
		for(int i = 0; i<7; i++){
			j+=this.securityNumber= randomno.nextInt(10);		
			this.securityNumber = Integer.parseInt(j);
		}
		
		iban = iban.substring(0, 11);
		for(int i = 0; i<10; i++){
			iban+=new Random().nextInt(10);
		}								
	}
	
	public BankAccount(Person owner, double balance){
		this.owner=owner;
		this.balance=balance;		
		String j = "";
		Random randomno = new Random();
		for(int i = 0; i<7; i++){
			j+=this.securityNumber= randomno.nextInt(10);
		}
		this.securityNumber = Integer.parseInt(j);	
		iban = iban.substring(0, 11);
		for(int i = 0; i<10; i++){
			iban+=new Random().nextInt(10);
		}								
	}
	
	public double getbalance(){
		return balance;
	}
	
	public String getiban(){
		return iban;
	}
	
	public Person getowner(){
		return owner;
	}
	
	public double getlimit(){
		return limit;
	}
	public void setbalance(double balance){
		this.balance=balance;
	}
	
	public double deposit(double amount, int securityNumber){		
		if(securityNumber==this.securityNumber){
			balance = balance + amount;
			return balance;	
		}
		else {			
		
		return balance;
		}
	}
	public double withdraw(double amount, int securityNumber){		
		if((securityNumber==this.securityNumber)&&(amount<=limit)){							
		balance = balance - amount;
		return balance;
		}
		else {			
		
		return balance;
		}
	}
	
	public void transfer(BankAccount remote, double amount, int securityNumber){
		if((securityNumber==this.securityNumber)&&(amount<=limit)){							
			 remote.setbalance(remote.getbalance()+amount);
			 setbalance(balance - amount);
		}
	}	

}