public class CountSubstrings {

    public static void main(String[] args) {

        //long value = Solution.solve(3, 3, "abrrrppprrrp");
        //System.out.println("value: "+value);
        long val = Solution.countSubstrings("abrrrppprrrp", "pr");
        System.out.println("val: "+val);

    }

    

}
class Solution {
    static long solve(int x, int y, String s) {
        // code here

        /*
         * from the string we need to find max PRs if X > Y
         * from the string we need to find all
         */

        // boolean ifRPPresent = s.contains("rp");
        // boolean ifPrPresemt = s.contains("pr");
        int XGreaterThanY = x - y;
        int countX = 0, countY = 0;
        if (XGreaterThanY > 0) {
            while (s.contains("pr")) {
                s = s.replace("pr", "");
                countX++;
            }
            while (s.contains("rp")) {
                s = s.replace("rp", "");
                countY++;
            }
        } else if (XGreaterThanY < 0) {
            while (s.contains("rp")) {
                s = s.replace("rp", "");
                countY++;
            }
            while (s.contains("pr")) {
                s = s.replace("pr", "");
                countX++;
            }

        } else {
            int maxPRCount = countSubstrings(s, "pr");
            int maxRPCount = countSubstrings(s, "rp");
            System.out.println("maxPRCount = "+maxPRCount);
            System.out.println("maxRPCount = "+maxRPCount);
            System.out.println("String = "+s);
           /* if (maxPRCount >= maxRPCount) {
                for (int i = 0; i < maxPRCount; i++) {
                    s = s.replace("pr", "");

                }
                countX = maxPRCount;//abrrrppprrrprprrrrpbaabprbar
                countY = countSubstrings(s, "rp");
            } else {
                for (int i = 0; i < maxRPCount; i++) {
                    s = s.replace("rp", "");
                    // countY++;
                }
                countY = maxRPCount;
                countX = countSubstrings(s, "pr");
            }*/
        }

        return countX * x + countY * y;
    }

    public static int countSubstrings(String s1, String sub) {
        int count = 0;
        //String s = new String(s1);
        while (s1.indexOf(sub) >=0) {
            s1.replace(sub, "");
            count++;
        }
        return count;
    }
}
