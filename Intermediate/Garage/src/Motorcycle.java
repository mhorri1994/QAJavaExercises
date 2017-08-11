/**
 * Created by Matthew on 07/08/2017.
 */
public class Motorcycle extends Vehicle{
    private boolean sideCar = false;

    public boolean isSideCar() {
        return sideCar;
    }

    public void setSideCar(boolean sideCar) {
        this.sideCar = sideCar;
    }

    public Motorcycle(int ID, int value, boolean sideCar) {
        super(ID, value);
        this.sideCar = sideCar;
    }

    public Motorcycle(int ID, int value) {
        super(ID, value);
    }
    public Motorcycle(int value) {
        super(value);
    }
    public int costToFix(){return getValue() - (int) (getValue()/1.5);}

}
