import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Administrator on 11/08/2017.
 */
public class Anagram {
    List<String> wordsRead = new ArrayList<>();
    HashMap<String, List<String>> sortedWords = new HashMap<>();

    public void readFile(){
        try{
            FileReader fr = new FileReader(System.getProperty("user.dir") + "\\wordList.txt");
            BufferedReader br = new BufferedReader(fr);
            String input = "";
            while(!(input = br.readLine()).equals("")){
                wordsRead.add(input);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {

        }
    }

    public String sortString(String input){
        char[] sorted = input.toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }

    public void findAnagrams(){
        String s2 = "";
        for(String s:wordsRead){
            s2 = bubbleSort(s);
            List<String> addList;
            if(sortedWords.keySet().contains(s2)){
                addList = sortedWords.get(s2);
                addList.add(s);
                sortedWords.put(s2, addList);
            } else {
                addList = new ArrayList<>();
                addList.add(s);
                sortedWords.put(s2, addList);
            }
        }
    }

    public String bubbleSort(String toSort){
        char[] chars = toSort.toCharArray();
        int n = toSort.length();
        int temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < (n-i);j++){
                if((int)chars[j-1] > (int)chars[j]){
                    temp = (int) chars[j-1];
                    chars[j-1] = chars[j];
                    chars[j] = (char) temp;
                }
            }
        }
        return new String(chars);
    }

    public void countHighest(){
        int occurences = 0;
        List<String> words = new ArrayList<>();
        for(String s:sortedWords.keySet()){
            int count = sortedWords.get(s).size();
            if(count == occurences){
                words.add(s);
            }
            if(count > occurences) {
                occurences = count;
                words = new ArrayList<>();
                words.add(s);
            }
        }
        for(String s:words){
            System.out.println(s);
        }
    }

    public void printMap(){
        for(String key:sortedWords.keySet()){
            System.out.println(key + " : " + sortedWords.get(key));
        }
    }
}
