//Steve Zhuravel
import java.io.*;


import java.util.Scanner;
public class calculator {

	public static void main(String[] args) throws IOException {
		
		char choice;
		
		
		
		PrintWriter outputFile = new PrintWriter("/Users/Stevezhuravel/Desktop"
				+ "/intro class/topic 6/outputcalculator.txt");
		   
		File inputFile = new File("/Users/Stevezhuravel/Desktop/intro class"
				+ "/topic 6.txt");
		Scanner input = new Scanner(inputFile);
		
		// Scanner keyboard=new Scanner(System.in);
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Enter a character");
		outputFile.println("Steve zhuravel");
		do {
			//call the method
			menu();
			Scanner keyboard1;
			choice=keyboard.next().charAt(0);
		
		
			switch(choice) {
			case '+':
				addtwonumbers(keyboard, outputFile);
				break;
			case '-':
				subtracttwonumbers(keyboard, outputFile);
				break;
			case '*':
				multiplytwonumbers(keyboard, outputFile);
			break;
			case '/':
				dividetwonumbers(keyboard, outputFile);
				break;
			case 'R':
			case 'r':
				findremainder(keyboard, outputFile);
				break;
			case 'A':
			case 'a':
				avg(keyboard, outputFile);
				break;
			case 'X':
			case 'x':
				maxtwonumbers(keyboard, outputFile);
				break;
			case 'M':
			case 'm':
				mintwonumbers(keyboard, outputFile);
				break;
			case 'S':
			case 's':
				square(keyboard, outputFile);
				break;
			case 'Q':
			case 'q':
				break;
			default:
			System.out.println(choice + " is not part of the menu");
        }
		}while(choice!='Q' && choice!='q');
		
		outputFile.close();
		input.close();
		
		}
	
	
	public static void menu() {
		
		System.out.println("+  add two numbers");
		// type in x for addition
		System.out.println("-  subtract two numbers");
		// type in - for subtraction
		System.out.println("*  multiply two numbers");
		// type in * for multiplycation
		System.out.println("/  divide two numbers");
		// type in / for division
		System.out.println("R  finds remainder of numerator and denominator ");
		// type in r for remainder
		System.out.println("A finds the average of two numbers");
		// type in a for avg
		System.out.println("X  maxium of two numbers");
		// type in x for maxium
		System.out.println("M  minimum of two number");
		// type in s for square number
		System.out.println("S  square of a number");
		System.out.println("Q  quit");
		// type in q for quit 
	}
	 /* Method addtwonumbers
  	 * Input: The two numbers  
  	 Process: adds them up 
  	 Output: printout the sum
  	 */ 

	public static void addtwonumbers(Scanner keyboard, PrintWriter outputFile) {
		
		System.out.println("Enter two integers");
		// enter two integers 
		int num1=keyboard.nextInt();
		// enter first int 
		int num2=keyboard.nextInt();
		// enter secound int 
		outputFile.println("The two numbers are " + num1 
				+ " and " + num2 );
		outputFile.print(" The sum of the two number is ");
		outputFile.println( num1  + num2);
		outputFile.println();
		
		}
	/* Method subtracttwonumbers
  	 * Input: The two numbers  
  	 Process: subtract them  
  	 Output: printout the difference
  	 */ 
	
	public static void subtracttwonumbers(Scanner keyboard,
			PrintWriter outputFile) 
	{
		
		System.out.println("Enter two integers");
		// enter two integers 
		int num1=keyboard.nextInt();
		// enter first int
		int num2=keyboard.nextInt();
		// enter sec int 
		outputFile.println("The two numbers are " 
		+ num1 + " and " + num2 );
		outputFile.print("The difference of the two number is " );
		outputFile.println(num1  - num2);
		outputFile.println();
		
	}
	/* Method multiplytwonumbers
  	 * Input: mutplyies  two numbers  
  	 Process: mutplyies them  
  	 Output: printout the mutplyier
  	 */ 
	public static void multiplytwonumbers(Scanner keyboard,PrintWriter outputFile) 
	{
		// enter two integers
		System.out.println("Enter two integers");
		int num1=keyboard.nextInt();
		int num2=keyboard.nextInt();
		outputFile.println("the two numbers are " + num1 
				+ " and " + num2  );
		outputFile.print("The Mutlpltican of the two number is ");
		outputFile.println(num1  * num2);
		outputFile.println();

	}
	/* Method dividetwonumbers
  	 * Input: divide the two numbers   
  	 Process: divide them  
  	 Output: printout the divisior 
  	 */ 
	public static void dividetwonumbers(Scanner keyboard,PrintWriter outputFile) 
	{
		// enter two integers
		System.out.println("Enter two integers");
		int num1=keyboard.nextInt();
		int num2=keyboard.nextInt();
		outputFile.println("the two numbers are " + num1 
				+ " and " + num2 );
		outputFile.print("The division of the two number is ");
		outputFile.println( num1  / num2);
		outputFile.println();
	}
	/* Method findremainder
  	 * Input: divide the two numbers and takes the remainder   
  	 Process: divide them  
  	 Output: printout the remainder 
  	 */ 
	public static void findremainder(Scanner keyboard,PrintWriter outputFile)
	{
		System.out.println("Enter two integers");
		// enter two integers
		int num1=keyboard.nextInt();
		// enter first int 
		int num2=keyboard.nextInt();
		outputFile.println("the two numbers are " + num1 
				+ " and " + num2 );
		outputFile.println("the remainder of two numbers are" );
		outputFile.println(num1  % num2);
		outputFile.println();
	}
	/* Method avg 
  	 * Input: the two number   
  	 Process: adds them up and divide them by 2  
  	 Output: printout the abg 
  	 */ 
	public static void avg(Scanner keyboard,PrintWriter outputFile) 
	{
		System.out.println("Enter two integers");
		// enter two integers
		int num1=keyboard.nextInt();
		int num2=keyboard.nextInt();
		double avgmark = (double)(num1 + num2) / 2;
		outputFile.printf("The average is %.2f", avgmark);
		outputFile.println("the two numbers are " + num1 
				+ " and " + num2 );
		outputFile.print("The avg of the two number are ");
		outputFile.println((num1 + num2) / 2);
		outputFile.println();
	}
	/* Method maxtwonumbers
  	 * Input: two numbers    
  	 Process: none  
  	 Output: printout the largest 
  	 */ 
	public static void maxtwonumbers(Scanner keyboard,PrintWriter outputFile )
	{
		
		System.out.println("Enter two integers");
		// enter two integers
		int num1=keyboard.nextInt();
		int num2=keyboard.nextInt();
		outputFile.println("the two numbers are " + num1 
				+ " and " + num2 );
		outputFile.print("The max of the two number are ");
		outputFile.println(Math.max(num1,num2));
		outputFile.println();
	}
	/* Method mintwonumbers
  	 * Input: two numbers    
  	 Process: none  
  	 Output: printout the smallest 
  	 */ 
	public static void mintwonumbers(Scanner keyboard,PrintWriter outputFile) 
	{
		
		System.out.println("Enter two integers");
		// enter two integers
		int num1=keyboard.nextInt();
		// enter the first int 
		int num2=keyboard.nextInt();
		outputFile.println("the two numbers are");
		outputFile.print("The min of the two number are " + num1 
				+ " and " + num2 );
		outputFile.println(Math.min(num1,num2));
		outputFile.println();
	 }
	/* Method square
  	 * Input: two numbers    
  	 Process: mutplyies the two numbers and takes the square  
  	 Output: the square of two numbers  
  	 */ 
	public static void square(Scanner keyboard,PrintWriter outputFile) 
	{
		
		System.out.println("Enter two integers");
		// enter two integers
		int num1=keyboard.nextInt();
		int num2=keyboard.nextInt();
		outputFile.println("the two numbers are");
		
		outputFile.println(Math.sqrt(num1*num2));
		outputFile.println();
		
	}
	
}