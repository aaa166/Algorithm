import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.charAt(i) - '0';
        }

        System.out.println(method(arr));
    }

    public static int method(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        if (arr[0] == 0) return 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = arr[i - 1];
            int twoDigit = arr[i - 2] * 10 + arr[i - 1];

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 34) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
