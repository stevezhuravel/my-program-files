// Steve zhuravel
import java.util.*;
import java.io.*;
// need to input files 
public class bankaccount {
	public static void main(String[] args) throws IOException {
		Scanner keyboard=new Scanner(System.in);
		PrintWriter pw = new PrintWriter("bankoutput.txt");
		final int MAXSIZE = 50;
		
		int []acctnum = new int[MAXSIZE];
		int num_accts = 0, test = 0;
		char select;
		double []balance = new double[MAXSIZE];
		num_accts=readAccts(acctnum,balance, MAXSIZE, pw);
		 
		do {
		printAccts( acctnum, balance, num_accts, pw);
		menu();
		System.out.println("Make a selection");
		select=keyboard.next().charAt(0);
			switch(select) {
			case 'W':
			case 'w': 
				withdrawal( acctnum, balance, num_accts, keyboard, pw);
					break;
			case 'D':
			case 'd':deposit(acctnum,  balance,  num_accts, pw);
				break;
			case 'N':
			case 'n': newAcct(acctnum, balance,num_accts, 
					keyboard, pw );
				break;
			case 'B':
			case 'b':balance( acctnum,  balance, num_accts, pw);
				break;
			case 'q':
			case 'Q':
				System.out.println("further transcation has been terminated");
				break;
			case 'x' :
			case 'X' :
				 deleteAcct( acctnum, balance,  num_accts, pw);
				 break;
			default:
				pw.println("wrong");
			}	
			}while(select !='Q' && select !='q');
	}

	
	 /* Method readAccts
  	 * Input: account number 
  	 Process: find out if it a real bank account or not 
  	 Output: printout the account number out 
  	 */	
	public static int readAccts(int[] acctnum, double[] balance, int max_accts, PrintWriter pw) 
			throws IOException{
		int numaccounts=0;

		File outputFile = new File("topic 7.txt");
		Scanner output = new Scanner(outputFile);
		
		 while(output.hasNext()) {
			acctnum[numaccounts]=output.nextInt();
			balance[numaccounts]=output.nextDouble();
			numaccounts++;
		}
					
		 output.close();
		return numaccounts;
	}
	 /* Method menu
  	 * Input: what you want to do 
  	 Process: 
  	 Output: the menu 
  	 */ 

	public static void menu() {
		System.out.println("W - withdrawal");
		System.out.println("D - deposit ");
		System.out.println("N - new accounts");
		System.out.println("B - balance");
		System.out.println("Q - quit");
		System.out.println("x- delete");
	}
	 /* Method findAcct
  	 * Input: The two numbers  
  	 Process:  
  	 Output: printout the sum
  	 */ 

	public static int findAcct(int[] acctnum, int num_accts, int account) {
		for(int i=0; i<num_accts; i++) 
			if(account== acctnum[i])
				return i;
		return -1;
	}
	 /* Method withdeawl
  	 * Input: the account number
  	 Process: subtract from what in your account 
  	 from how much you took out 
  	 Output: how much money left in your account
  	 */ 

	public static void withdrawal(int[] acctnum, double[] balance, 
		int num_accts, Scanner keyboard, PrintWriter pw)  {
		int acct, pos;
		double withdraw;
		
		System.out.println("Enter your account number: ");
		acct=keyboard.nextInt();	
		pos = findAcct(acctnum, num_accts, acct);
		if(pos== -1)
			pw.println("account not found");
		else {
			System.out.println("Enter withdraw ammount: ");
			Scanner keyboard1=new Scanner(System.in);
			withdraw=keyboard1.nextDouble();
			if(withdraw> balance[pos])
				pw.println("Not enough funds");
			else {
				balance[pos] -= withdraw;
				pw.println("Your withdrawl successful");
				pw.println("succeed ");
			
			}
		}
	}
	 /* Method deposit
  	 * Input: the account number and how much you want to put in  
  	 Process: adds to the exist balance
  	 Output: printout the current balance
  	 */ 

	public static void deposit(int[] acctnum, double[] balance, int num_accts, PrintWriter pw) {
		
		int acct, pos;
		Scanner keyboard=new Scanner(System.in);
		// prompt user to enter account number
		System.out.println("Enter your account number: ");
		acct=keyboard.nextInt();	
		pos = findAcct(acctnum, num_accts, acct);
		if(pos== -1)
			pw.println("account not found");
		else {
			// prompt user to enter amount to deposit
			System.out.println("Enter deposit ammount: ");
			double deposit1 = keyboard.nextDouble();
			if(deposit1 < 0)
				// prompt user to enter postive amount
				pw.println("deposit amount must be a positive number"
						+ ". Try again");
			else {
				balance[pos] +=deposit1;
				pw.println("Your deposit successful");
				pw.println("succeed ");
			}
		}
	}
	
	 /* Method newACct
  	 * Input: The account number 
  	 Process: 
  	 Output: the new account number with the balance
  	 */ 

	public static int newAcct(int[] acctnum, double[] balance, int num_accts, 
			Scanner input, PrintWriter pw ) throws IOException{
		int pos , acct;
		double bal;
		
		System.out.println("Welcome to our bank! Enter your new account");
		acct=input.nextInt();
		
		pos=findAcct(acctnum, num_accts, acct);
		
		if(pos>=0)
			pw.println("Sorry, account number " 
		+ acct + " is taken");
		else {
			acctnum[num_accts]=acct;
			balance[num_accts]=0;
			num_accts++;
			pw.println("account creaed!");
		}
		return num_accts;
	}
	 /* Method balance
  	 * Input: The account number 
  	 Process: is sees if it a real account or not
  	 Output: prints out if it a real account with it balance
  	 */ 

	public static void balance(int[] acctnum, double[] balance, int num_accts, PrintWriter pw) {
		int account, pos;
		double deposit;
		Scanner keyboard=new Scanner(System.in);
		//step one: prompt the user to enter their account number

		System.out.print("Enter account number : ");

		account = keyboard.nextInt();
		
		//step 2: send the acctnum array, num_accts, AND account
		//to the findAcct method. Assign the method call to the variable pos.

		pos = findAcct(acctnum, num_accts, account);

		 if (pos== -1) 
			 pw.println( "the account the user entered was not found");
		 else
			pw.println("Current balance $" + balance[pos]); 
	}
	 /* Method FindAcct
  	 * Input:  
  	 Process: 
  	 Output: if it finds the accoundit print it
  	 */ 
	 /* Method printAccts
  	 * Input:   
  	 Process: it add up acctnum and balance
  	 Output: the account number and the balance  
  	 */ 

	public static void printAccts(int[] acctnum, double[] balance, int num_accts, PrintWriter pw) {
		for(int i=0; i<num_accts; i++)
			// prints out account number and balance
			pw.println("account number " +acctnum[i]
					+"\tbalance $"+ balance[i]);
	}
	public static int deleteAcct(int[] acctnum, double[] balance, int num_accts, PrintWriter pw) {
		int acct, pos;
		Scanner keyboard= new Scanner(System.in);
		
		// enter an account you want to delete
		System.out.println("enter an account number you want to delete");
		acct=keyboard.nextInt();
		
		pos=findAcct(acctnum, num_accts, acct);
		if (pos==-1)
			pw.println("Accout number " +acct + " was not found");
		else {
			num_accts --;
			for(int i = pos; i <= num_accts; i++) {
				acctnum[i] = acctnum [i + 1];
				balance[i] = balance [i + 1];
			}
			pw.println(acct + "accont was deleted ");
			
		}
		return num_accts;
	}
}
