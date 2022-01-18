package JavaClasses;

public class Guest extends Person{
    private String guestAccountId;

    public Guest(String fname, String lname,String CIN, String email, String phone) {
        super(fname, lname,CIN, email, phone);
    }

    public String getGuestAccountId() {
        return guestAccountId;
    }

    public void setGuestAccount(String guestAccountId) {
        this.guestAccountId = guestAccountId;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", CIN='" + CIN + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", guestAccountId='" + guestAccountId+
                '}';
    }
}

