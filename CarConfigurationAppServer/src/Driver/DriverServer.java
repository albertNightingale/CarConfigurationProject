package Driver;

import Adapter.BuildAuto;
import Adapter.CreateAuto;
import Adapter.ProxyAutomobile;
import Adapter.UpdateAuto;
import Model.Automotive;
import Scale.EditOptions;
import Server.DefaultServerSocket;
import Util.FileIO; 

public class DriverServer {
	
	public DriverServer ()
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
		add.BuildAuto("/Users/albertliu/Desktop/AJ/CarConfigurationAppServer/Lambogini.txt", "regular");
		add.BuildAuto("/Users/albertliu/Desktop/AJ/CarConfigurationAppServer/FordZTW.txt", "regular");
		
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
		Lab3(); 
		DefaultServerSocket server = new DefaultServerSocket(9999); 
		System.out.println("Server has started");
		server.start();
	}
	
	public void Lab6()
	{
		CreateAuto add = new BuildAuto();
		add.BuildAuto("/Users/albertliu/Desktop/AJ/CarConfigurationAppServer/Lambogini.txt", "regular");
		add.BuildAuto("/Users/albertliu/Desktop/AJ/CarConfigurationAppServer/FordZTW.txt", "regular");
	}
	
	public static void main (String[] args)
	{	
		DriverServer d = new DriverServer();
		d.Lab5();
	}
}
