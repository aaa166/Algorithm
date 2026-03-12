import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int arr[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            if (n == 0 && m == 0) break;

            arr = new int[n][m];
            dp = new int[n][m];

            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (arr[i][j] == 1) {

                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(
                                    Math.min(dp[i-1][j], dp[i][j-1]),
                                    dp[i-1][j-1]
                            ) + 1;
                        }

                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(dp[i]));
//            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);

    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    static int arr[][];
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        String[] input = br.readLine().split(" ");
//        int n =Integer.parseInt(input[0]);
//        int m =Integer.parseInt(input[1]);
//
//        while (!(n==0 && m==0)){
//            arr = new int[n][m];
//            int max = 0;
//
//            for (int i = 0; i < n; i++) {
//                input = br.readLine().split(" ");
//                for (int j = 0; j < m; j++) {
//                    arr[i][j] = Integer.parseInt(input[j]);
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                if (i > n-max)  break;
//                for (int j = 0; j < m; j++) {
//                    if (j > m-max)  break;
//
//                    if (arr[i][j]==1)   max = Math.max(max,laggestSquareSize(i,j));
//                }
//            }
//            sb.append(max).append("\n");
//
//            input = br.readLine().split(" ");
//            n =Integer.parseInt(input[0]);
//            m =Integer.parseInt(input[1]);
//        }
//        sb.setLength(sb.length()-1);
//        System.out.println(sb);
//    }
//    public static int laggestSquareSize(int x, int y){
//        int size = arr.length;
//        for (int i = x; i < arr.length; i++) {
//            if (i > x + size-1) break;
//            for (int j = y; j < arr[0].length; j++) {
//                if (arr[i][j] != 1){
//                    size = Math.min(size,j-y);
//                }
//                if (j == arr[0].length-1 && arr[i][j] == 1){
//                    size = Math.min(size,j-y+1);
//                }
//            }
//        }
//        return size;
//    }
//}

