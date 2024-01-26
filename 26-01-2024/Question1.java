import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int findBestDivisor(int n) {
        int bestDivisor = 1;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int sum = digitSum(i);

                if (sum > maxSum || (sum == maxSum && i < bestDivisor)) {
                    maxSum = sum;
                    bestDivisor = i;
                }
            }
        }

        return bestDivisor;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = findBestDivisor(n);

        System.out.println(result);

        bufferedReader.close();
    }
}
