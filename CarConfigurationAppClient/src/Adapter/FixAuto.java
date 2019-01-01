package Adapter;

import Exception.AutoException;

/**********
 * For external use without using try catch
 * 		- problems occur in a method call
 * 		- problems are fixed in a separate method call
 * 		- 
 * @author albertliu
 *
 */
public interface FixAuto {
	public void fix(int errornumber, String errormessage, AutoException e); 
}
