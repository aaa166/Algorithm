import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] budget = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(input[i]);
            sum += budget[i];
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(budget);
        if (sum <= m){
            System.out.println(budget[n-1]);
        }else {
            int money = m;
            int cityNum = n;

            for (int i = 0; i < n; i++) {
                long limit = money / cityNum;

                if (budget[i] <= limit) {
                    money -= budget[i];
                    cityNum--;
                } else {
                    System.out.println(limit);
                    return;
                }
            }
        }
    }
}


