import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n =Integer.parseInt(input[0]);
        int m =Integer.parseInt(input[1]);
        int count  = 0;
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = n-1; i >= 0 ; i--) {
            for (int j = m-1; j >= 0 ; j--) {
                if (arr[i][j] == 1){
                    count++;
                    flip(i,j);
                }
            }
        }
        System.out.println(count);

    }

    public static void flip(int x,int y){
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (arr[i][j] == 0) arr[i][j] = 1;
                else                arr[i][j] = 0;
            }
        }

    }
}
