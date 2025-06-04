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
        int k = Integer.parseInt(input[2]);

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(board [i]));
//        }

        int[][] arrW = new int[n + 1][m + 1];
        int[][] arrB = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char W = ((i + j) % 2 == 0) ? 'W' : 'B';
                char B = ((i + j) % 2 == 0) ? 'B' : 'W';

                arrW[i + 1][j + 1] = arrW[i][j + 1] + arrW[i + 1][j] - arrW[i][j]
                        + (board[i][j] != W ? 1 : 0);
                arrB[i + 1][j + 1] = arrB[i][j + 1] + arrB[i + 1][j] - arrB[i][j]
                        + (board[i][j] != B ? 1 : 0);
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arrW[i]));
//        }
//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arrB[i]));
//        }

        int minChange = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int totalW = arrW[i][j] - arrW[i - k][j] - arrW[i][j - k] + arrW[i - k][j - k];
                int totalB = arrB[i][j] - arrB[i - k][j] - arrB[i][j - k] + arrB[i - k][j - k];
                minChange = Math.min(minChange, Math.min(totalW, totalB));
            }
        }

        System.out.println(minChange);
    }

}
