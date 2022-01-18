package JavaClasses;

public class GuestAccount extends Account {
    private String accountType;
    public GuestAccount(String password,String status) {
        super(password,status);
        this.accountType="GUEST";
    }

    public GuestAccount(String accountId,String password,String status) {
        super(password,status);
        this.accountType="GUEST";
        setAccountId(accountId);
    }

    @Override
    public String toString() {
        return "GuestAccount{" +
                "accountId='" + getAccountId() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", accountType='" + accountType + '\'' +
                ", status='" + getStatus() +
                "'}";
    }

}
