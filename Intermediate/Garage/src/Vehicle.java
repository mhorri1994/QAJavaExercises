/**
 * Created by Matthew on 07/08/2017.
 */
public abstract class Vehicle {
    private int ID;
    private int value;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vehicle(int ID, int value) {

        this.ID = ID;
        this.value = value;
    }

    public Vehicle(int value){
        this.value = value;
    }

    public String toString() {
        return "ID: " + getID() + ", Type: " + getClass().getName() + ", VALUE: " + getValue();
    }

    public abstract int costToFix();
}