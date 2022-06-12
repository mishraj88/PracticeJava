// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class StringCountDemo{
    public static void main(String args[]) throws IOException { 
        System.out.println("Enter two numbers separetd by Space");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 
        //String st = br.readLine();

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            //
		
            System.out.println(Solution_2.solve(X,Y,S)); 

            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution_2 
{ 
    static long solve(int x,int y, String s)
	{    
	    // code here
	    
	    /*
	        from the string we need to find max PRs if X > Y
	        from the string we need to find all 
	    */
        
        //boolean ifRPPresent = s.contains("rp");
        //boolean ifPrPresemt = s.contains("pr");
        int XGreaterThanY = x -y;
        int countX =0, countY = 0;
        if(XGreaterThanY > 0){
            int[] countArray = countSubstringsWithReplacement(s, "pr", "rp");
            countX = countArray[0];
            countY = countArray[1];
            
        }
        else if(XGreaterThanY < 0){
            int[] countArray = countSubstringsWithReplacement(s, "rp", "pr");
            countX = countArray[1];
            countY = countArray[0];
            
        }else{
            //int maxPRCount = countSubstrings(s, "pr");
            int maxPRCount = countSubstringsWithReplacement(s, "pr", null)[0];
            //int maxRPCount = countSubstrings(s, "rp");
            System.out.println("maxPRCount: "+maxPRCount);
            System.out.println("String: "+s);
            int maxRPCount = countSubstringsWithReplacement(s, "rp", null)[0];

            System.out.println("String: "+s);

            System.out.println("maxRPCoun1t: "+maxRPCount);
            
            if(maxPRCount >= maxRPCount){
                System.out.println("Hello");
                int[] countArray = countSubstringsWithReplacement(s, "pr", "rp");
                countX = countArray[0];
                System.out.println("countX= "+countX);
                countY = countArray[1];
                System.out.println("countY= "+countY);
            }else{
                System.out.println("hello 2");
                int[] countArray = countSubstringsWithReplacement(s, "rp", "pr");
                countX = countArray[1];
                System.out.println("countX= "+countX);
                countY = countArray[0];
                System.out.println("countX= "+countX);
            }
        }
        
        
        
        return countX*x+countY*y;
	}
	
	public static int countSubstrings(String st, String sub){
	    int count = 0;
	    int index = st.indexOf(sub);
	    while(index>-1){
	        st =st.substring(0, index) + st.substring(index+sub.length());
	        index = st.indexOf(sub);
	        count++;
	    }
	    return count;
	}
	
	public static int[] countSubstringsWithReplacement(String s, String sub1, String sub2){
	    int[] countArray = new int[2];
	    int count_1 = 0;
	    int count_2 = 0;
	    StringBuilder sb = new StringBuilder(s);
	    int index = -1;
	    if(sub1 != null){
            int length = sub1.length();
	        index = sb.indexOf(sub1);
	        while(index > -1){
                System.out.println("=========");
                System.out.println("index: "+index);
                System.out.println("Sb: b4 delete: "+sb+" and sub: "+sub1);
                int start = index;
                int end= index + length;
                System.out.println("StartIndex: "+start+ " endIndex: "+end);
	            sb = sb.delete(start, end);
                System.out.println("SB: after delete "+sb+" and sub: "+sub1);
	            count_1++;
                System.out.println("count_1= "+count_1);
	            index = sb.indexOf(sub1);
	        
	        }
	    }
	    //index = 0;
	    if(sub2 != null){
            int length = sub2.length();
	        index = sb.indexOf(sub2);
            System.out.println("index: "+index);
	        while(index > -1){
                System.out.println("========");
                System.out.println("index: "+index);
                int start = index;
                int end= index + length;
                System.out.println("StartIndex: "+start+ " endIndex: "+end);
	            sb = sb.delete(start, end);
	            //sb = sb.delete(index, index+length-1);
                System.out.println("SB: after delete "+sb+" and sub: "+sub2);
	            count_2++;
                System.out.println("count_2= "+count_2);
	            index = sb.indexOf(sub2);
	        }
	    }
	    countArray[0] = count_1;
	    countArray[1] = count_2;
	    
	    return countArray;
	}
} 
