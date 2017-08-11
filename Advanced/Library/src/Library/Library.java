package Library;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Matthew on 09/08/2017.
 */
public class Library {
    public static int nextID = -1;
    private HashMap<LibraryItem, Integer> storedItems = new HashMap<>();
    private List<Person> users = new ArrayList<>();

    public void checkOutLibraryItem(LibraryItem item, Person p){
        if(storedItems.getOrDefault(item, 0) > 0){
        decrementHashMap(storedItems, item);
        p.addLibraryItem(item);
        } else {
            throw new Error("It seems that there are none of that item left.");
        }
    }

    public void checkOutLibraryItem(int ID, Person p){
        for(LibraryItem item:storedItems.keySet()){
            if(item.getId() == ID){
                if(storedItems.getOrDefault(item, 0) > 0) {
                    decrementHashMap(storedItems, item);
                    p.addLibraryItem(item);
                    return;
                } else {
                    throw new Error("It seems that there are none of that item left.");
                }
            }
        }
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

    public void checkInItem(LibraryItem item, Person p){
        if(p.hasItem(item)) {
            p.removeLibraryItem(item);
            incrementHashMap(storedItems, item);
        } else {
            throw new Error("That user does not have that item.");
        }
    }

    public void checkInItem(int ID, Person p){
        incrementHashMap(storedItems, p.removeLibraryItem(ID));
    }


    //should these two methods decrease the quantity to 0?
    //what happens if a user returns a book that has been removed?

    public void removeItem(LibraryItem item){
        storedItems.remove(item);
    }

    public void removeItem(int ID){
        for(LibraryItem item:storedItems.keySet()){
            if(item.getId() == ID) {
                storedItems.remove(item);
                return;
            }
        }
    }

    public void updateItem(LibraryItem itemToUpdate, LibraryItem itemToUpdateFrom){
        itemToUpdate.updateMe(itemToUpdateFrom);
    }

    public void updateItem(int idOfItemToUpdate, LibraryItem whatToUpdateTo){
        for(LibraryItem item:storedItems.keySet()){
            if(item.getId() == idOfItemToUpdate) item.updateMe(whatToUpdateTo);
        }
    }

    public void registerPerson(Person newPerson){
        users.add(newPerson);
    }

    public void deletePerson(Person p){
        users.remove(p);
    }

    public void deletePerson(int ID){
        //TODO: Catch here if the ID does not exist, can't delete a null!?!?
        Person toRemove = null;
        for(Person p:users){
            if(p.getId() == ID) toRemove = p;
        }
        if(toRemove == null) throw new Error("That ID cannot be found");
        users.remove(toRemove);
    }

    public void updatePerson(int ID, Person newDetails){
        for(Person p:users){
            if(p.getId() == ID) {
                p.updateMe(newDetails);
            }
        }
    }

    public void updatePerson(Person personToUpdate, Person whatToUpdate){
        personToUpdate.updateMe(whatToUpdate);
    }

    public void addItem(LibraryItem item){
        incrementHashMap(storedItems, item);
    }

    public boolean checkIfItemIsInStock(int id){
        for(LibraryItem item:storedItems.keySet()){
            if(item.getId() == id) return true;
        }
        return false;
    }

    public boolean checkIfItemIsInStock(LibraryItem item){
        if(storedItems.containsKey(item)){
            if(storedItems.get(item)> 0) return true;
        }
        return false;
    }

    public boolean checkPersonExists(Person p){
        if(users.contains(p)) return true;
        return false;
    }

    public boolean checkPersonExists(int ID){
        for(Person p:users){
            if(p.getId() == ID){
                return true;
            }
        }
        return false;
    }

//    public void printStoredItems(){
//        for(LibraryItem i:storedItems.keySet()){
//            System.out.println(i);
//        }
//    }

    public HashMap<LibraryItem, Integer> getStoredItems() {
        return storedItems;
    }

    public List<Person> getUsers() {
        return users;
    }

    public void loadLibrary(Library library){
        this.storedItems = library.storedItems;
        this.users = library.users;

    }

    public void saveLibrary(){
        try {
            FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\LibrarySave_users.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Person p: users){
                bw.write(p + "\n");
            }
            bw.flush();
            bw.close();

            fw = new FileWriter(System.getProperty("user.dir") + "\\LibrarySave_items.txt", true);
            bw = new BufferedWriter(fw);
            for(LibraryItem i:storedItems.keySet()){
                bw.write(i + "," + storedItems.get(i) + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadLibrary(){
        try {
            File file = new File(System.getProperty("user.dir") + "\\LibrarySave_users.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineAddress = line.substring(line.indexOf("[") + 1, line.indexOf("]", line.indexOf("[") + 1)).split(",");
                Address address = new Address(lineAddress[0], lineAddress[1], lineAddress[2], lineAddress[3], lineAddress[4],lineAddress[5],lineAddress[6]);
                Person newPerson = new Person(address, line.substring(line.lastIndexOf(",") + 1));
                users = new ArrayList<>();
                users.add(newPerson);
            }
            file = new File(System.getProperty("user.dir") + "\\LibrarySave_items.txt");
            br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

