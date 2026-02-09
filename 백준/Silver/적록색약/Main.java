import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] drawing;
    static boolean[][] visitedNormal, visitedBlind;
    static int normal, blind = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        drawing = new char[n][n];
        visitedNormal = new boolean[n][n];
        visitedBlind = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                drawing[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedNormal[i][j]) {
                    normal++;
                    sectionCheck(i, j, true);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedBlind[i][j]) {
                    blind++;
                    sectionCheck(i, j, false);
                }
            }
        }

        System.out.println(normal + " " + blind);
    }

    public static void sectionCheck(int x, int y, boolean isNormal) {
        char c = drawing[x][y];

        if (isNormal) {
            visitedNormal[x][y] = true;
        }
        else {
            visitedBlind[x][y] = true;
        }

        int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < drawing.length && ny >= 0 && ny < drawing.length) {
                if (isNormal) {
                    if (drawing[nx][ny] == c && !visitedNormal[nx][ny]) {
                        sectionCheck(nx, ny, isNormal);
                    }
                } else {
                    if ((drawing[nx][ny] == c ||
                            (c == 'R' && drawing[nx][ny] == 'G') ||
                            (c == 'G' && drawing[nx][ny] == 'R')) && !visitedBlind[nx][ny]) {
                        sectionCheck(nx, ny, isNormal);
                    }
                }
            }
        }
    }
}
