package Server;

import Adapter.*;
import Model.Automotive;

import java.util.Properties;


public class BuildCarModelOptions extends ProxyAutomobile implements Debuggable{

	////////// PROPERTIES //////////

	private static final int WAITING = 0;
	private static final int REQUEST_BUILD_AUTO = 1;
	private static final int REQUEST_CONFIGURE_AUTO = 2;

	private int state = WAITING;

	////////// CONSTRUCTORS //////////

	public BuildCarModelOptions() {

	}

	////////// INSTANCE METHODS //////////

	public Object processRequest(Object obj) {
		Object toClient = null;

		// if (DEBUG)
		// 	System.out.println(obj);
		
		if (state == REQUEST_BUILD_AUTO)  // tell the client to confirm that the auto is added
		{
			//add code to buildauto 
			// File
			Properties prop = (Properties) obj; 
			
			Automotive Auto = new Automotive(prop.getProperty("CarMake"), prop.getProperty("CarModel"), 
					new Integer(prop.getProperty("CarPrice"))); 
			Auto.addfeatures(prop.getProperty("Option1")); 
			Auto.addfeatures(prop.getProperty("Option2")); 
			
			Auto.addoption(Auto.findfeature(prop.getProperty("Option1")), prop.getProperty("Option1a"), 0);
			Auto.addoption(Auto.findfeature(prop.getProperty("Option1")), prop.getProperty("Option1b"), 0);
			Auto.addoption(Auto.findfeature(prop.getProperty("Option1")), prop.getProperty("Option1c"), 0);
			Auto.addoption(Auto.findfeature(prop.getProperty("Option2")), prop.getProperty("Option2a"), 0);
			Auto.addoption(Auto.findfeature(prop.getProperty("Option2")), prop.getProperty("Option2b"), 0);

			
			addAuto(Auto);
			
			toClient = "Automobile object successfully added to database\n"
					+ "Press any key to return to main menu";
		}
		else if (state == REQUEST_CONFIGURE_AUTO)  // return the auto the client choose back to the client
		{
			//add code for configureauto
			String autorequest= (String)(obj);
			if ((toClient = getautoset().get(autorequest)) == null)
			{
				System.out.println(autorequest + " is not found!!!!");
			}
		}
		else {

		}

		this.state = WAITING;

		return toClient;
	}

	public String setRequest(int i) {
		String output = null;

		if (i == 1) {
			this.state = REQUEST_BUILD_AUTO;
			output = "Upload a file to create an Automobile";
		}
		else if (i == 2) {
			this.state = REQUEST_CONFIGURE_AUTO;
			output = "Select an Automobile from the following list to configure: \n" + super.displayAutoSet();
		}
		else {
			output = "Invalid request";
		}

		return output;
	}



}
