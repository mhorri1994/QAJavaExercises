/**
 * Created by Matthew on 07/08/2017.
 */
public class TooHot {
    public static void main(String[] args) {
        System.out.println(checkIfItIsTooHot(95, false));
        System.out.println(checkIfItIsTooHot(95, true));
    }

    public static boolean checkIfItIsTooHot(int temperature, boolean isSummer){
        int upperLimit = 90;
        if(isSummer) upperLimit = 100;
        if(temperature >= 60 && temperature <= upperLimit) return false;
        if(temperature < 60) return false;
        return true;
    }
}
