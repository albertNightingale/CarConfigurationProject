package Model.Catagory;

public class Truck implements Catagory{

	private String pricerange;
	private int rating;
	
	public Truck()
	{
		pricerange = LOW;
		rating = HORRIBLE;
	}
	
	public String getPricerange() 
	{
		return pricerange;
	}

	public void setPricerange(String pricerange) 
	{
		this.pricerange = pricerange;
	}

	public int getRating() 
	{
		return rating;
	}

	public void setRating(int rating) 
	{
		this.rating = rating;
	}
}
