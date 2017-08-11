/**
 * Created by Matthew on 07/08/2017.
 */
public class UniqueSum {
    public static void main(String[] args) {
        System.out.println(calculateUniqueSum(1, 2 ,3));
        System.out.println(calculateUniqueSum(3, 3, 3));
        System.out.println(calculateUniqueSum(1, 1, 2));
    }

    private static int calculateUniqueSum(int one, int two, int three){
        int total = 0;
        if(one != two && one != three) total += one;
        if(two != one && two != three) total += two;
        if(three != two && three != one) total += three;

        return total;
    }
}
