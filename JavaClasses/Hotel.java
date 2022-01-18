package JavaClasses;

public class Hotel {
    private String name;
    private Address location;

    public Hotel(String name, Address location) {
        this.name = name;
        this.location = location;
    }

    private static final Hotel INSTANCE = new Hotel("CASINO",new Address("512","Chihia","Sfax","3041","Tunisia"));

    public static Hotel getInstance()
    {
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "JavaClasses.Hotel{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
