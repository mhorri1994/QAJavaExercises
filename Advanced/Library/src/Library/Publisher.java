package Library;

/**
 * Created by Matthew on 09/08/2017.
 */
public class Publisher {
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Publisher(String name, Address address) {

        this.name = name;
        this.address = address;
    }

    public String toString() {
        return name + "," + address;
    }
}