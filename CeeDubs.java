import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class CeeDubs {


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

	public static void main(String[] args) {

		String openingMsg = "*** Welcome to Cee-Dub's BBQ Ordering System ***\n"
				   + "              Everyday is a good day!";
		JOptionPane.showMessageDialog(null, openingMsg);

		CeeDubs[] array = new CeeDubs[3];
		int count = 1;
		String fin = "";
		System.out.println("Let's begin our 3 orders! ");
		while (count <= 3) {
			String choice = "Would you like Wings(1) or BBQ(2)? ";
			String userChoice = getStringInput(choice);	
			
			//conversion for the Quantity to an Int
			int userPref = Integer.parseInt(userChoice);
			if (userPref == 1) {
				CeeDubsWings wing = new CeeDubsWings();
				fin += wing.toString() + "\n";
			} else if (userPref == 2) {
				CeeDubsBBQ bbq = new CeeDubsBBQ();
				fin += bbq.toString() + "\n";
			} else {
				JOptionPane.showMessageDialog(null, "INVALID ENTRY");
			}

			count++;

		}

		JOptionPane.showMessageDialog(null, fin);

	}

}