/*
 * Review class outline
 * @author Brian McLaughlin
 */
public class Review 
{
	private int id;
	private int rating;
	private String reviewText;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getRating() 
	{
		return rating;
	}
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
	
	public String getReviewtext() 
	{
		return reviewText;
	}
	public void setReviewtext(String reviewtext) 
	{
		this.reviewText = reviewtext;
	}
	
	
}
