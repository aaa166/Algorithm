import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);

        int count = n;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1].startsWith(arr[i])) {
                count--;
            }
        }

        System.out.println(count);
    }

}
