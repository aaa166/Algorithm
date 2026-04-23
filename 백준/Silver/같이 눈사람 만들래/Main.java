import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int anna = arr[i] + arr[j];

                int left = 0;
                int right = n - 1;

                while (left < right) {
                    if (left == i || left == j) {
                        left++; continue;
                    }
                    if (right == i || right == j) {
                        right--; continue;
                    }

                    int elsa = arr[left] + arr[right];
                    int diff = anna - elsa;

                    minDiff = Math.min(minDiff, Math.abs(diff));

                    if (diff > 0) left++;
                    else if (diff < 0) right--;
                    else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(minDiff);
    }
}
