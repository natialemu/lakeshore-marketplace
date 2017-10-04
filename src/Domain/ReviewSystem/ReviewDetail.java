package Domain.ReviewSystem;

public interface ReviewDetail {
    
	public String getReviewTitle();
	public void setReviewTitle(String reviewTitle);
	public String getReviewText();
	public void setReviewText(String reviewText);
	public int getReviewRating();
	public void setReviewRating(int reviewRating);
	public Date getReviewDate(Date reviewDate);
	public void setReviewDate();
	public int getReviewID();
	public void setReviewID(int reviewID);

}
