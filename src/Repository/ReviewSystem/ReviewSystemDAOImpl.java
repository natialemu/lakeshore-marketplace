package Repository.ReviewSystem;

import Domain.ReviewSystem.ReviewSystem;
import Domain.ReviewSystem.ReviewSystemImpl;

public class ReviewSystemDAOImpl implements ReviewSystemDAO {

    @Override
    public ReviewSystem getReviewSystem(int review_system_id) {
        //TODO
        return new ReviewSystemImpl();

    }
}
