package Library;

import java.util.HashMap;

/**
 * Created by Matthew on 09/08/2017.
 */
public class Person {
    public static int nextID = -1;
    private int id;
    private Address address;
    private String name;
    HashMap<LibraryItem, Integer> checkedOutItems = new HashMap<>();

    public Person( Address address, String name) {
        this.id = nextID++;
        this.address = address;
        this.name = name;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Person.nextID = nextID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void incrementHashMap(HashMap<LibraryItem, Integer> map, LibraryItem item){
        if(map.containsKey(item))  map.put(item, map.get(item) + 1);
        else map.put(item, 1);
    }

    public void decrementHashMap(HashMap<LibraryItem, Integer> map, LibraryItem item){
        if(map.containsKey(item)){
            map.put(item, map.get(item) - 1);
        } else {
            //TODO: This area here should catch an error, when removing an item that doesn't exist

        }
    }

    public void addLibraryItem(LibraryItem item){
        checkedOutItems.put(item, checkedOutItems.getOrDefault(item, 0) + 1);
    }

    public void removeLibraryItem(LibraryItem item){
        decrementHashMap(checkedOutItems, item);
    }
    public LibraryItem removeLibraryItem(int ID){
        for(LibraryItem item:checkedOutItems.keySet()){
            if(item.getId() == ID) {
                decrementHashMap(checkedOutItems, item);
                return item;
            }
        }
        return null;
    }

    public void printOutCheckedOutItems(){
        for(LibraryItem i:checkedOutItems.keySet()){
            System.out.println(i);
        }
    }

    public void updateMe(Person newDetails){
        if(newDetails.getAddress() != null) this.address = newDetails.getAddress();
        if(newDetails.getName() != null && newDetails.getName() != "") this.name = newDetails.getName();
    }

    public boolean hasItem(LibraryItem item){
        if(checkedOutItems.getOrDefault(item, 0) > 0) return true;
        return false;
    }

    public String toString(){
        return id + "," + address + "," +  name;
    }
}
