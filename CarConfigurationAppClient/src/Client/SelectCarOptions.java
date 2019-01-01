
package Client;

import Model.*;
import java.util.*;

public class SelectCarOptions {

	////////// PROPERTIES //////////
	private Scanner in = new Scanner(System.in);

	////////// CONSTRUCTORS //////////

	public SelectCarOptions() {
	}

	////////// INSTANCE METHODS //////////

	/*********
	 * This method allows user to configure auto. 
	 * @param Automotive a 
	 */
	public void configureAuto(Automotive a) {
		System.out.println("This is the car: " + a.getMake() + " " + a.getmodelname());
		
		for (int index = 0; index < a.getproperty().size(); index ++)
		{
			String input;
			System.out.println("Enter Your Choice from the car option below"); 
			System.out.println("Please select option " + (index + 1) + " : "); 
			System.out.println(a.showfeature(index)); // print out options
			if (a.findoption(index, (input = in.nextLine())) != -1) 
			{	
				a.addChoice(a.getoptionsetname(index), input); 
				System.out.println("For " + a.getoptionsetname(index) + ", you have chosen: " + input);
				System.out.println("\n\n\n");
			}
			else
			{ // have the user to try again. 
				System.err.println("Invalid Input! Enter again!"); 
				index --; 
			}
		}	
		
		System.out.println("The total price is " + a.settotalprice());
		a.showchoices();
	}

	public boolean isAutomobile(Object obj) {
		boolean isAutomobile = false;

		try {
			obj = (Automotive) obj;
			isAutomobile = true;
		}
		catch (ClassCastException e) {
			isAutomobile = false;
		}

		return isAutomobile;
	}

}
