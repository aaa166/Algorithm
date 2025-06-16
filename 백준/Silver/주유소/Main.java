import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        long[] len = new long[n-1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n-1; i++) {
            len[i] = Integer.parseInt(input[i]);
        }
        long[] cost = new long[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(input[i]);
        }

        long min = cost[0];
        long result = min * len[0];
        for (int i = 1; i < n-1; i++) {
            min = Math.min(min, cost[i]);
            result = result + (min*len[i]);
        }
        System.out.println(result);

    }
}
