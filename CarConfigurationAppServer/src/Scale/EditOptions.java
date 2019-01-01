package Scale;

import Adapter.OptionEditor;
import Adapter.ProxyAutomobile;


public class EditOptions extends ProxyAutomobile implements Runnable{

	private OptionEditor t; 
	private int threadno;
	private int optionnum; 
	private String [] m1; 
	private boolean isupdating = false; 
	
	
	public EditOptions()
	{
		
	}
	
	public EditOptions(int x, int y, String[] m)
	{
		t = new OptionEditor(this);   // potential infinite loop here
		threadno = x; 
		optionnum = y; 
		m1 = m;
		t.start();
	}
	
	public void startThread(int threadno, int opnum, String[] m1)
	{
		switch(threadno) 
		{ 
			case 1:  
				t.addOptionChoice(m1[0], m1[1], m1[2]);
				break;  
			case 2: 
				t.RemoveOptionChoice(m1[0], m1[1]);
				break; 
			default: // could throw an exception here. 
				break; 
		}  
	}
	
	public void run()     
	{ 
		switch(threadno) 
		{ 
			case 1:  
				System.out.println("Start thread " + optionnum);
				break;  
			case 2: 
				System.out.println("Start thread " + optionnum);
				break; 
			default: // could throw an exception here. 
				break; 
		}  
		
		startThread(threadno, optionnum, m1);
	}        
}
