import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int anagram(String s) {
      if (s.length() % 2 != 0) {
            return -1;
        }

        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);

        int[] frequency = new int[26]; 

        for (char c : s1.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            frequency[c - 'a']--;
        }

        int replacements = 0;

        for (int count : frequency) {
            replacements += Math.abs(count);
        }

        return replacements / 2;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
