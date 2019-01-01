
package Client;

import java.io.*;
import java.util.*;

import Adapter.Debuggable;

public class CarModelOptionsIO implements Debuggable{

	////////// PROPERTIES //////////
	

	////////// CONSTRUCTORS //////////

	public CarModelOptionsIO() {

	}

	////////// INSTANCE METHODS //////////

	public Object loadPropsFile(String fname) {
		Properties props = new Properties(); 
		try {
			if (DEBUG)
				System.out.println("Loading property file");
			props.load(new FileInputStream(fname));
		}
		catch (FileNotFoundException e) {
			System.err.println("Error in file directory ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error reading file from directory ... ");
			System.exit(1);
		}

		return props;
	}

	public Object loadTextFile(String fname) {
		StringBuffer sbuff = new StringBuffer();
		try {
			if (DEBUG)
				System.out.println("Loading Text file");
			BufferedReader buff = new BufferedReader(new FileReader(fname));
			boolean eof = false;
			int counter = 0;
			while (!eof) {
				String line = buff.readLine();
				if (line == null)
					eof = true;
				else {
					if (counter == 0)
						sbuff.append(line);
					else
						sbuff.append("\n" + line);
				}
				counter++;
			}
			buff.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("CLIENT SIDE: Error in file directory ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error reading file from directory ... ");
			System.exit(1);
		}

		return sbuff;
	}

}
