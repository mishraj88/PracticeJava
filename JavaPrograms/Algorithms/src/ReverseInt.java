import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.NumberOfDocuments;

public class ReverseInt {
    public static void main(String[] args) {
        MySolution obj = new MySolution();
        int x = 1534236469;
        int val = obj.reverse(x);

        System.out.println(val);
    }
}

class MySolution {
    public int reverse(int x) {
        /*
        10 can't be digit -
        it is combinatizeon of 2 digits = 1 and 0
        reverse of an input could overflow.
        use long to store int reverse, and check if long reverse > Integer.MAX_VALUE
        if true, reset reverse = 0 and return (int) reverse.
        
        Another approach:
        
        use stringBuilder to keep the input as string. Before taking the input int in stringbuilder
        covert it into positive integer.
        call String reverse = new StringBuilder.append(String.valueOf(Math.abs(input))).reverse();
        return (x<0)? Integer.parseInt(reverse) * -1 : Integer.parseInt(reverse);
        */
        
//         boolean negativeInt = false;
//         if(x == 0) return 0;
//         if(x < 0){
//             //if(x< Integer.MIN_VALUE) return 0;
//             negativeInt = true;
//             x = Math.abs(x);
            
//         }
        
//         if(x> Integer.MAX_VALUE) return 0;
//         int lastDigit = 0;
//         long reverse =0;
        
//         while(x>0){
//             lastDigit = x%10;
//             reverse = reverse*10+lastDigit;
//             if(reverse > Integer.MAX_VALUE){
//                 reverse = 0;
//                 break;
//             }
//             x=x/10;
//         }
//         //if(rever)
//         if(negativeInt) reverse = reverse*-1;
        
//         if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;
//         return (int)reverse;
        
            String reverse = new StringBuilder().append(Math.abs(x)).reverse().toString();
            try{
                return (x<0) ? Integer.parseInt(reverse) * -1 : Integer.parseInt(reverse);
            }catch(NumberFormatException e){
                return 0;
            }
        
    }
       
}


/*
 * Approach 1: Pop and Push Digits & Check before Overflow
Intuition

We can build up the reverse integer one digit at a time. While doing so, we can check beforehand whether or not appending another digit would cause overflow.

Algorithm

Reversing an integer can be done similarly to reversing a string.

We want to repeatedly "pop" the last digit off of xx and "push" it to the back of the \text{rev}rev. In the end, \text{rev}rev will be the reverse of the xx.

To "pop" and "push" digits without the help of some auxiliary stack/array, we can use math.

//pop operation:
pop = x % 10;
x /= 10;

//push operation:
temp = rev * 10 + pop;
rev = temp;
However, this approach is dangerous, because the statement \text{temp} = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop can cause overflow.

Luckily, it is easy to check beforehand whether or this statement would cause an overflow.

To explain, lets assume that \text{rev}rev is positive.

If temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop causes overflow, then it must be that \text{rev} \geq \frac{INTMAX}{10}rev≥ 
10
INTMAX
​
 
If \text{rev} > \frac{INTMAX}{10}rev> 
10
INTMAX
​
 , then temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop is guaranteed to overflow.
If \text{rev} == \frac{INTMAX}{10}rev== 
10
INTMAX
​
 , then temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop will overflow if and only if \text{pop} > 7pop>7
Similar logic can be applied when \text{rev}rev is negative.
 */

class MySolution2 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}