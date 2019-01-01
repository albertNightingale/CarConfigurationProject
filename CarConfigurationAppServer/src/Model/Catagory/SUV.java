package Model.Catagory;

public class SUV implements Catagory{
	
	private String pricerange;
	private int rating;
	
	public SUV()
	{
		pricerange = EXP;
		rating = GOOD;
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
