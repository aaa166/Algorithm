import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] time = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][m];
        dp[0] = time[0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int preMin = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (j == k) continue;
                    preMin = Math.min(preMin,dp[i-1][k]);
                }

                dp[i][j] = preMin + time[i][j];

                if (i == n-1){
                    min = Math.min(dp[i][j],min);
                }
            }
        }
        System.out.println(min);


    }
}
