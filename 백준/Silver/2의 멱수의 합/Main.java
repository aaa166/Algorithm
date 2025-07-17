import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 1;


        for (int i = 1; i <= n; i *= 2) {
            for (int j = i; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - i]) % 1000000000;
            }
        }

        System.out.println(dp[n]);
        br.close();
    }
}

