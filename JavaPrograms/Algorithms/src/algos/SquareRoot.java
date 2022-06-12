package algos;

import java.util.Scanner;

public class SquareRoot {

    static long i = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for square root finding task: ");
        long number = sc.nextLong();
       long result= findSquareRoot(number);
       System.out.println("Square root of : "+number + " is "+result);
    }

    private static long findSquareRoot(long number) {
        long answer = 0;
        long start = 0;
        long end = number;
        boolean isPerfectSquare = false;
        
        while(start <=end){
            if(start*start == number){
                answer = start;
                isPerfectSquare = true;
                break;
            }
            if(end*end == number) {
                answer = end;
                isPerfectSquare = true;
                break;
            }
            long mid = start + (end - start)/2;
            if(mid*mid > number){
                end = mid -1;
            }
            else{
                if(mid*mid== number){
                    isPerfectSquare = true;
                    answer = mid;
                    break;
                }else{
                    answer = mid;
                    start = mid+1;
                }
            }
        }
        System.out.println("isPerfectSquare: "+isPerfectSquare);
        return answer;
        
    }

    
}
