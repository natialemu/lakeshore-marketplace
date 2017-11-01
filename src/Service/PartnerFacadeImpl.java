package Service;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Partner.Partner;
import Domain.Partner.PartnerImpl;
import Domain.Product.Product;
import Domain.Product.ProductFactory;
import Domain.Product.ProductFactoryImpl;
import Domain.ReviewSystem.ReviewSystemImpl;

import java.util.List;

public class PartnerFacadeImpl implements PartnerFacade{
    private AccountFactory accountFactory;
    private ProductFactory productFactory;

    public PartnerFacadeImpl(){
        accountFactory = new AccountFactoryImpl();
        productFactory = new ProductFactoryImpl();
    }

    @Override
    public Partner createPartner() {
        return new PartnerImpl();
    }

    @Override
    public void registerPartner(Partner partner, String email, String username, String password) {

//        Account newAccount = accountFactory.getNewAccount(email,username,password);
//        accountFactory.createBasicAccount(newAccount);
//        partner.setAccount(newAccount);
//        partner.createPartner();
    }

    @Override
    public void addProducts(List<Product> productList, Partner partner) {

//        for(Product p: productList){
//            p.setPartner(partner);
//            productFactory.createProduct(p);
//        }

    }


}
