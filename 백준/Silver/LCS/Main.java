import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] read1 = br.readLine().toCharArray();
        char[] read2 = br.readLine().toCharArray();

        System.out.println(baekjoon9251(read1,read2));;
    }
    public static int baekjoon9251(char[] read1, char[] read2){
        int n1 = read1.length;
        int n2 = read2.length;

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (read1[i - 1] == read2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
