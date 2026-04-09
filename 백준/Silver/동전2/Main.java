import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        int[] dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            if (coin[i] > k)    break;
            dp[coin[i]] = 1;
        }
        for (int i = 0; i < coin[0]; i++) {
            dp[i] = -1;
        }
        for (int i = coin[0]+1; i <= k; i++) {
            if (dp[i] == 1) continue;

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i > coin[j]){
                    if (dp[i-coin[j]] != -1)    min = Math.min(min,dp[i-coin[j]]+1);
                }

            }
            if (min == Integer.MAX_VALUE)   dp[i] = -1;
            else                            dp[i] = min;
        }

        System.out.println(dp[k]);
    }
}
