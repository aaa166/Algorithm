import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + 2 * dp[i-2];
        }

        int result;

        if (n % 2 == 1) {
            result = (dp[n] + dp[n/2]) / 2;
        } else {
            result = (dp[n] + dp[n/2] + 2 * dp[n/2-1]) / 2;
        }

        System.out.println(result);
    }
}
