package Domain.Account.AccountProfile.Finance;

public interface BankAccount {
    String getBankName();
    String getRoutingNumber();
    String getAccountNumber();
    String getSwiftCode();
    String getAccountType();

    void setBankName(String bankName);
    void setRoutingNumber(String routingNumber);
    void setAccountNumber(String accountNumber);
    void setSwiftCode(String swiftCode);
    void setAccountType(String accountType);
}
