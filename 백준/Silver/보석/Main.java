//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    static int s,n,k,r1,r2,c1,c2,w;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        s = Integer.parseInt(input[0]);
//        n = Integer.parseInt(input[1]);
//        k = Integer.parseInt(input[2]);
//        r1 = Integer.parseInt(input[3]);
//        r2 = Integer.parseInt(input[4]);
//        c1 = Integer.parseInt(input[5]);
//        c2 = Integer.parseInt(input[6]);
//        w = (int)((n-k) / 2 - 1);
//
//        int[][] arr ={{0}};
//        method(arr,0);
//    }
//
//    public static void method(int[][] smallArr, int sec){
//        sec++;
//        int sLen = smallArr.length;
//        int len = smallArr.length * n;
//        int[][] arr = new int[len][len];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int r = 0; r < sLen; r++) {
//                    for (int c = 0; c < sLen; c++) {
//                        if (i <= w || i >= n-w-1 || j <= w || j >= n-w-1 ){
//                            arr[i*sLen+r][j*sLen+c] = smallArr[r][c];
//
//                        }else{
//                            arr[i*sLen+r][j*sLen+c] = 1;
//                        }
//                    }
//                }
//
//            }
//        }
//        if (sec == s){
//            StringBuilder sb = new StringBuilder();
//            for (int i = r1; i < r2; i++) {
//                for (int j = c1; j < c2; j++) {
//                    sb.append(arr[i][j]);
//                }
//                sb.append("\n");
//            }
//            System.out.println(sb);
//        }else {
//            method(arr,sec);
//        }
//
//    }
//}
//-------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int s, n, k, r1, r2, c1, c2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        s = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        r1 = Integer.parseInt(input[3]);
        r2 = Integer.parseInt(input[4]);
        c1 = Integer.parseInt(input[5]);
        c2 = Integer.parseInt(input[6]);

        StringBuilder sb = new StringBuilder();
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sb.append(method(s, i, j));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int method(int sec, long r, long c) {
        if (sec == 0) {
            return 0;
        }

        long prevLen = 1;
        for (int i = 0; i < sec - 1; i++) {
            prevLen *= n;
        }


        long blackStart = prevLen * (n - k) / 2;


        if (r >= blackStart && r < blackStart + prevLen * k && c >= blackStart && c < blackStart + prevLen * k) {
            return 1;
        }

        return method(sec - 1, r % prevLen, c % prevLen);
    }
}