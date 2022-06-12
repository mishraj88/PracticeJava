import java.util.*;

public class MaxSubStringWithNonRepeatingChars {
    public static void main(String[] args) {
        MyDemo obj = new MyDemo();
        String s = "abcabcbb";
        int length = obj.lengthOfLongestSubstring(s);
        System.out.println("length : "+length);
    }
}

class MyDemo {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        //StringBuilder sb = new StringBuilder();
        //String maxSubstring = "";
        int maxSubLength = 1;
        
        int start = 0;
        int end = start+1;
        char curr = s.charAt(start);
        map.put(curr, start);
        
        //sb.append(s.charAt(start));
        do{
            char c = s.charAt(end);
            if(map.get(c) == null){
                map.put(c, end);
                //sb.append(c);
                end++;
            }else{
                //int length = sb.length();
                int length = end - start;
                if(maxSubLength < length){
                    maxSubLength = length;
                    //maxSubstring = sb.toString();
                    //sb.delete(0, length);
                }
                start = map.get(c)+1;
                map.put(c, end);
            }
            
           
        }while(start != end && end < s.length());
         return maxSubLength;
        
        
    }
}
