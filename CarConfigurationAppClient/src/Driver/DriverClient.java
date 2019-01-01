package Driver;

import Adapter.BuildAuto;
import Adapter.CreateAuto;
import Adapter.UpdateAuto;
import Client.DefaultSocketClient;
import Model.Automotive;
import Scale.EditOptions;
import Util.FileIO;

public class DriverClient {
	
	public DriverClient ()
	{
		
	}
	
	private void Lab1()
	{
		FileIO file = new FileIO("Lambogini.txt", "auto.ser");
		//Build Automobile Object from a file.
		Automotive FordZTW = FileIO.readFile("Lambogini.txt"); 
		//Print attributes before serialization
		FordZTW.toString();    
		//Serialize the object         
		file.SerializeAuto(FordZTW);                     
		//Deserialize the object and read it into memory.       
		Automotive newFordZTW = file.DeserializeAuto();      
		//Print new attributes.     
		System.out.println("\n\n\n\n");
		newFordZTW.toString();     
	}
	
	private void Lab3()
	{
		CreateAuto add = new BuildAuto();
		add.BuildAuto("Lambogini.txt", "regular");
		add.BuildAuto("FordZTW.txt", "regular");
		
		add.printAuto("Lambogini Concept");
		add.printAuto("Focus Wagon ZTW");
	}
	
	private void Lab4()
	{
		Lab3();
		String m[] = {"Focus Wagon ZTW", "Color", "Fort Knox Gold Clearcoat Metallic"}; 

		EditOptions a1 = new EditOptions(1, 1, m); 
		EditOptions a2 = new EditOptions(2, 2, m);
	}
	
	private void Lab5()
	{
		// Lab3(); 
		DefaultSocketClient server = new DefaultSocketClient("127.0.0.1", 9999); 
		System.out.println("Client starts");
		server.start();
	}
	
	public void Lab6()
	{
		
	}
	
	public static void main (String[] args)
	{	
		DriverClient d = new DriverClient();
		d.Lab5();
	}
}
