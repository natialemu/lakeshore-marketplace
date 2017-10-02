package Domain.Account.AccountProfile;

public class AccountProfileImpl implements AccountProfile{
    private String username;
    private String password;

    public AccountProfileImpl(String username, String password){
        this.username = username;
        this.password = password;
    }
}
