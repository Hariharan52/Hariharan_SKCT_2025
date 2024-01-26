import java.io.*;
import java.util.*;

class Result {

    public static int connectingTowns(int n, List<Integer> routes) {
        // Write your code here
        long totalRoutes = 1;
        for (int i = 0; i < n - 1; i++) {
            totalRoutes = (totalRoutes * routes.get(i)) % 1234567;
        }

        return (int) totalRoutes;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] routesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> routes = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                int routesItem = Integer.parseInt(routesTemp[i]);
                routes.add(routesItem);
            }

            int result = Result.connectingTowns(n, routes);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
