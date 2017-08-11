import jdk.nashorn.internal.objects.NativeJava;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Matthew on 07/08/2017.
 */
public class Garage {
    //Using an ArrayList for faster searching
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.addVehicle(new Car(1000));
        garage.addVehicle(new Car(2000));
        garage.addVehicle(new Motorcycle(1500));
        garage.addVehicle(new Motorcycle(2500));
        garage.addVehicle(new Car(1300));
        garage.addVehicle(new Boat(5000));
        garage.addVehicle(new Boat(10000));
        garage.printGarage();
        System.out.println("Cost to fix vehicle 7: " + garage.getFixCost(7));
        garage.removeVehicle(1);
        System.out.println("----------");
        garage.printGarage();
        garage.removeVehicle(Motorcycle.class);
        System.out.println("----------");
        garage.printGarage();
        System.out.println("----------");
        garage.emptyGarage();
        garage.printGarage();
    }

    public void printGarage(){
        for(Vehicle v:vehicles){
            System.out.println(v);
        }
    }

    public void addVehicle(Vehicle newVehicle){
        newVehicle.setID(vehicles.size()+1);
        vehicles.add(newVehicle);
    }

    public void removeVehicle(int id){
        ArrayList<Vehicle> listToRemove = new ArrayList<>();
        for(Vehicle v:vehicles){
            if(v.getID() == id) listToRemove.add(v);
        }
        vehicles.removeAll(listToRemove);
        //re-do the ID's so future ones are added to the correct location
        int counter = 0;
        for(Vehicle v:vehicles){
            v.setID(counter);
        }
    }

    public void removeVehicle(Class<?> removeType){
        ArrayList<Vehicle> listToRemove = new ArrayList<>();
        for(Vehicle v:vehicles){
            if(removeType == v.getClass()) listToRemove.add(v);
        }
        vehicles.removeAll(listToRemove);
        //re-do the ID's so future ones are added to the correct location
        int counter = 0;
        for(Vehicle v:vehicles){
            v.setID(counter++);
        }
    }

    public void emptyGarage(){
        vehicles.removeAll(vehicles);
    }

    public int getFixCost(int ID){
        return vehicles.get(ID-1).costToFix();
    }

    public int getFixCost(Vehicle v){
        return v.costToFix();
    }
}
