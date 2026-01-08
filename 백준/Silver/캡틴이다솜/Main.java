import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[122];
        int floor = 0;
        int idx = 0 ;

        for (int i = 1; i < arr.length; i++) {
            floor = floor + i;
            arr[i] = arr[i-1] + floor;
            if (arr[i] > n){
                idx = i-1;
                break;
            }
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = 1_000_000;
        dp[0] = 0;

        for (int i = 1; i <= idx; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}

