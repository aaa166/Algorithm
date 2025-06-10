import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int sum = 0;

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(p);
        for (int i = 0; i < n; i++) {
            sum = sum + (p[i] * (n - i));
        }
        System.out.println(sum);

    }
}
