import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        long[] arr = new long[m];
        long sum = 0;
        long result = 0;

        input = br.readLine().split(" ");
        arr[0] = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            sum = (sum + num) % m;

            if (sum < 0) sum += m;

            result += arr[(int) sum];
            arr[(int) sum]++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(result);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] input = br.readLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//
//        int[] arr = new int[n];
//        int result = 0;
//
//        input = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(input[i]);
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            int count = 0;
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum = sum + arr[j];
//                if (sum % m == 0)   count++;
//
//                if (j==n-1){
//                    arr[i] = count;
//                    result = result + count;
//                }
//            }
//        }
//        System.out.println(result);
//    }


}
