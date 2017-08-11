import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Matthew on 07/08/2017.
 */
public class WorkingWithFiles {
    public static void main(String[] args) {
        new WorkingWithFiles();
    }

    public WorkingWithFiles() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(22, "Matthew", "Consultant"));
        people.add(new Person(23, "Patrick", "Student"));
        people.add(new Person(22, "Sam", "Unemployed"));
        for(Person p:people){
            System.out.println(p);
            writeToFile(p);
        }
        System.out.println("\nRemoved all people.\n");
        people.removeAll(people);
        people = readFromFile();
        for(Person p:people){
            System.out.println(p);
        }
    }

    public void writeToFile(Person p) {
        try {
            FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\People.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(p.toString() + "\n");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> readFromFile() {
        ArrayList<Person> people = new ArrayList<>();
        try {
            File file = new File(System.getProperty("user.dir") + "\\People.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(",");
                people.add(new Person(Integer.parseInt(lineSplit[1]), lineSplit[0], lineSplit[2]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return people;
    }
}