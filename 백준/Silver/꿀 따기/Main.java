import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] honey = new int[n];
        long[] prefixSum = new long[n];
        long sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max,honey[i]);
            sum = sum + honey[i];
            prefixSum[i] = sum;
        }
        long result = 0;
//        System.out.println(Arrays.toString(honey));
        //양쪽에서 채집
        result = sum - honey[0] - honey[n-1] + max;
        //왼쪽에서 오른쪽으로 채집
        for (int i = 1; i < n - 1; i++) {
            long score = (sum - honey[0] - honey[i]) + (sum - prefixSum[i]);
            result = Math.max(result, score);
        }
        //오른쪽에서 왼쪽으로 채집
        for (int i = 1; i < n - 1; i++) {
            long score = (prefixSum[n - 2] - honey[i]) + (prefixSum[i - 1]);
            result = Math.max(result, score);
        }
        System.out.println(result);

    }
}
