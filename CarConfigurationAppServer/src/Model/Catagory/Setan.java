package Model.Catagory;

public class Setan implements Catagory{

	private String pricerange;
	private int rating;
	
	public Setan()
	{
		pricerange = LOW;
		rating = BAD;
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
