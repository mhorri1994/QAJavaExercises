import java.util.HashMap;

/**
 * Created by Matthew on 07/08/2017.
 */
public class PrimeCalculator {
    int min = 3;
    int max = 100000000;
    public static void main(String[] args) {
        new PrimeCalculator().countPrimes();
    }

    public PrimeCalculator(){}

    public void countPrimes(){
        int count = 0;
        for(int i = min; i <= max; i++){
            if(isPrime(i)) count++;
        }
        System.out.println(count);
    }

    boolean isPrime(int n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
