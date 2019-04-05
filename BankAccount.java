
import java.util.Random;

public class BankAccount {
	static final String bic = "ABCDDEFFXXX" ;
	String iban = "DE00123456780000000000";
	int securityNumber;
	Person owner;
	double limit;
	double balance;
	
	public BankAccount(Person owner, double balance, double limit){
		this.owner=owner;
		this.balance=balance;
		if(limit>0){
			this.limit=limit;
		}
		String j = "";
		Random randomno = new Random();
		for(int i = 0; i<6; i++){
			j+=this.securityNumber= randomno.nextInt(10);		
			this.securityNumber = Integer.parseInt(j);
		}
		
		iban = iban.substring(0, 12);
		for(int i = 0; i<10; i++){
			iban+=new Random().nextInt(10);
		}								
	}
	
	public BankAccount(Person owner, double balance){
		this.owner=owner;
		this.limit=0.0;
		this.balance=balance;		
		String j = "";
		Random randomno = new Random();
		for(int i = 0; i<6; i++){
			j+=this.securityNumber= randomno.nextInt(10);
		}
		this.securityNumber = Integer.parseInt(j);	
		iban = iban.substring(0, 12);
		for(int i = 0; i<10; i++){
			iban+=new Random().nextInt(10);
		}								
	}
	
	public double getBalance(){
		return balance;
	}
	
	public String getIBAN(){
		return iban;
	}
	
	public Person getOwner(){
		return owner;
	}

	public int getSecurityNumber(){
		return this.securityNumber;
	}
	
	public double getLimit(){
		return this.limit;
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
		if((securityNumber==this.securityNumber)&&(amount<=(this.balance+this.limit))){							
		this.balance = this.balance - amount;
		return this.balance;
		}
		else {			
		
		return this.balance;
		}
	}
	
	public void transfer(BankAccount remote, double amount, int securityNumber){
		if((securityNumber==this.securityNumber)&&(amount<=balance+limit)){							
			 remote.setbalance(remote.getBalance()+amount);
			 setbalance(balance - amount);
		}
	}	

}