package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable{
	private ArrayList<Option> feature; 
	private String name; 
	
	// CONSTRUCTOR 
	/**********
	 * An optionset is a feature of the model
	 * @param name name of the optionset
	 * @param l    length of the array this optionset will hold 
	 */
	public OptionSet(String name)
	{
		this.name = name; 
		feature = new ArrayList<Option>(); 
	}
	
	public OptionSet()
	{
		feature = new ArrayList<Option>(); 
	}
	
	// METHOD
	/*******
	 * This method will return all options that the optionset contain
	 * @return return all options
	 */
	protected ArrayList<Option> getalloptions()
	{
		return feature;
	}
	
	/******
	 * this will help the user to find the option in an array of options
	 * @param opt
	 * @return the index of the option in the list or -1 when it does not exist. 
	 */
	protected int findOption(String optionname)
	{
		int index; 
		int location = -1; 
		
		for (index = 0; index < feature.size(); index ++)
		{
			if (feature.get(index).getname().equals(optionname))
			{
				return index;
			}
		}
		return location; 
	}
	
	/**********
	 * Add new options
	 * @param o 
	 * @param index
	 */
	protected void addOptions(Option o, int index) 
	{
		feature.add(index, o);
	}
	
	/***********
	 * Return the name of the optionset
	 * @return the name of the OptionSet
	 */
	protected String getname()
	{
		return name; 
	}
	
	/********
	 * change the name of the optionset
	 * @param name
	 */
	protected void setname(String name)
	{
		this.name = name; 
	}
	
	/*********
	 * this will return the optionset name, then will print out all the information about option inside of the array
	 */
	protected String showfeature()
	{
		String output = ""; 
		for (int index = 0; index < feature.size(); index ++)
		{
			output += feature.get(index).showoption(); 
		}
		
		return "***************************************************************\n"
					+ "\tFeature name: " +  name + "\n"
					+ "\tnumber of features: " + feature.size() + "\n" 
					+ output + "\n";
	}
	
	// OPTION CLASS 
	public class Option implements Serializable
	{
		private String name; 
		private int price; 
		
		// CONSTRUCTOR
		/*******
		 * An option is just a type of feature
		 * will be contained inside of optionset
		 * @param name   name of this option
		 * @param price  cost to install this option
		 */
		protected Option(String name, int price)
		{
			this.name = name;
			this.price = price; 
		}
		
		protected Option()
		{
			name = "";
			price = 0; 
		}
		
		// METHODS 
		/*********
		 * Set the cost of the option
		 * @param the new price that the current price will refer to 
		 */
		protected void setcost (int cost)
		{
			price = cost; 
		}
		
		/********
		 * return the price of this option
		 * @return price
		 */
		protected int getcost()
		{
			return price; 
		}
	
		/********
		 * return the name of this option
		 * @return name 
		 */
		protected String getname()
		{
			return name; 
		}
		
		/*******
		 * Set the name of this option 
		 * @param name
		 */
		protected void setname(String name)
		{
			this.name = name; 
		}
		
		/********
		 * return the option in String form
		 */
		protected String showoption()
		{
			return "name of the option: " + name + "\n" + "Cost of the option: " + price + "\n"; 
		}
	}
}
