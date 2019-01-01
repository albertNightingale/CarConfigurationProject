package Model.Catagory;

public interface Catagory {
	
	public static final String LOW = "$";
	public static final String MED = "$$";
	public static final String EXP = "$$$";
	public static final String OVERPRICE = "$$$$";
	
	public static final int HORRIBLE = 1;
	public static final int BAD = 2;
	public static final int OK = 3;
	public static final int GOOD = 4;
	public static final int EXCERLLENT = 5;

	public String getPricerange();
	public void setPricerange(String pricerange); 
	public int getRating(); 
	public void setRating(int rating);

}
