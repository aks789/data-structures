package backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * String pattern matcher without using regular expressions
 * This solution uses back tracking
 * Created by AKRITI on 4/20/2019.
 */
public class StringPatternMatcher {


    // Function to determine if a pattern matches string or not
    public boolean match(String input, int i, String pattern, int j , Map<Character,String> map){
        int n = input.length();
        int m = pattern.length();

        // Base condition
        if(n<m){
            return false;
        }

        // If both string and pattern reaches the end
        if(i==n && j==m){
            return true;
        }

        // If either string / pattern reaches the end
        if(i==n || j==m){
            return false;
        }

        // Consider the next character of the pattern
        char curr = pattern.charAt(j);

        // If this character is seen before
        if(map.containsKey(curr)){
            String s = map.get(curr);
            int k = s.length();

            // ss stores the next k characters of the given string
            String ss;
            if(i+k < input.length()){
                ss = input.substring(i,i+k);
            }else{
                ss = input.substring(i);
            }

            // return false if the next k characters does not match with s
            if(ss.compareTo(s) !=0){
                return false;
            }
            // recurse for remaining characters if next k characters matches
            return match(input,i+k,pattern,j+1,map);
        }

        // process all the remaining characters of the string if the curr character is never seen before
        for(int k=1;k<=n-i;k++){

            // insert the substring formed by the next k characters of the string
            // into the map
            map.put(curr,input.substring(i,i+k));

            //check if it leads to the solution
            if(match(input,i+k,pattern,j+1,map)){
                return true;
            }

            // else backtrack - remove current character from the map
            map.remove(curr);
        }
        return false;
    }

    public static void main(String[] args){
        StringPatternMatcher stringPatternMatcher = new StringPatternMatcher();

        String input ="codesleepcode";
        String pattern="GFG";

        Map<Character,String> map = new HashMap();

        if(stringPatternMatcher.match(input,0,pattern,0,map)){
            for(Map.Entry<Character,String> entry : map.entrySet()){
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
        else{
            System.out.println("Solution Does not exist!!");
        }
    }
}
