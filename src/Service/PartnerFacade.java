package Service;

import Domain.Partner.Partner;
import Domain.Product.Product;

import java.util.List;

public interface PartnerFacade {
    Partner createPartner();
    void registerPartner(Partner partner, String email, String username, String password);
    void addProducts(List<Product> productList, Partner partner);
}
