/**
 * Created by Matthew on 08/08/2017.
 */
public class Boat extends Vehicle{
    public boolean isSails() {
        return sails;
    }

    public void setSails(boolean sails) {
        this.sails = sails;
    }

    public Boat(int ID, int value, boolean sails) {
        super(ID, value);
        this.sails = sails;
    }

    public Boat(int value, boolean sails) {
        super(value);
        this.sails = sails;
    }

    public Boat(int value){
        super(value);
    }

    private boolean sails = false;
    public int costToFix(){return getValue() - getValue()/9;}

}
