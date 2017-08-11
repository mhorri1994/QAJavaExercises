/**
 * Created by Matthew on 07/08/2017.
 */
public class Beginner {
    public static void main(String[] args) {
        helloWorld();
        System.out.println("~");
        helloWorldVariable();
        System.out.println("~");
        outputParameter("Hello World!");
        System.out.println("~");
        System.out.println(returnHelloWorld());
        System.out.println("~");
        System.out.println(sum(2, 3));
        System.out.println("~");
        System.out.println(sum2(2, 3, true));
        System.out.println("~");
        System.out.println(sum3(0, 3, true));
        System.out.println("~");
        iteration();
        System.out.println("~");
        arrays();
        System.out.println("~");
        arraysIteration();
        System.out.println("~");
        arraysIteration2();
        System.out.println("~");
        System.out.println("~");
    }

    private static void helloWorld(){
        System.out.println("Hello World!");
    }

    private static void helloWorldVariable(){
        String helloWorld = "Hello World!";
        System.out.println(helloWorld);
    }

    private static void outputParameter(String message){
        System.out.println(message);
    }

    private static String returnHelloWorld(){
        return "Hello World!";
    }

    private static int sum(int first, int second){
        return first+second;
    }

    private static int sum2(int first, int second, boolean multiply){
        if(!multiply) return first+second;
        else return first*second;
    }

    private static int sum3(int first, int second, boolean multiply){
        if(first == 0) return first;
        else if(second == 0) return second;
        if(!multiply) return first+second;
        else return first*second;
    }

    private static void iteration(){
        for(int i = 0;i < 10; i++){
            System.out.print(sum3(i, 5, false) + ", ");
        }
        System.out.println();
    }

    private static void arrays(){
        int[] tempArray = new int[10];
        for(int i = 0;i < 10; i++){
            tempArray[i] = i;
        }
        for(int i = 0;i < 10; i++){
            System.out.print(sum3(tempArray[i], 5, false) + ", ");
        }
        System.out.println();
    }

    private static void arraysIteration(){
        int[] tempArray = new int[10];
        for(int i = 0;i < 10; i++){
            tempArray[i] = i;
        }
        for(int i = 0;i < 10; i++){
            System.out.print(tempArray[i] + ", ");
        }
        System.out.println();
    }

    private static void arraysIteration2(){
        int[] tempArray = new int[10];
        for(int i = 0;i < 10; i++){
            tempArray[i] = i;
            System.out.print(tempArray[i] + ", ");
        }
        System.out.println();
        for(int i = 0;i < 10; i++){
            tempArray[i] *= 10;
            System.out.print(tempArray[i] + ", ");
        }
        System.out.println();
    }

}
