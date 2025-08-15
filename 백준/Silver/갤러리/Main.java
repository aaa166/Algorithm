import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[M][N];

        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;
        int len1 = 0, len2 = 0;

        // 수평 방향 프레임 계산 (행 기준)
        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X' && map[i + 1][j] == '.') {
                    len1++;
                } else {
                    result += len1 / 2;
                    len1 = 0;
                }

                if (map[i][j] == '.' && map[i + 1][j] == 'X') {
                    len2++;
                } else {
                    result += len2 / 2;
                    len2 = 0;
                }
            }
            result += len1 / 2;
            result += len2 / 2;
            len1 = 0;
            len2 = 0;
        }

        // 수직 방향 프레임 계산 (열 기준)
        len1 = 0; len2 = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                if (map[j][i] == 'X' && map[j][i + 1] == '.') {
                    len1++;
                } else {
                    result += len1 / 2;
                    len1 = 0;
                }

                if (map[j][i] == '.' && map[j][i + 1] == 'X') {
                    len2++;
                } else {
                    result += len2 / 2;
                    len2 = 0;
                }
            }
            result += len1 / 2;
            result += len2 / 2;
            len1 = 0;
            len2 = 0;
        }

        System.out.println(result);
    }
}
