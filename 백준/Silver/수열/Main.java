import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        String[] input = br.readLine().split(" ");
        int len = Integer.parseInt(input[0]);
        int day = Integer.parseInt(input[1]);

        int[] tem = new int[len];
        input = br.readLine().split(" ");
        for (int i = 0; i < len; i++) {
            tem[i] = Integer.parseInt(input[i]) ;
        }

        int[] arr =new int[len-day+1];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j <i+day; j++) {
                sum = sum + tem[j];
            }
            max = Math.max(max,sum);
        }
        System.out.println(max);
    }
}
