package core;
import java.util.*;
/**
 * 
 * @author CharlieBreshears
 *
 */

public class BankAccount {
	/**
	 * 
	 * @param args
	 */
	public static void main (String[]args){
		Scanner input = new Scanner(System.in);
		defaultConst obj = new defaultConst(); // creates a object of the default constructor
		BankAccount class1 = new BankAccount(); // creates object of the class so we can call methods
		BankAccount class2 = new BankAccount(); // creates object of the class so we can call methods
		
		System.out.println("Please enter the balance before interest: ");
		double myBalance = input.nextDouble();
		
		System.out.println("Please enter the account type 1-savings 2- award savings 3- checking 4- credit card: ");
		int myAccountType = input.nextInt();
		
		System.out.println("Please enter the account number: ");
		String myAccountNumber = input.next();
		
		System.out.println("Please enter the name of the account holder: ");
		String myAccountHolder = input.next();
		
		double interest;
		double x;
		
		obj.setBalance(myBalance);
		obj.setAccountType(myAccountType);
		obj.setAccountNumber(myAccountNumber);
		obj.setAccountHolder(myAccountHolder);
		
		if (obj.getAccountType() == 1){
			interest = class2.getInterestRate(1);
			x= class1.calculateTotalBalance(myBalance, interest);
			System.out.println("The total balance is: "+ x);
			
			 
			
		}
		else if (obj.getAccountType() == 2){
			interest = class2.getInterestRate(2);
			x= class1.calculateTotalBalance(myBalance, interest);
			System.out.println("The total balance is: "+ x);
			
		}
		else if (obj.getAccountType() == 3){
			interest = class2.getInterestRate(3);
			x= class1.calculateTotalBalance(myBalance, interest);
			System.out.println("The total balance is: "+ x);
			
		}
		else if (obj.getAccountType() == 4){
			interest = class2.getInterestRate(4);
			x= class1.calculateTotalBalance(myBalance, interest);
			System.out.println("The total balance is: "+ x);
			
		}
		
		else{
			System.out.println("Enter a valid number");
		}
		

	}// end main
	
	public double getInterestRate(int x){
		double rate = 0;
		if (x == 1){
			rate = .5;
			return rate;
		}
		else if (x == 2){
			rate = 4.5;
			return rate;
		}
		else if (x == 3){
			rate = 1.0;
			return rate;
		}
		else if (x ==4){
			rate = 15;
			return rate;
		}
		else{
			return rate;
		}
	}
	
	public double calculateTotalBalance(double balance, double interest){
		double totalBalance = balance +(balance*interest/100);
		return totalBalance;
	} // end calculateTotalBalance

}// end class BankAccount

class defaultConst{
		private double balance = 0;
		private int accountType = 0;
		private String accountNumber ="none";
		private String accountHolder = "unknown";
	 public defaultConst(){

	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
}//end class defaultConst
