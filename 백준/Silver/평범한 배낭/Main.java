import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);

        int[][] read = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            read[i][0] = Integer.parseInt(input[0]);
            read[i][1] = Integer.parseInt(input[1]);
        }
//        for (int[] i : read){
//            System.out.println(Arrays.toString(i));
//        }
        System.out.println(baekjoon12865(read, w));
    }
    public static int baekjoon12865(int[][] arr,int w){
        int n = arr.length-1;

//        int[][] dp = new int[n+1][w+1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= w; j++) {
//                if (arr[i][0] > j){
//                    dp[i][j] = dp[i - 1][j];
//                }else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
//                }
//            }
//        }
//        return dp[n][w];


        int[] dp = new int[w + 1];

        for (int i = 1; i <= n; i++) {
            int weight = arr[i][0];
            int value = arr[i][1];

            for (int j = w; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        return dp[w];
    }
}
