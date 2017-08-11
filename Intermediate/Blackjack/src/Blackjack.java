/**
 * Created by Matthew on 07/08/2017.
 */
public class Blackjack {
    public static void main(String[] args) {
        System.out.println(checkBlackjack(18, 21));
        System.out.println(checkBlackjack(20, 18));
        System.out.println(checkBlackjack(22, 22));
    }

    private static int checkBlackjack(int valueOne, int valueTwo){
        if(valueOne > 21 && valueTwo > 21) return 0;
        if(valueOne > 21 && valueTwo < 21) return valueTwo;
        if(valueTwo > 21 && valueOne < 21) return  valueOne;
        if(valueOne > valueTwo) return valueOne;
        else return valueTwo;
    }
}
