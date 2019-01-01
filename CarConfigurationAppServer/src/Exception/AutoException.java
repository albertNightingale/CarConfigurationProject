package Exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AutoException extends Exception {
	private int errorno;
	private String errormsg;
	
	
	public AutoException() {
		super();
		errorno = 0; 
		errormsg = "empty"; 
		printmyproblem();
	}
	
	public AutoException(String errormsg) {
		super();
		this.errormsg = errormsg;
		errorno = 0; 
		printmyproblem();
	}
	
	public AutoException(int errorno) {
		super();
		this.errorno = errorno;
		errormsg = "empty"; 
		printmyproblem();
	}
	
	public AutoException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	/********
	 * Get the number index of the error
	 * @return
	 */
	public int getErrorno() {
		return errorno;
	}
	
	/********
	 * Change the error number
	 * @param errorno
	 */
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	/**********
	 * get the error message
	 * @return
	 */
	public String getErrormsg() {
		return errormsg;
	}
	
	/********
	 * Edit the error message
	 * @param errormsg
	 */
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	/********
	 * Print out the error number and error message
	 */
	public void printmyproblem() {
		System.out.println("FixProblems [errorno = " + errorno + ", errormsg=" + errormsg); 
	}

	/*********
	 * write to file using timestamp
	 * @param filename 
	 */
	public void Logging(String errorname)
	{
		String stuff; 
		try {
			FileWriter writer = new FileWriter(new File("Error Log.txt")); // need to create that log
			stuff = geterrortime() + " " + errorname; 
			writer.write(stuff);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	protected String geterrortime()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now); 
	}
	
	public void fix(int errornum) 
	{
		FixExceptions fixer = new FixExceptions();
		switch (errornum)
		{
			case 1: 
				errormsg = "FeatureNumberDoesNotMatchException"; 
				fixer.FixError1 (errormsg); 
				Logging(errormsg);  
				break; 
			case 2:  
				errormsg = "OptionLengthDoesNotMatchException"; 
				fixer.FixError2 (errormsg); 
				Logging(errormsg); 
				break; 
			case 3:  
				errormsg = "MissingSpaceException"; 
				fixer.FixError3 (errormsg); 
				Logging(errormsg); 
				break; 
			case 4:  
				errormsg = "InvalidSpaceInEndOfLineException"; 
				fixer.FixError4 (errormsg); 
				Logging(errormsg); 
				break; 
			case 5:  
				errormsg = "ModelPropertyMissingException"; 
				fixer.FixError5 (errormsg); 
				Logging(errormsg); 
				break; 
		}
	}
}
