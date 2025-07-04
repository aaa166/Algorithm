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
        int[] path = new int[n+1];
        Arrays.fill(path,Integer.MAX_VALUE);

        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
            arr[i][2] = Integer.parseInt(input[2]);
        }

        input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        path[s] = 0;
        minPath(s,e,arr,path,0);
//        System.out.println(Arrays.toString(path));
        System.out.println(path[e]);

        br.close();
    }

    public static void minPath(int s, int e, int[][] arr, int[] path, int sum){
        int m = arr.length;
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == s) {
                int next = arr[i][1];
                int cost = sum + arr[i][2];

                if (cost < path[next]) {
                    path[next] = cost;
                    minPath(next, e, arr, path, cost);
                }
            }
        }
    }
}

