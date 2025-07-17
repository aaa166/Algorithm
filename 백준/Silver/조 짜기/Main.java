import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }

        int[] dp =new int[n+1];
        for (int i = 1; i <= n; i++) {
            int max = arr[i];
            int min = arr[i];

            for(int j=i; j>=1; j--) {
                if(arr[j] > max) max = arr[j];
                if(arr[j] < min) min = arr[j];

                dp[i] = Math.max(dp[i], dp[j-1] + (max - min));
            }
        }

//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[n]);

    }
}
