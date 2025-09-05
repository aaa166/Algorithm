import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int a = 0;
        int b = n - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (a < b) {
            int sum = arr[a] + arr[b];
            int absSum = Math.abs(sum);

            if (absSum < min) {
                min = absSum;
                result[0] = arr[a];
                result[1] = arr[b];
            }

            if (sum < 0) {
                a++;
            }
            else {
                b--;
            }
        }

        System.out.printf("%d %d", result[0], result[1]);
    }
}