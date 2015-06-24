/**
 * Course:   IT110 - Introduction to Programming
 * Filename: CeeDubsBBQ.java
 * Created:  04/09/10 by Dr. Debby Telfer
 * Modified: 11/26/13 by Dr. Bary W Pollack
 * 
 * Purpose:  Created a simple online ordering system
 *			 for CeeDub's BBQ customers
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * @author JMalone 6/01/15
 */
public class CeeDubsBBQ {


	public static String openingMsg, nameInputMsg, customerName, nameOutputMsg, orderRequest, 
			   returnInputMsg, customerReturn, returnOutputMsg, 
			   customerOrder, slabQuantity, chknQty, sauceRequest, priceOutputMsg, sauceReturn, sauceOutputMsg, greetingOutputMsg, orderOutputMsg, outputMsg;
		
		//the cost, tax rate and total cost
	public static	double cost = 20.00; //price per slab 
	public static	double salesTaxRate = .10; //taxes
	public static	double totalCost = 0; //overall total costs
	public static	int bfQty = 0;

	public CeeDubsBBQ () {
		greeting();
		closing();
	}

	private static String getStringInput(String prompt)
	{
		String inputValue;
		int counter = 0;

	do
	{
	counter++;
	inputValue = JOptionPane.showInputDialog(prompt);
	if (inputValue == null) 
	{
	JOptionPane.showMessageDialog(null, "Operation Canceled Exiting Now.");
	System.exit(80);
	}

	} while (inputValue.equals("") && counter < 3);

	if (inputValue.equals(""))
	{
	JOptionPane.showMessageDialog(null, "Three Strikes, You're Out!");
	System.exit(101);
	}
	
	return inputValue; 
	}

	private static double totalCost(int number, double cost, double salesTaxRate){
	{
	double totalCost;
	totalCost = number * cost * (salesTaxRate +1);
	return totalCost;
	}
	}
	
	public void greeting() {
		nameInputMsg   = "Please enter your name: ";
		customerName   = getStringInput(nameInputMsg);
		returnInputMsg = "Are you a returning customer (yes or no)? ";
		customerReturn = getStringInput(returnInputMsg);
		orderRequest  = "Would you like a slab of ribs (yes or no)?"; 
		customerOrder  = getStringInput(orderRequest);	
		slabQuantity   = "How many slabs would you like?";
		chknQty		   = getStringInput(slabQuantity);
		sauceRequest = "Would you like your ribs with sauce (yes or no)?";
		sauceReturn = 	getStringInput(sauceRequest);	
		
		//conversion for the Quantity to an Int
		bfQty = Integer.parseInt(chknQty);

		//calculate total cost
		totalCost = totalCost(bfQty, cost, salesTaxRate);
		}
		
	public void closing() {
		nameOutputMsg     = "Welcome " + customerName + ".\n\n";
		returnOutputMsg   = "Your return customer status is " + customerReturn + ".\n";
		orderOutputMsg	  =	"You ordered a slab/s of ribs " + chknQty + ".\n";
		sauceOutputMsg		  =	"Sauced? " + sauceReturn + " .\n"; 
		priceOutputMsg	  ="Your total is $ " + totalCost + ".\n";
		greetingOutputMsg = "Thank you for visiting Cee-Dub's!" + "\n\n"
						  + "Your order should be ready in less than 10 minutes. Please pay the cashier.\n" ;
	
			
			
		
						  

		// create and display output string
		outputMsg = nameOutputMsg + returnOutputMsg + orderOutputMsg + sauceOutputMsg + priceOutputMsg + greetingOutputMsg;
		JOptionPane.showMessageDialog(null, outputMsg);
	}
	public String toString() {
		return customerName + " Ordered " + chknQty + " slabs ." + sauceReturn + ", sauce please!" 
			+ " This is a grand total of: $" + totalCost;

				}


		}
	