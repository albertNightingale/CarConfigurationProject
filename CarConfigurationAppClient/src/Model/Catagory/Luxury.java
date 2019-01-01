package Model.Catagory;

public class Luxury implements Catagory{
	private String pricerange;
	private int rating;
	
	public Luxury()
	{
		pricerange = OVERPRICE;
		rating = EXCERLLENT; 
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
