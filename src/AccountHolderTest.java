import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/** 
*   <h1>Account Holder Test<h1>
*   The AccountHolderTest program will allow the user to interact with the application
*   and the programmer to check that everything works fine.
*   @author Maria Garcia Fernandez
*   @version 2.0
*   @since 2017-01-14
*/

public class AccountHolderTest {
	
	/**
	 * This is the main method that with which the bank will interact with the user.
	 * @param args Unused
	 */
	public static void main(String args[]){
		// Introduce a Scanner class object
		Scanner sc = new Scanner(System.in);
		// Declare and initialize the variables
		String strName = "";
		String strBalance = "";
		String strDeposit = "";
		String strWithdrawal = "";
		String strOperation = "";
		String strAnswer = "";
		String strAnswer2 = "";
		String strRate = "";
		AccountHolder aH = null;
	    // Greet the account holder member	
	    System.out.println("Welcome to the Account Holder App");
	    // Prompt user for their name
	    System.out.println("\nPlease enter your name below:");
	    // Read the user name
	    strName = sc.nextLine();
	    // Display the name back to the user and ask to enter an initial account balance
	    System.out.println("Hello " + strName+", please enter in an initial balance amount:");
	    // Flag to know if the scanned value is a number
	    boolean balanceIsNumber = false;
	    do{
	    	try{
		    	// Read the initial balance till the user introduces a positive value
		    	strBalance = sc.nextLine();
		    	// Create an account holder with the constructor with a positive balance as a parameter
		    	aH = new AccountHolder(Double.parseDouble(strBalance));
		    	// If the scanned string is a double or integer value stop the while loop with the boolean flag
		    	if(Double.parseDouble(strBalance)>=0){
		    		balanceIsNumber=true;
		    	}
	    	} catch(Exception e){
	    		System.out.println("Please introduce a valid positive number. Other characters are not allowed.");
	    	}
	    } while (!balanceIsNumber);
	    
	    while(!strOperation.equals("4")){
	    	// Ask the user what operations need
		    System.out.println("Please introduce the number of the operation you need:");
		    System.out.println("1. Deposit");
		    System.out.println("2. Withdrawal");
		    System.out.println("3. Show monthly balances");
		    System.out.println("4. Exit");
		    // Read the operation selected
		    strOperation = sc.nextLine();
	    	if(strOperation.equals("1")){
	    		// Flag to know if the scanned value is a number
	    		boolean depositIsNumber = false;
			    // Ask the user to enter in a deposit amount
			    System.out.println("\nPlease enter in a deposit amount:");
			    do{
			    	try{
				    	// Read the deposit amount
					    strDeposit = sc.nextLine();
					    // Increase the balance amount
					    aH.deposit(Double.parseDouble(strDeposit));
					    // If the scanned string is a double or integer value stop the while loop with the boolean flag
					    if(Double.parseDouble(strDeposit)>=0){
						    depositIsNumber = true;
					    }
			    	} catch (Exception e){
			    		System.out.println("Please introduce a valid positive number. Other characters are not allowed.");
			    	}
			    } while (!depositIsNumber);
	    	} else if(strOperation.equals("2")) {
			    // Ask the user to enter in a withdrawal amount
			    System.out.println("\nPlease enter in a withdrawal amount:");
			    // Flag to know if the scanned value is a number
			    boolean withdrawalIsNumber = false;
			    do{
			    	try{
					    // Read the withdrawal amount
					    strWithdrawal = sc.nextLine();
					    aH.withdrawal(Double.parseDouble(strWithdrawal));
					    // If the scanned string is a double or integer value stop the while loop with the boolean flag
					    if(Double.parseDouble(strWithdrawal)>=0){
					    	withdrawalIsNumber = true;
					    }
					    // If the balance gets under $100. Ask the user if he/she wants to continue.
					    if((aH.getBalance()-Double.parseDouble(strWithdrawal))<100){	
						    // Read answer
						    strAnswer = sc.nextLine();
						    if(strAnswer.equals("YES")){
						    	// Decrease the balance amount
						    	aH.forceWithdrawal(Double.parseDouble(strWithdrawal));
							    System.out.println("Now your balance is "+aH.toString()+".\n");
						    } else {
						    	System.out.println("The withdrawal was cancel. Your balance is "+aH.toString()+".\n");
						    }
					    } else {}
			    	} catch (Exception e){
			    		System.out.println("Please introduce a valid positive number. Other characters are not allowed.");
			    	}
			    } while(!withdrawalIsNumber);
	    	} else if(strOperation.equals("3")) {
	    		double auxBalance = aH.getBalance();
	    		// Print the monthly balance considering the default interest 0.04
	    		aH.printMonthlyInterest();
	    		// Read answer
			    strAnswer2 = sc.nextLine();
			    // Reset the balance account before calculating the monthly interest balance
	    		aH.setBalance(auxBalance);
			    if(strAnswer2.equals("YES")){
				    // Flag to know if the scanned value is a number
		    		boolean rateIsNumber = false;
				    // Ask the user to enter in an interest rate
		    		System.out.println("Please introduce the new annual interest rate:");
				    do{
				    	try{
				    		// Read the new rate
						    strRate = sc.nextLine();
						    // Modify the interest of the account
						    aH.modifyMonthlyInterest(Double.parseDouble(strRate));
						    // If the scanned string is a double or integer value stop the while loop with the boolean flag
						    if(Double.parseDouble(strRate)>=0 && Double.parseDouble(strRate)<=1) {
							    rateIsNumber = true;
						    }
				    	} catch (Exception e){
				    		System.out.println("Please introduce a valid interest rate. Other characters are not allowed. The new intereset value should be between 0 to 1.");
				    	}
				    } while (!rateIsNumber);
		    		// Print the final monthly balance considering the new interest 0.05
		    		System.out.println(aH.getFinalMonthlyInterest());
			    } else {
			    	System.out.println("The annual monthly rate has not been modified.");
			    }
	    	} else if(strOperation.equals("4")) {
	    		// Thank the user for using the app
			    System.out.println("\nThank you. We hope to see you soon.");
			    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			    System.out.println("\nCur dt=" + timeStamp + "\nProgrammed by Maria Garcia Fernandez\n");
	    	} else {
	    		// Notify the user that the operation selected was not correct
			    System.out.print("\nIt seems that you have not choose any of the available operations.");
	    	}
	    }
	    sc.close();
	}
}
