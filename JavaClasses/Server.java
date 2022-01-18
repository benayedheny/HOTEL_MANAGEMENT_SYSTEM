package JavaClasses;

public class Server extends Person{
    private String serverAccountId;
    private static int id=0;

    public Server(String fname, String lname,String CIN, String email, String phone) {
        super(fname, lname,CIN, email, phone);

    }

    public String getserverAccountId() {
        return serverAccountId;
    }

    public void setserverAccountId(String serverAccountId) {
        this.serverAccountId = serverAccountId;
    }

    public String toString() {
        return "Server{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", CIN='" + CIN + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", serverAccountId='" + serverAccountId+
                '}';
    }
}
