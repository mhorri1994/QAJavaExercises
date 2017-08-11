import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 11/08/2017.
 */
public class Strings {
    public void findLongestCommonSubsequence(String firstString, String secondString){
        List<String> subStrings;
        String shortest = "", longest ="";
        if(firstString.length() < secondString.length()){
            shortest = firstString;
            longest = secondString;
        }else{
            shortest = secondString;
            longest = firstString;
        }
        subStrings = getAllSubStrings(shortest);
        int longestSubSequenceLength = 0;
        String longestSubSequence = "";
        for(String s:subStrings){
            if(longest.contains(s)) {
                if(s.length() > longestSubSequenceLength){
                    longestSubSequenceLength = s.length();
                    longestSubSequence = s;
                }
            }
        }
        System.out.println("The longest subsequence is " + longestSubSequence + " at " +
                longestSubSequenceLength + " characters");
    }
    public List<String> getAllSubStrings(String string){
        List<String> allStrings = new ArrayList<>();
        for(int i = 0; i<string.length(); i++){
            for(int j = i; j<string.length();j++){
                if(!allStrings.contains(string.substring(i, j+1))) allStrings.add(string.substring(i, j+1));
            }
        }
        return allStrings;
    }
}
