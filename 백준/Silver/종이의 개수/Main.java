import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int c0 = 0;
    static int c1 = 0;
    static int c2 = 0;

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

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        baekjooon1780(n,0,0);

        System.out.println(c2);
        System.out.println(c0);
        System.out.println(c1);


    }
    public static void baekjooon1780(int size, int x, int y){
        if (isAll(size,x,y) ){
            switch (arr[x][y]){
                case -1:
//                    System.out.printf("%d %d : -1\n",x,y);
                    c2++;
                    break;
                case 0:
//                    System.out.printf("%d %d : 0\n",x,y);
                    c0++;
                    break;
                case 1:
//                    System.out.printf("%d %d : 1\n",x,y);
                    c1++;
                    break;
            }
        }else{
            int n = size/3;

            for (int i = 0; i <size; i = i+n) {
                for (int j = 0; j <size ; j = j+n) {
                    baekjooon1780(n, x + i, y + j);
                }
            }
        }

    }
    public static boolean isAll(int size,int x,int y){
        int n = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != n) return false;
            }
        }
        return true;
    }
}
