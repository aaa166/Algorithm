import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int n,m,o;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n =Integer.parseInt(input[0]);
        m =Integer.parseInt(input[1]);
        o = n + m;

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] result = new int[2*o];
        for (int i = 0; i < o; i++) {
            if (i < n){
                int num = shot(false, i,0);
                result[i] = num;
                result[num-1] = i+1;
            }else {
                int num = shot(true, n-1, i-n);
                result[i] = num;
                result[num-1] = i+1;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d ",result[i]);
        }

    }
    public static int shot(boolean l, int x,int y){
        if (l){
            //거울x
            if (arr[x][y] == 0){
                if (x==0){
                    return 2 * o - y;
                }else{
                    return shot(true,x-1,y);
                }
            }
            //거울o
            else{
                if (y == m-1){
                    return 2 * o - m - x;
                }else {
                    return shot(false,x,y+1);
                }
            }
        }else{
            //거울x
            if (arr[x][y] == 0){
                if (y == m-1){
                    return 2 * o - m - x;
                }else{
                    return shot(false,x,y+1);
                }
            }
            //거울o
            else{
                if (x==0){
                    return 2 * o - y;
                }else {
                    return shot(true,x-1,y);
                }
            }
        }
    }
}

