package Adapter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Properties;

import Exception.AutoException;
import Model.Automotive;
import Util.FileIO;

public abstract class ProxyAutomobile {
	
	private static LinkedHashMap<String, Automotive> autos = new LinkedHashMap<String, Automotive>(); 
	
	public static LinkedHashMap<String, Automotive> getautoset()
	{
		return autos;
	}
	
	public static void addAuto(Automotive a)
	{
		autos.put(a.getMake() + " " + a.getmodelname(), a); 
	}
	
	public static String displayAutoSet()
	{
		String output = ""; 
				
		Iterator<String> it = autos.keySet().iterator();
		while (it.hasNext())
		{
			output += it.next() + "\n";  
		}
		return output; 
	}
	
	/**********
	 * This method updates the name of the optionset
	 * @param Modelname the name of the car
	 * @param OptionSetname the name of the feature
	 * @param newName  the new name of the feature the user wants to update
	 */
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName)
	{		
		autos.get(Modelname).setoptionsetname(autos.get(Modelname).findfeature(OptionSetname), newName); 
	}
	
	public void updateOptionPrice(String Modelname, String Optionsetname, String Option, int newprice) // potential array out of bounds exception  
	{
		autos.get(Modelname).setoptionprice(autos.get(Modelname).findoption(autos.get(Modelname).findfeature(Optionsetname), Option), Option, newprice); 
	}
	
	public void printAuto(String Modelname)
	{
		System.out.println(autos.get(Modelname).toString());
		System.out.println("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n");
	}

	public void BuildAuto(String filename, String filetype)
	{
		if (filetype.equals("regular"))
		{
			Automotive value = FileIO.readFile(filename);
			String key = value.getMake() + " " + value.getmodelname();
			autos.put(key, value);
		}
		else if (filetype.equals("properties"))
		{
			Properties prop = FileIO.setupproperty(filename); 
		}
		else
		{
			System.out.println("Bad access");
		}
	}
	
	public void fix(int errorno, String errormessage, AutoException e)
	{
		e.setErrormsg(errormessage);
		e.setErrorno(errorno);
		e.fix(errorno);
	}
	
	public void EditName(String modelname, String optionsetname, String optionname, String newname) {
		
	}

	public void EditPrice(String modelname, String optionsetname, String optionname, int newprice) {
		
	}

	public void addOptionChoice(String modelname, String optionsetname, String newname) {
		
	}

	public void RemoveOptionChoice(String modelname, String optionsetname) {
		
	}
}
