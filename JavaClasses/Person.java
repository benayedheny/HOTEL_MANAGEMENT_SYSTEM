package JavaClasses;

public abstract class Person {
    protected String fname;
    protected String lname;
    protected String CIN;
    protected String email;
    protected String phone;

    public Person(String fname, String lname, String CIN, String email, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.CIN = CIN;
        this.email = email;
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
}
