import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] p, s;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        s = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(input[i]);
        }

        int[] original = Arrays.copyOf(p, n);
        int count = 0;

        while (true) {
            if (isCorrect()) {
                System.out.println(count);
                return;
            }

            p = shuffle();
            count++;

            if (Arrays.equals(p, original)) {
                System.out.println(-1);
                return;
            }
        }
    }

    public static int[] shuffle() {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[s[i]] = p[i];
        }
        return result;
    }
    public static boolean isCorrect() {
        for (int i = 0; i < n; i++) {
            if (p[i] != i % 3) return false;
        }
        return true;
    }
}