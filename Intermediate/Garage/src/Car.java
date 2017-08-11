/**
 * Created by Matthew on 07/08/2017.
 */
public class Car extends Vehicle {
    private int numberOfDoors = 0;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Car(int value) {
        super(value);
    }

    public Car(int ID, int value) {
        super(ID, value);
    }

    public int costToFix(){return getValue() - getValue()/3;}
}
