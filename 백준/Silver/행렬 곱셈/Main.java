import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] arrA = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arrA[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[][] arrB = new int[m][k];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                arrB[i][j] = Integer.parseInt(input[j]);
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arrA[i]));
//        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(arrB[i]));
//        }
//        int[][] arrC = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int num = 0;
                for (int l = 0; l < m; l++) {
                    num += arrA[i][l] * arrB[l][j];
                }
//                arrC[i][j] =num;
                sb.append(num);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arrC[i]));
//        }
    }
}
