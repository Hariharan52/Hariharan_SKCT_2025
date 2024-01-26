import java.io.*;
import java.util.*;

class Result {
    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY operations
     */

    public static int solve(int n, List<List<Integer>> operations) {
        // Initialize an array to represent the jars
        int[] jars = new int[n];

        // Process each operation
        for (List<Integer> operation : operations) {
            int a = operation.get(0) - 1;  // 0-based index
            int b = operation.get(1) - 1;  // 0-based index
            int k = operation.get(2);

            // Update the values in the specified range
            for (int i = a; i <= b; i++) {
                jars[i] += k;
            }
        }

        // Calculate the average of the values in the jars
        int sum = 0;
        for (int value : jars) {
            sum += value;
        }

        return sum / n;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> operations = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] operationsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> operationsRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int operationsItem = Integer.parseInt(operationsRowTempItems[j]);
                operationsRowItems.add(operationsItem);
            }

            operations.add(operationsRowItems);
        }

        int result = Result.solve(n, operations);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
