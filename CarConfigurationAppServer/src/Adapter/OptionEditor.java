package Adapter;

import Model.Automotive;
import Scale.EditOptions;

public class OptionEditor extends Thread implements UpdateAuto{
	
	ProxyAutomobile proxy;
	
	public OptionEditor(EditOptions edit)
	{
		super(edit);    // potential infinite loop here
		proxy = new EditOptions();  
	}
	
	public synchronized void EditName(String modelname, String optionsetname, String optionname, String newname)
	{
		proxy.getautoset().get(modelname).setoptionname((proxy.getautoset().get(modelname).findfeature(optionsetname)), optionname, newname);
	}
	
	public synchronized void EditPrice(String modelname, String optionsetname, String optionname, int newprice)
	{
		proxy.getautoset().get(modelname).setoptionprice((proxy.getautoset().get(modelname).findfeature(optionsetname)), optionname, newprice);
	}         
	
	public synchronized void addOptionChoice(String modelname, String optionsetname, String newname)
	{                 
		// proxy.getautoset().get(modelname);
		
		// System.out.println(auto.getOptionChoice(optionsetname));
		while (proxy.getautoset().get(modelname).getOptionChoice(optionsetname) != null)  // The option is already being chosen, no need to add option
		{
			System.out.println("Inside adding choice loop");
			try
			{
				System.out.println("Got to wait for emptying the choice");
				wait();
			}
			catch(Exception e)
			{ }
		}
		
		System.out.println("Now adding the Option Choice");
		proxy.getautoset().get(modelname).addChoice(optionsetname, newname);  
		notify();
	}
	
	public synchronized void RemoveOptionChoice(String modelname, String optionsetname)
	{
		// proxy.getautoset().get(modelname);

		// System.out.println(auto.getOptionChoice(optionsetname));
		while (proxy.getautoset().get(modelname).getOptionChoice(optionsetname) == null)  // it is empty, not need to remove anymore
		{
			System.out.println("Inside remove choice loop");
			try
			{
				System.out.println("Got to wait until the choice is added");
				wait();
			}
			catch(Exception e)
			{}
		}
		
		System.out.println("Now deleting the Option Choice");
		proxy.getautoset().get(modelname).deleteOptionChoice(optionsetname);  
		System.out.println("Option choice removed!!!!");		
		notify();
	}
	
	public synchronized void updateOptionSetName(String Modelname, String OptionSetname, String newName) {
		
	}

	public synchronized void updateOptionPrice(String Modelname, String Optionname, String Option, int newprice) {
		
	}
}
