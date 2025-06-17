import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        baekjoon2630(0,0,n);
        System.out.println(white);
        System.out.println(blue);


    }
    public static void baekjoon2630(int x, int y ,int size){
        if (isSameColor(x, y, size)) {
            if (arr[x][y] == 0)
                white++;
            else
                blue++;
            return;
        }

        int n = size/2;
        baekjoon2630(x,y,n);
        baekjoon2630(x+n,y,n);
        baekjoon2630(x,y+n,n);
        baekjoon2630(x+n,y+n,n);

    }
    public static boolean isSameColor(int x,int y ,int size){
        int color = arr[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (arr[i][j] != color) return false;
            }
        }
        return true;
    }
}
