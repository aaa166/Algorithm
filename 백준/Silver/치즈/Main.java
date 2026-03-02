import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int time, count;
    static boolean isFin;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        time = 0;
        int last = 0;

        while (true) {
            int melted = cheese();

            if (melted == 0) break;

            last = melted;
            time++;
        }

        System.out.println(time);
        System.out.println(last);
    }

    public static int cheese() {
        int n = arr.length;
        int m = arr[0].length;

        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        List<int[]> melt = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if (arr[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                } else {
                    melt.add(new int[]{nx, ny});
                }
            }
        }

        for (int[] pos : melt) {
            arr[pos[0]][pos[1]] = 0;
        }

        return melt.size();
    }
}
