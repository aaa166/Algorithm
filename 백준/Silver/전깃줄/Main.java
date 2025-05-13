import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] read = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(read[0]);
            arr[i][1] = Integer.parseInt(read[1]);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        System.out.println(baekjoon2565(arr));
    }
    public static int baekjoon2565(int[][] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println("DP 배열: " + Arrays.toString(dp));
        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }

        return n - max;
    }
}
