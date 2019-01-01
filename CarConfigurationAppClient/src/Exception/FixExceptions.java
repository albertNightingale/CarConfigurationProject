package Exception;

/**********
 * This class contains all the methods that handle the error 
 * @author albertliu
 *
 */
public class FixExceptions{
	
	public FixExceptions()
	{
		
	}
	
	public void FixError1(String errormessage)
	{
		System.out.println("ERROR WHEN READING FILE: " + errormessage);
		System.out.println("Please revise your file and run again!");
	}
	
	public void FixError2(String errormessage)
	{
		System.out.println("ERROR WHEN READING FILE: " + errormessage);
		System.out.println("Please revise your file and run again!");
	}
	
	public void FixError3(String errormessage)
	{
		System.out.println("ERROR WHEN READING FILE: " + errormessage);
		System.out.println("Please revise your file and run again!");
	}
	
	public void FixError4(String errormessage)
	{
		System.out.println("ERROR WHEN READING FILE: " + errormessage);
		System.out.println("Please revise your file and run again!");
	}
	
	/***********
	 * Exception name: ModelPropertyMissingException
	 * Explanation: In the file, one of the following model property is missing: model name, model baseprice, feature length
	 * Potential origin of error
	 * @param errormessage
	 */
	public void FixError5(String errormessage)
	{
		System.out.println("ERROR WHEN READING FILE: " + errormessage);
		System.out.println("Please revise your file and run again!");
	}
}
