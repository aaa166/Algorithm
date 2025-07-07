import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int count = 0;

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (isHighest(i, j)) {
                        count++;
                    }
                }
            }
        }



        System.out.println(count);
        reader.close();
    }

    public static boolean isHighest(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> sameHeight = new ArrayList<>();
        boolean isPeak = true;
        int height = arr[x][y];

        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        sameHeight.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int dir = 0; dir < 8; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (arr[nx][ny] > height) {
                    isPeak = false; // 더 높은 곳이 있다 → 산봉우리 아님
                }

                if (!visited[nx][ny] && arr[nx][ny] == height) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    sameHeight.add(new int[]{nx, ny});
                }
            }
        }

        return isPeak;
    }
}

