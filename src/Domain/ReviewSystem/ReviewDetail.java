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
	public int getReviewLikes();
	public void setReviewLikes(int reviewDisLikes);
	public int getReviewDislikes();
	public void setReviewDisLikes(int reviewDisLikes);
	public boolean getReviewCategory(boolean reviewCategory);
	public void setReviewCategory();

}
