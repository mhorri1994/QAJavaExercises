import java.util.ArrayList;

/**
 * Created by Matthew on 07/08/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        Person personOne = new Person("Matthew", 22, "Consultant");
        Person personTwo = new Person("Patrick", 23, "Student");
        Person personThree = new Person("Sam", 22, "Unemployed");
        ArrayList<Person> people = new ArrayList<>();
        people.add(personOne);
        people.add(personTwo);
        people.add(personThree);
        for(Person p:people){
            System.out.println(p);
        }
        System.out.println(findPerson(people, "Patrick"));
    }

    public Person findPerson(ArrayList<Person> people, String name){
        for(Person p:people){
            if(p.getName().equals(name))return p;
        }
        return null;
    }
}
