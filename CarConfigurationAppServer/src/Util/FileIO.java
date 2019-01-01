package Util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

import Exception.AutoException;
import Model.Automotive;
import Model.OptionSet;

public class FileIO {
	
	private String infilename, outfilename; 
	
	public FileIO(String inputfilename, String outputfilename)
	{
		this.infilename = inputfilename;
		this.outfilename = outputfilename; 
		// auto = new Automotive();
	}
	
	public FileIO(String inputfilename)
	{
		this.infilename = inputfilename;
		this.outfilename = ""; 
		// auto = new Automotive(); 
	}
	
	public FileIO()
	{
	
	}
	
	/*********
	 * It read the file line by line and copy them into an array of String. 
	 * @param inputfilename
	 * @return the array of lines read from the file. 
	 */
	public static Automotive readFile(String inputfilename)  {

		// int actuallength = 0; 
	
		Automotive auto = null; 
		
		try 
		{
			FileReader file = new FileReader(inputfilename);
			BufferedReader buff = new BufferedReader(file);
			auto = new Automotive(buff.readLine(), Integer.parseInt(buff.readLine()));
			
			boolean readable = true; 
			int featurecount = 0; 
			int find1 = -1; // find 1 look for ']' 
			int find2 = -1; // find2 look for ','
			String line; 
			
			while (readable) 
			{
				line = buff.readLine();		
				
				if (line == null) // finished reading
				{
					readable = false;
					featurecount ++; 
					break; 
				}
				
				find1 = line.indexOf(']');
				
				if (find1 != -1) // found a feature
				{
					String optionsetname = line.substring(1, find1);   // get name of the optionset   
					int optionsetlength = Integer.parseInt(line.substring((find1 + 2), line.length()).trim()); // get length of optionset
					auto.addfeatures(optionsetname);
					
					for (int index = 0; index < optionsetlength; index ++)
					{
						line = buff.readLine(); // read line by line to find index
						find2 = line.indexOf(','); 
						
						String optionname = line.substring(0, find2); 
						int optionprice = Integer.parseInt(line.substring(find2 + 2, line.length())); 
						
						auto.addoption(featurecount, index, optionname, optionprice); // add the option into property.getfeature();
					}
				}
				featurecount ++;  // add feature count
			} 
			buff.close();
		}
			catch (IOException e) {
			System.out.println("Error " + e.toString());
		}
								
		return auto;
	}
	
	/************
	 * Write data to a new file
	 */
	public void SerializeAuto(Automotive auto)  { // change name
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outfilename)); 
			out.writeObject(auto);    
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/***********
	 * read it the binary code into real content of the Automotive object.  
	 * @return the Automotive object being read. 
	 */
	public Automotive DeserializeAuto()
	{ 
		try 
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(outfilename)); 
			Object obj = in.readObject(); 
			return (Automotive)(obj); 
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null; 
	}
	
	// Method that setup entire array
	/***********
	 * This method set up the Automotive by calling the readfile method to 
	 * get an array of string data that contains values inside of the file
	 * Then it will set up the options and optionset inside of automotive 
	 * @param filename
	 * @return
	 */
	public Automotive buildAutoObject(String filename) 
	{ 
		return readFile(filename);
	}
	
	public static Properties setupproperty(String filename) 
	{	
		Properties props = new Properties();
		try {
			FileInputStream in = new FileInputStream(filename);
			props.load(in);
		} catch (IOException e) { e.printStackTrace(); }
		
		return props;
	}
}