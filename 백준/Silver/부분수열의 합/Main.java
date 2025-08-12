import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int result =0;

        for (int i = 1; i < (1 << n); i++) {
            boolean[] isSum = new boolean[n];
            markBits(i,isSum);

            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (isSum[j])   sum = sum+arr[j];
            }
//            System.out.println(sum);
            if (s == sum){
                result++;
            }

        }
        System.out.println(result);

    }
    public static void markBits(int num, boolean[]isSum){
        int count = 0;
        while (num>0){
            if (num % 2 ==1) {
                isSum[count] = true;
            }
            count++;
            num = num>>1;
        }
//        System.out.println(Arrays.toString(isSum));
    }
}
