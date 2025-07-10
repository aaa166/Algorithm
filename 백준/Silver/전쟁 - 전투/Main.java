import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] arr;
    static int [] sum;
    static boolean[][] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        arr = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        sum =new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]){
                    int num = power(i,j,1);
                    if (arr[i][j] == 'W')   sum[0] = sum[0] + (num * num);
                    else                    sum[1] = sum[1] + (num * num);
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        System.out.printf("%d %d",sum[0],sum[1]);

        br.close();
    }

    public static int power(int x ,int y, int count){
        if (!visited[x][y]){
            visited[x][y] = true;
            char c = arr[x][y];
            if (x != 0){
                if (c == arr[x-1][y] && !visited[x-1][y]){
                    count++;
                    count = power(x-1,y,count);
                }
            }
            if (x != n-1){
                if (c == arr[x+1][y] && !visited[x+1][y]){
                    count++;
                    count = power(x+1,y,count);
                }
            }
            if (y != 0){
                if (c == arr[x][y-1] && !visited[x][y-1]){
                    count++;
                    count = power(x,y-1,count);
                }
            }
            if (y != m-1){
                if (c == arr[x][y+1] && !visited[x][y+1]){
                    count++;
                    count = power(x,y+1,count);
                }
            }
            return count;

        }
        return count;
    }
}

