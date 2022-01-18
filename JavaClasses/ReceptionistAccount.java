package JavaClasses;

public class ReceptionistAccount extends Account {
    private String accountType;
    public ReceptionistAccount(String password, String status) {
        super(password, status);
        this.accountType="RECEPTIONIST";
    }
    public ReceptionistAccount(String accountId,String password, String status) {
        super(password, status);
        this.accountType="RECEPTIONIST";
        setAccountId(accountId);
    }

    @Override
    public String toString() {
        return "ReceptionistAccount{" +
                "accountId='" + getAccountId() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", accountType='" + accountType + '\'' +
                ", status='" + getStatus() +
                "'}";
    }

}