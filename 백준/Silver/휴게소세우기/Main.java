import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n  = Integer.parseInt(input[0]);
        int m  = Integer.parseInt(input[1]);
        int l  = Integer.parseInt(input[2]);

        int[] arr = new int[n+2];
        arr[n+1] = l;
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }
        Arrays.sort(arr);

        int left = 1;
        int right = l;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int need = 0;

            for (int i = 1; i < arr.length; i++) {
                int d = arr[i] - arr[i - 1];
                need += (d - 1) / mid;
            }

            if (need <= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
