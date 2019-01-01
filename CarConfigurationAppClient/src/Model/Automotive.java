package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Model.OptionSet.Option;
import Model.Catagory.*;

public class Automotive<T extends Catagory> implements Serializable {
	
	//////////////// CLASS VARIABLES /////////////////////
	private String model; 
	private String make; 
	private int baseprice; 
	private ArrayList<OptionSet> property;  
	private ArrayList<Option> choice; 
	private T catagory; 
	
	
	//////////////// CONSTRUCTORS /////////////////////
	public Automotive (String name, int baseprice)
	{ 
		make = name.substring(0, name.indexOf(' ')); 
		model = name.substring(name.indexOf(' ') + 1); 
		this.baseprice  = baseprice; 
		property = new ArrayList<OptionSet>();
		choice = new ArrayList<Option>();
	}
	
	public Automotive (String make, String model, int baseprice)
	{ 
		this.make = make;
		this.model = model;
		this.baseprice  = baseprice; 
		property = new ArrayList<OptionSet>();
		choice = new ArrayList<Option>();
	}
	
	public Automotive ()
	{ 
		property = new ArrayList<OptionSet>();
		choice = new ArrayList<Option>();
	}

	//////////////// METHODS /////////////////////
	
	/*****************
	 * Make getter
	 * @return make of the car
	 */
	public String getMake() {
		return make;
	}
	
	/*********
	 * make setter
	 * @param the new make
	 */
	public void setMake(String make) {
		this.make = make;
	}
	
	/******
	 * model getter
	 * @return
	 */
	public String getmodelname()
	{
		return model; 
	}
	
	/******
	 * model setter
	 * @return
	 */
	public void setmodelname(String newname)
	{
		model = newname; 
	}
	
	/******
	 * baseprice getter
	 * @return the base price of the car
	 */
	public int getbaseprice()
	{
		return baseprice;
	}
	
	/******
	 * baseprice setter 
	 */
	public void setbaseprice(int newprice)
	{
		baseprice = newprice; 
	}
	
	/////////  optionset list's accessor and modifiers  //////// 
	
	/*******
	 * Optionset array methods
	 * Optionset array getter
	 * @return
	 */
	public ArrayList<OptionSet> getproperty()
	{
		return property; 
	}
	
	/******
	 * get number of properties 
	 * @return
	 */
	public int getnumofoptionset()
	{
		return property.size(); 
	}
	
	/*******
	 * Optionset array methods
	 * Create an optionset
	 * Add it to the specific index. 
	 * If the index already exist, replace the value in property[index]
	 * @param opts
	 * @param index
	 */
	public void addfeatures(String optsname) // add a new feature to the car. 
	{
		property.add(new OptionSet(optsname)); 
	}
	
	/*********
	 * find the optionset in property list with the name given, return -1 if not found in the list
	 * @param name
	 * @return
	 */
	public int findfeature(String name)
	{
		int index = 0; 
		int location = -1; 
		
		while (index < property.size()) 
		{
			if (property.get(index).getname().equals(name))
			{
				return index; 
			}
			index ++;  
		}

		return location; 
	}
	
	//////////////// toString Methods /////////////////////
	/*******
	 * @override Object class toString method 
	 * turn automotive object into string 
	 * @return the automotive object in string form 
	 */
	public String toString()   
	{
		String result = ""; 
		// System.out.println("Rating: " + catagory.getRating() + "Price range: " + catagory.getPricerange());
		
		for (int index = 0; index < property.size(); index ++)
		{
			result += property.get(index).showfeature(); 
		}
		
		return "Car name : " +  make + " " + model + "\n" 
			+  "Base Price : " + baseprice + "\n"
			+  "Number of Features: " + property.size() + "\n" 
			+  "_____________________________________________________________________\n"
			+ result; 
	}
	
	/******
	 * turn the optionset in "index" location of the property arraylist to string
	 * @param index
	 * @return optionset in string form
	 */
	public String showfeature(int index)
	{
		return property.get(index).showfeature();
	}
	
	/*********   
	 * turn all the choices the user has chosen into string
	 * @return the choices in String 
	 */
	public String showchoices()
	{
		String result = ""; 
		for (int i = 0 ; i < choice.size(); i ++)
		{
			result += choice.get(i).showoption();
		}
		return result; 
	}
	
	/*******   
	 * turn the optionchoice at this index in choice arraylist to string 
	 * @param int index
	 * @return String optionform
	 */
	public String showchoice(int index)
	{
		return choice.get(index).showoption();
	}
	
	/*********
	 * get the list of choice that the user asks. 
	 * @return ArrayList<Option>
	 */
	public ArrayList<Option> getchoice()
	{
		return choice; 
	}
	
	/***********
	 * This method get the option choice the user requests
	 * @param setname: the name of the set that the user want to use. 3
	 * @return
	 */
	public Option getOptionChoice(String setname)
	{
		int location = findfeature(setname); // get the index of the feature in the property list
		if (location != -1)
			if (property.get(location).findOption(choice.get(location).getname()) != -1)
				return choice.get(location); 
		return null; 
	}
	
	/*************
	 * set the option choice in the optionset to empty string
	 * @param setname
	 */
	public void deleteOptionChoice(String setname)
	{
		int location = findfeature(setname);
		if (property.get(location).findOption(choice.get(location).getname()) != -1) 
			choice.remove(choice.get(location)); 
	}
	
	/*********
	 * get the name of the option choice 
	 * @param setname
	 * @return
	 */
	public String getOptionChoiceName(String setname)
	{
		return getOptionChoice(setname).getname();
	}
	
	/********
	 * get the price of the option choice the user has chosen. 
	 * @param optionname
	 * @return the price of the optionchoice
	 */
	public int getOptionChoicePrice(String optionname)
	{
		return getOptionChoice(optionname).getcost();
	}
	
	/***********
	 * Add a new choice to the option list. 
	 * @param featurename
	 * @param choicename
	 */
	public void addChoice(String featurename, String choicename) 
	{
		OptionSet feature; 
		int location = findfeature(featurename); 
		
		// System.out.println(location); 
		
		if (location != -1)
		{
			feature = property.get(location); 
			// feature.tostring();
			// System.out.println(feature.getname());
			int optionindex = feature.findOption(choicename); 
			// System.err.println(optionindex + " " + choicename);
			choice.add(feature.getalloptions().get(optionindex));   // set the choice in the automotive class
		}
		else
		{
			System.err.println(featurename + " is not find! ");
		}
	}
	
	/******
	 * set up the total price for purchasing this model
	 * @return
	 */
	public int settotalprice() // determine the total price
	{
		int totalprice = baseprice;
		
		for (Option pick : choice)
		{
			totalprice += pick.getcost(); 
		}
		return totalprice; 
	}
	
	// OptionSet classes's methods
	
	/*******
	 * Set the name for the optionset
	 * @param index       the index in the property class that needs to change
	 * @param newName     the new name
	 */
	public void setoptionsetname(int index, String newName)
	{
		property.get(index).setname(newName);
	}
	
	/*******
	 * get the name of the optionset in the property[index]
	 * @param index the location of the optionset in the property array that the user want to get the name of
	 * @return   the name of the optionset
	 */
	public String getoptionsetname(int index)
	{
		return property.get(index).getname(); 
	}
	
	/********
	 * get the entire array of options that are hidden inside of the OptionSet class
	 * @param index      the index of optionset[] in property
	 * @return  option[] 
	 */
	public ArrayList<Option> getoptionset(int index)
	{
		return property.get(index).getalloptions(); 
	}
	
	/*******
	 * find the location of the option in the option[] in optionset class based on the name of the option. 
	 * @param index = location of the variable inside of option
	 * @param optionname = the name of the option
	 * @return the location of the option in the optionset array
	 */
	public int findoption(int index, String optionname)
	{
		return property.get(index).findOption(optionname); 
	}
	
	/********
	 * change the name for the option with oldname in optionset at given index in property
	 * @param index       index of optionset in the property array
	 * @param oldname     the old name of the option
	 * @param newname     the new name of the option
	 */
	public void setoptionname(int index, String oldname, String newname) 
	{
		int optionindex = property.get(index).findOption(oldname); 
		property.get(index).getalloptions().get(optionindex).setname(newname); 
	}
	
	/*******
	 * return the name for option at the given index
	 * @param location    location of optionset inside of property array
	 * @param optionlocation    location of option inside of optionset array in optionset class
	 * @return the name of option in the given index
	 */
	public String getoptionname(int location, int optionlocation)
	{
		return property.get(location).getalloptions().get(optionlocation).getname(); 
	}
	
	/********
	 * set the price for option
	 * @param location the location of the optionset in the property
	 * @param optionname  the name of the option
	 * @param newprice   the price that need to change
	 */
	public void setoptionprice(int location, String optionname, int newprice)
	{
		int optionindex = property.get(location).findOption(optionname); 
		property.get(location).getalloptions().get(optionindex).setcost(newprice);
	}
	
	/*******
	 * get the price of the option
	 * @param location      location of the optionset inside of the property array
	 * @param optionlocation    location of the option inside of the optionset array
	 * @return
	 */
	public int getoptionprice(int location, int optionlocation)
	{
		return property.get(location).getalloptions().get(optionlocation).getcost();
	}	
	
	/************
	 * Add Option into the optionset's class array 
	 * @param optionsetindex property index 
	 * @param optionindex    feature index
	 * @param name           name of the option
	 * @param price          price of the option
	 */
	public void addoption(int optionsetindex, int optionindex, String name, int price)
	{
		property.get(optionsetindex).addOptions(property.get(optionsetindex).new Option(name, price), optionindex);
	}
	
	/************
	 * Add Option into the optionset's class array 
	 * @param optionsetindex property index 
	 * @param name           name of the option
	 * @param price          price of the option
	 */
	public void addoption(int optionsetindex, String name, int price)
	{
		property.get(optionsetindex).getalloptions().add((property.get(optionsetindex).new Option(name, price)));
	}
}
