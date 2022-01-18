package JavaClasses;

public class Manager extends Person{
    private String managerAccountId;
    private static int id=0;

    public Manager(String fname, String lname, String CIN, String email, String phone, String managerAccountId) {
        super(fname, lname, CIN, email, phone);
        this.managerAccountId="Manager"+id;
        id+=1;
    }

    public String getManagerAccountId() {
        return managerAccountId;
    }

    public void setManagerAccountId(String managerAccountId) {
        this.managerAccountId = managerAccountId;
    }

    public String toString() {
        return "Manager{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", CIN='" + CIN + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", managerAccountId='" + managerAccountId+
                '}';
    }
}
