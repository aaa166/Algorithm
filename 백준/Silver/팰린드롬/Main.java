import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();

        boolean[][] pal = new boolean[len][len];

        for (int i = 0; i < len; i++) pal[i][i] = true;

        for (int l = 2; l <= len; l++) {
            for (int i = 0; i + l - 1 < len; i++) {
                int j = i + l - 1;
                if (input.charAt(i) == input.charAt(j)) {
                    if (l == 2 || pal[i+1][j-1]) {
                        pal[i][j] = true;
                    }
                }
            }
        }

        int[] dp = new int[len+1];
        dp[1] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 0; j < i; j++) {
                if (pal[j][i-1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[len]);
    }

}

