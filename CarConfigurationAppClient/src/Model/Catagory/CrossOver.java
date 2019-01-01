package Model.Catagory;

public class CrossOver implements Catagory{

	private String pricerange;
	private int rating;
	
	public CrossOver()
	{
		pricerange = MED;
		rating = OK;
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
