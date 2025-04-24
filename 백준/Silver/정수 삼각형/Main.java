import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        String[] read;
        for (int i = 0; i < n; i++) {
            read = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(read[j]);
            }
        }


//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        System.out.println();
        System.out.println(baekjoon1932(arr));;
    }
    public static int baekjoon1932(int[][] arr){
        int n = arr.length;


        int[][] dp = new int[n][n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j==0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }else if (i==j){
                    dp[i][j] = dp[i-1][j-1]+arr[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
                }
            }

        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
            max = Math.max(max,dp[n-1][i]);
        }

        return max;
    }
}
