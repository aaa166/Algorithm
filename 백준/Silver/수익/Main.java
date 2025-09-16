import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
//            System.out.println(Arrays.toString(arr));

//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < n; i++) {
//                int sum = 0;
//                for (int j = i; j < n; j++) {
//                    sum = sum + arr[j];
//                    if (sum > max)   max = sum;
//                }
//            }



            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];

                if (sum > max)  max = sum;

                if (sum < 0)    sum = 0;
            }

            System.out.println(max);
        }


    }
}

