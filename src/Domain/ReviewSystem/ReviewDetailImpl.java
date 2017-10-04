public interface ReviewDetailImpl implements ReviewDetail {
    
	private String reviewTitle;
	private String reviewText;
	private int reviewRating;
	private Date reviewDate;
	private int reviewID;
	private int reviewLikes;
	private int reviewDisLikes;
	private boolean reviewCategory;
	
	public String getReviewTitle(){return reviewTitle;}
	public void setReviewTitle(String reviewTitle){this.reviewTitle=reviewTitle;}
	public String getReviewText(){return reviewText;}
	public void setReviewText(String reviewText){this.reviewText = reviewText;
	public int getReviewRating(){return reviewRating;}
	public void setReviewRating(int reviewRating){this.reviewRating = reviewRating;}
	public Date getReviewDate(Date reviewDate){return reviewDate;}
	public void setReviewDate(){this.reviewDate = reviewDate;}
	public int getReviewID(){return reviewID;}
	public void setReviewID(int reviewID){this.reviewID = reviewID;}
	public int getReviewLikes(){return reviewLikes;}
	public void setReviewLikes(int reviewDisLikes){this.reviewDisLikes = reviewDisLikes;}
	public int getReviewDislikes(){return reviewDisLikes;}
	public void setReviewDisLikes(int reviewDisLikes){this.reviewCategory = reviewCategory;}
	public boolean getReviewCategory(boolean reviewCategory){return reviewCategory;}
	public void setReviewCategory(){this.reviewCategory = reviewCategory;}

}