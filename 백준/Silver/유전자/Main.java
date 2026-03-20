import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        int[][] dp = new int[n][n];


        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;

                if ((str.charAt(i) == 'a' && str.charAt(j) == 't') ||
                        (str.charAt(i) == 'g' && str.charAt(j) == 'c')) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}