/** 
*   <h1>Account Holder<h1>
*   The AccountHolder program will allow users to create an initial balance,
*   enter deposits or withdrawals and will print information about interests 
*   and rates.
*   @author Maria Garcia Fernandez
*   @version 2.0
*   @since 2017-01-14
*/

public class AccountHolder{
	/**
	 *  Class private variables 
	 */
	private static double annualInterestRate = 0.04;
	private double balance;
	
	/**
	 * Constructor method
	 * It will prompt an error message in case the balance is negative
	 * @param balance is initial value that should be assigned to the account
	 * holder member
	 */
	public AccountHolder(final double balance){
		// In case the balance is negative notify
		if(balance<0){
			System.out.println("Negative balances are not allowed. Please introduce a positive amount.");
		} else {
			this.balance = balance;
			System.out.println("Your current balance is "+toString()+"\n");
		}
	}
	
	/**
	 * This method will increase the balance of the account holder member with the amount of money that he or she deposits.
	 * @param deposit is the amount of money that the user would like to save in his/her account
	 */
	public void deposit(double deposit){
		if(deposit>=0){
			balance += deposit;
			System.out.println("Your balance after the deposit of $"+deposit+" is of "+toString()+".\n");
		} else {
			System.out.println("Negative deposits are not allowed. Please introduce a positive deposit amount.");
		}
	}
	
	/**
	 * This method will decrease the balance of the account holder member with the amount of money that
	 * he or she withdraws in case the amount of money to withdraw leave the account balance above $100.
	 * Otherwise,
	 * @param withdrawal is the amount of money that the user would like to retire from his/her account
	 */
	public void withdrawal(final double withdrawal){
		if(withdrawal<0){
	    	// Notify that the withdrawal amount introduce should be a positive number. 
	    	System.out.println("The withdrawal amount is incorrect. Please introduce a positive amount of money.");
	    } else {
	    	if((getBalance()-withdrawal)>=100){	
	    		// Decrease the balance amount
			    balance -= withdrawal;
			    // Notify the balance after the withdrawal 
	    		System.out.println("Your balance after the withdrawal of $"+withdrawal+" is "+toString()+".\n");	
	    	} else {
	    		// Notify that the balance after the withdrawal will be bellow $100 in order to ask to the user if he/she wants to continue.
	    		System.out.println("Your balance will be bellow $100 after the withdrawal of $"+withdrawal+". Are you sure you want to continue and leave your balance in $"+(getBalance()-withdrawal)+"?");
	    		System.out.println("Answer with: YES/NO");	
	    	}
	    }
	}
	
	/**
	 * This method update the account holder's balance by considering the monthly interest rate.
	 */
	public void monthlyInterest(){
		balance += balance * (annualInterestRate / 12.0);
	}
	
	/**
	 * The modifyMonthlyInterest method update the rate used as monthly interest for an specific user.
	 * Also, it will notify if the rate is incorrect in order to change it.
	 * @param rateUpdate is the new rate that should be applied to the account holder member.
	 */
	public void modifyMonthlyInterest(double rateUpdate){
		if(0 <= rateUpdate && rateUpdate <= 1.0){
			annualInterestRate = rateUpdate;
			System.out.println("The new monthly interest rate has change to "+annualInterestRate+".\n");
		} else {
			System.out.println("The new monthly interest rate is invalid. Please enter a rate between 0 and 1.");
		}
	}
	
	/**
	 * This method formats the balance account value in order to have only two decimals.
	 * @return The account holder's balance formated
	 */
	public String toString(){
		return String.format("$%.2f", balance);
	}
	
	/**
	 * This method return the current balance of an user
	 * @return the current balance of the account holder member
	 */
	public double getBalance(){
		return balance;
	}
	
	/**
	 * This method will set the current balance of an user to his/her account
	 * @param balance is the amount that should be set in the member's account
	 */
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	/**
	 * This method return the monthly interest rate 
	 * @return the monthly interest rate of the account
	 */
	public double getInterest(){
		return annualInterestRate;
	}
	
	/**
	 * This method withdraws the amount of money pass as a parameter to the current account balance
	 * @param withdrawal the amount of money that the user wants to retire
	 */
	public void forceWithdrawal(double withdrawal){
		balance -= withdrawal;
	}
	
	/**
	 * This method update the account holder's balance by considering the monthly interest rate.
	 * @return the monthly balance with interest
	 */
	public double getMonthlyInterest(){
		balance += balance * (annualInterestRate / 12.0);
		return balance;
	}
	
	/**
	 * This method will print all the monthly balance considering the interest.
	 */
	public void printMonthlyInterest(){
		System.out.println("The monthly balances with the interest included during one year with an annual interest rate of "+getInterest()+ " are shown below:");
		// Print the monthly balances
		System.out.printf("%-10.10s  %-10.10s%n", "Base", toString());
		for(int i =0; i<12;i++) {
			System.out.printf("%-10.10s  %-10.10s%n", "Month "+(i+1)+": ", String.format("$%.2f", getMonthlyInterest()));
		}
		System.out.println("\nDo you want to modify the annual interest rate? Answer with: YES/NO");	
	}
	
	/**
	 * This method will print all the monthly balance considering the interest.
	 * @return newBalance is the final balance after having applied the interest for a year.
	 */
	public String getFinalMonthlyInterest(){
	    double newBalance = 0;
	    for(int i =0; i<12;i++) {
			newBalance = getMonthlyInterest();
		}
		return "The final monthly balance after a year of interests is: "+String.format("$%.2f", newBalance)+".\n";
	}
}


