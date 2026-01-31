import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        long[] size = new long[n];
        for (int i = 0; i < n; i++) {
            size[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(size);

        long count = 0;
        int right = 0;

        for (int left = 0; left < n; left++) {
            if (right < left) right = left;

            while (right < n && size[right] * 9 <= size[left] * 10) {
                right++;
            }

            count += (right - left - 1);
        }

        System.out.println(count);
    }
}
