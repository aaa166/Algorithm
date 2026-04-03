import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(input[i]);
                int sum = 0;
            for (int j = 1; j <= n/2; j++) {
                if (n%j==0) sum = sum + j;
            }
            if(sum < n)         System.out.println("Deficient");
            else if (sum == n)  System.out.println("Perfect");
            else                System.out.println("Abundant");

        }
    }

}
