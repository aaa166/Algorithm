import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[2 * n];
        long  sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            arr[i + n] = num;
            sum += num;
        }

        long limit = sum / 2;
        int left = 0;
        int right = 0;
        long currentSum = 0;
        long answer = 0;

        while (left < n) {

            while (right < left + n && currentSum + arr[right] <= limit) {
                currentSum += arr[right];
                right++;
            }

            answer = Math.max(answer, currentSum);

            currentSum -= arr[left];
            left++;
        }

        System.out.println(answer);
    }
}
