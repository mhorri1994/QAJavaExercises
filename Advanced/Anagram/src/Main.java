import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Administrator on 11/08/2017.
 */
public class Main {


    public static void main(String[] args) throws Exception{
        long time = System.currentTimeMillis();
        Anagram anagram = new Anagram();
        anagram.readFile();
        anagram.findAnagrams();
        anagram.countHighest();
        System.out.println("Time: " + (System.currentTimeMillis() - time));
//        anagram.printMap();
    }

}
