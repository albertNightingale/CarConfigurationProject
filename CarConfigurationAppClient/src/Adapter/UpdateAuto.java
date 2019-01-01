package Adapter;

public interface UpdateAuto {
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName);
	public void updateOptionPrice(String Modelname, String Optionname, String Option, int newprice);
	public void EditName(String modelname, String optionsetname, String optionname, String newname);
	public void EditPrice(String modelname, String optionsetname, String optionname, int newprice);
	public void addOptionChoice(String modelname, String optionsetname, String newname);
	public void RemoveOptionChoice(String modelname, String optionsetname);
}
