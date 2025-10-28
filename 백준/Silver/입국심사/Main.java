import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long left = 0;
        long right = (long)arr[n-1] * m;
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            for (int i : arr) {
                count += mid / i;

                if (count >= m) {
                    break;
                }
            }

            if (count >= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}

