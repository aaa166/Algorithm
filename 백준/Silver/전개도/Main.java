import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] net = new int[6][6];
    static boolean[][] visited = new boolean[6][6];
    static int[] dice = new int[6];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = -1, y = -1;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                net[i][j] = Integer.parseInt(st.nextToken());
                if (net[i][j] != 0 && x == -1) {
                    x = i; y = j;
                }
            }
        }

        cube(x, y, 0, 1, 2, 3, 4, 5);

        int count = 0;
        int targetIdx = -1;
        for (int i = 0; i < 6; i++) {
            if (dice[i] != 0) count++;
            if (dice[i] == 1) targetIdx = i;
        }

        if (count == 6 && targetIdx != -1) {
            int oppositeIdx = (targetIdx % 2 == 0) ? targetIdx + 1 : targetIdx - 1;
            result = dice[oppositeIdx];
        } else {
            result = 0;
        }

        System.out.println(result);
    }

    public static void cube(int x, int y, int d0, int d1, int d2, int d3, int d4, int d5) {
        visited[x][y] = true;

        if (dice[d0] != 0) return;
        dice[d0] = net[x][y];

        if (x > 0 && net[x - 1][y] != 0 && !visited[x - 1][y]) {
            cube(x - 1, y, d2, d3, d1, d0, d4, d5);
        }

        if (x < 5 && net[x + 1][y] != 0 && !visited[x + 1][y]) {
            cube(x + 1, y, d3, d2, d0, d1, d4, d5);
        }

        if (y > 0 && net[x][y - 1] != 0 && !visited[x][y - 1]) {
            cube(x, y - 1, d4, d5, d2, d3, d1, d0);
        }

        if (y < 5 && net[x][y + 1] != 0 && !visited[x][y + 1]) {
            cube(x, y + 1, d5, d4, d2, d3, d0, d1);
        }
    }
}