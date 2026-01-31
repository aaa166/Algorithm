import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][]arr;
    static boolean[][] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]){
                    check(i,j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    public static void check(int x, int y){
        visited[x][y] = true;
        if (arr[x][y] == '-'){
            int num = 1;
            while (y < m - num){
                if (arr[x][y+num] == '-'){
                    visited[x][y+num] = true;
                    num++;
                }else{
                    break;
                }
            }
        }else {
            int num = 1;
            while (x < n - num){
                if (arr[x+num][y] == '|'){
                    visited[x+num][y] = true;
                    num++;
                }else{
                    break;
                }
            }
        }
    }
}

