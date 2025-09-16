import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList();
        for (int i = 0; i < m; i++) {
            que.offer(Integer.parseInt(br.readLine())-1);
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        if (n >= 1) {
            dp[1] = 1;
        }
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }


        int count = 0;
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (que.isEmpty()){
                result = result * dp[n-i];
//                System.out.println(dp[n-i]);
                break;
            }

            if (que.peek() == i){
                que.poll();
                result = result * dp[count];
//                System.out.println(dp[count]);
                count = 0;
            }else count++;


        }
        System.out.println(result);
    }

}