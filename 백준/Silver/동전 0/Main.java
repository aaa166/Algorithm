import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            arr[i] = coin;
        }
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            int div = (int)(k / arr[i]);

            if (div > 0){
                k = k - (arr[i] * div);
                count = count + div;
            }
        }
        System.out.println(count);
    }

}
