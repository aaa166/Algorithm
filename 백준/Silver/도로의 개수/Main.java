import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    record Connection(int x1, int y1, int x2, int y2) {}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        long[][] arr = new long[n+1][m+1];
        Set<Connection> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            set.add(new Connection(x1,y1,x2,y2));
        }

        for (int i = 0; i <= n; i++) {
            long v,h;
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0){
                    arr[i][j] = 1;
                    continue;
                }
                if (i==0)   v = 0;
                else if (set.remove(new Connection(i-1, j, i, j)) || set.remove(new Connection(i, j, i-1, j))) {
                    v = 0;
                }
                else    v = arr[i-1][j];

                if (j==0)   h = 0;
                else if (set.remove(new Connection(i, j-1, i, j)) || set.remove(new Connection(i, j, i, j-1))) {
                    h = 0;
                }
                else    h = arr[i][j-1];

                arr[i][j] = v+h;

            }
        }
//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        System.out.println(arr[n][m]);
    }
}
