package JavaClasses;

public class ServerAccount extends Account {
    private String accountType;
    private static int id=0;
    public ServerAccount(String password,String status) {
        super(password,status);
        this.accountType="SERVER";
    }

    public ServerAccount(String accountId,String password,String status) {
        super(password,status);
        this.accountType="SERVER";
        setAccountId(accountId);
    }
    @Override
    public String toString() {
        return "ServerAccount{" +
                "accountId='" + getAccountId() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", accountType='" + accountType + '\'' +
                ", status='" + getStatus() +
                "'}";
    }

}