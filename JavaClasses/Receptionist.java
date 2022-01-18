package JavaClasses;

public class Receptionist extends Person{
    private String receptionistAccountId;
    private static int id=0;

    public Receptionist(String fname, String lname,String CIN, String email, String phone) {
        super(fname, lname,CIN, email, phone);

    }

    public String getreceptionistAccountId() {
        return receptionistAccountId;
    }

    public void setreceptionistAccountId(String receptionistAccountId) {
        this.receptionistAccountId = receptionistAccountId;
    }
    public String toString() {
        return "Receptionist{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", CIN='" + CIN + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", receptionistAccountId='" + receptionistAccountId+
                '}';
    }
}
