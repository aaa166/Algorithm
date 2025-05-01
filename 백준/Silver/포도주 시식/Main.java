import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(baek2156(arr));
    }
    public static int baek2156(int[] arr){
        int len = arr.length;
        int[] dp = new int[len+1];

        if (len > 1)   dp[1] = arr[1];
        if (len > 2)   dp[2] = dp[1] + arr[2];
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+arr[i]),dp[i-3]+arr[i-1]+arr[i]) ;
        }
        return dp[len-1];
    }
}
