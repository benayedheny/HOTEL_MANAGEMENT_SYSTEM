package JavaClasses;

public class ManagerAccount extends Account {
    private String accountType;
    public ManagerAccount(String accountId,String password,String status) {
        super(password,status);
        this.accountType="MANAGER";
    }
    @Override
    public String toString() {
        return "ManagerAccount{" +
                "accountId='" + getAccountId() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", accountType='" + accountType + '\'' +
                ", status='" + getStatus() +
                "'}";
    }

}