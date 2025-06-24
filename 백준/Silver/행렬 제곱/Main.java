import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int mod = 1000;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long b = Long.parseLong(input[1]);
        long[][] arr = new long[n][n];
        long[][] arrR = new long[n][n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Long.parseLong(input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            arrR[i][i] = 1;
        }

        long num;
        while (b>=2){
            if ((b & 1)==1){
                arrR = multiply(arrR, arr, n);
            }
            arr = multiply(arr, arr, n);
            b >>= 1;
        }
        arrR = multiply(arrR, arr, n);




//        // 행렬곱셈
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int num = 0;
//                for (int l = 0; l < n; l++) {
//                    num += arr[i][l] * arr[l][j];
//                }
//                arrR[i][j] = num;
//            }
//        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arrR[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static long[][] multiply(long[][] A, long[][] B, int n) {
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % mod;
                }
            }
        }
        return result;
    }
}
