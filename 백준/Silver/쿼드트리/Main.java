import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        baekjoon1992(sb,n,0,0);
        System.out.println(sb);
    }
    public static void baekjoon1992(StringBuilder sb,int size,int x,int y){
        if (isAll(sb, size, x, y)) {
            sb.append(arr[x][y]);
            return;
        }
        int n = size/2;


        sb.append("(");

        baekjoon1992(sb, n , x, y);
        baekjoon1992(sb, n , x, y + n);
        baekjoon1992(sb, n , x + n, y);
        baekjoon1992(sb, n , x + n, y + n);
//        if (isAll(sb,n,x,y) == 0)sb.append(0);
//        else if (isAll(sb,n,x,y) == 1)sb.append(1);
//        else baekjoon1992(sb,n,x,y);
//
//        if (isAll(sb,n,x,y+n) == 0)sb.append(0);
//        else if (isAll(sb,n,x,y+n) == 1)sb.append(1);
//        else baekjoon1992(sb,n,x,y+n);
//
//        if (isAll(sb,n,x+n,y) == 0)sb.append(0);
//        else if (isAll(sb,n,x+n,y) == 1)sb.append(1);
//        else baekjoon1992(sb,n,x+n,y);
//
//        if (isAll(sb,n,x+n,y+n) == 0)sb.append(0);
//        else if (isAll(sb,n,x+n,y+n) == 1)sb.append(1);
//        else baekjoon1992(sb,n,x+n,y+n);

        sb.append(")");
    }
    public static boolean isAll(StringBuilder sb,int size,int x,int y){
        int a = arr[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (arr[i][j] != a) return false;
            }
        }
        return true;
//        int a = arr[x][y];
//        for (int i = x; i < x+size; i++) {
//            for (int j = y; j < y+size; j++) {
//                if (arr[i][j] != a) return 2;
//            }
//        }
//        return a;
    }
}

