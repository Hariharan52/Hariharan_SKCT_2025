import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rev = 0;
        while(n!=0)
        {
            int d = n%10;
            rev = rev*10 + d;
            n/=10;
        }
        System.out.print(rev);
    }
}
