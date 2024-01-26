import java.io.*;
import java.util.*;

class Result {
   
    public static List<Integer> findPoint(int px, int py, int qx, int qy) {
        // Calculate the coordinates of the reflected point
        int rx = 2 * qx - px;
        int ry = 2 * qy - py;

        // Create a list to store the coordinates of the reflected point
        List<Integer> result = new ArrayList<>();
        result.add(rx);
        result.add(ry);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for (int nItr = 0; nItr < n; nItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int px = Integer.parseInt(firstMultipleInput[0]);
            int py = Integer.parseInt(firstMultipleInput[1]);
            int qx = Integer.parseInt(firstMultipleInput[2]);
            int qy = Integer.parseInt(firstMultipleInput[3]);

            List<Integer> result = Result.findPoint(px, py, qx, qy);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
