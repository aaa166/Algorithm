import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static boolean[] cube;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 3; t++) {
            map = new int[6][6];
            visited = new boolean[6][6];
            cube = new boolean[6];

            int startX = -1, startY = -1;

            for (int i = 0; i < 6; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 6; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && startX == -1) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            if (solve(startX, startY, 0, 1, 2, 3, 4, 5)) {
                int count = 0;
                for (boolean b : cube) if (b) count++;
                System.out.println(count == 6 ? "yes" : "no");
            } else {
                System.out.println("no");
            }
        }
    }

    static boolean solve(int x, int y, int d, int u, int f, int b, int l, int r) {
        if (cube[d]) return false;

        cube[d] = true;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 6 && ny >= 0 && ny < 6 && map[nx][ny] == 1 && !visited[nx][ny]) {
                boolean result = false;
                if (i == 0)      result = solve(nx, ny, r, l, f, b, d, u);
                else if (i == 1) result = solve(nx, ny, l, r, f, b, u, d);
                else if (i == 2) result = solve(nx, ny, f, b, u, d, l, r);
                else if (i == 3) result = solve(nx, ny, b, f, d, u, l, r);

                if (!result) return false;
            }
        }
        return true;
    }
}