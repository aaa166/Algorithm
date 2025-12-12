import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            max = Math.max(max,num);
        }
        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < n; i++) {
            sb.append(dp[arr[i]]).append("\n");
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb);

    }
}

