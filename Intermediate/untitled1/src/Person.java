import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Created by Matthew on 07/08/2017.
 */
public class Person {
    private int age;
    private String name;
    private String occupation;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Person(int age, String name, String occupation) {

        this.age = age;
        this.name = name;
        this.occupation = occupation;
    }

    @Override
    public String toString(){
        return name +","+ age + "," + occupation;
    }
}
