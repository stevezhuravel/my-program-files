package clas2018;
import java.io.*;
import java.util.*;
/*******************************************************************************************/
/* Steve Zhuravel                                                              Assignment 4*/
/* CIS 1115 TR8                                                                03/18/18*/
/*******************************************************************************************/
public class hw4 {

	public static void main(String[] args) throws IOException {
		File file = new File("hw4.txt");
		Scanner input= new Scanner(file);
		double money,pay,hrs, grosspay=0, tax=0, netpay=0, avgross=0, avgtax=0, emptax, totalgross=0;
		int numemp=0, notax=0, highpay=0;
		while(input.hasNext()) {
			hrs = input.nextDouble();
			pay=input.nextDouble();
			money=grosspay(hrs,pay);
			if(money < 200)
				notax++;
			if(money<200) 
				notax++;
				else if (money>200)
					tax++;
			
				
			emptax=tax(money);
			System.out.println("Gross salary $" + money +" and net salary $"+ emptax);
			totalgross+=money;
			numemp++;
			
		}
	
		avgross=totalgross/numemp;
		System.out.println(notax);
		input.close();
		
	}
	public static double grosspay(double hrs, double pay) {
		if(hrs >40 ) 
			return ((hrs-40)*1.5*pay)+(40*pay);
		else 
			return hrs*pay;
	}
	public static double tax(double gross) {
		if(gross < 200)
			return gross;
		else if(gross >200 && gross < 500)
			return gross - (gross*0.05);
		else if(gross >500 && gross <1000)
			return gross-(gross*0.06);
			else
				return gross-(gross*0.10);
			
		
	}
}