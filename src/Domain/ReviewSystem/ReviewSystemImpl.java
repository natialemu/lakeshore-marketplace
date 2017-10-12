package Domain.ReviewSystem;

import Domain.Tools.IDGenerator;

public class ReviewSystemImpl implements ReviewSystem {
    private int reviewSystemID;

    public ReviewSystemImpl(){
        reviewSystemID = IDGenerator.getId();
    }

    public int getReviewSystemID() {
        return reviewSystemID;
    }

    public void setReviewSystemID(int reviewSystemID) {
        this.reviewSystemID = reviewSystemID;
    }
}
