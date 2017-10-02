package Domain.Account.AccountManagement;

import Repository.Account.AccountDAO;

public class AccountUpdateImpl implements AccountUpdate {
    private AccountDAO accountDAO;

    @Override
    public boolean updateUserName(String username) {
        return false;
    }

    @Override
    public boolean updatePassword(String password) {
        return false;
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
        return false;
    }

    @Override
    public boolean updateEmail(String email) {
        return false;
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return false;
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return false;
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return false;
    }
}
