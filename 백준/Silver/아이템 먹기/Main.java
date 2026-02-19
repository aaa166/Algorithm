import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] map;
    static int[][] item,wall;
    int curX=0,xurY=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int a = Integer.parseInt(input[2]);
        int b = Integer.parseInt(input[3]);

        map = new char[n][m];
        item = new int[a+2][2];
        wall = new int[b][2];
        int x,y;
        //아이템
        for (int i = 1; i <= a; i++) {
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0])-1;
            y = Integer.parseInt(input[1])-1;
            map[x][y] = 'i';

            item[i][0] = x;
            item[i][1] = y;
        }
        item[0][0] = 0;
        item[0][1] = 0;
        item[a+1][0] = n-1;
        item[a+1][1] = m-1;

        //장애물
        for (int i = 0; i < b; i++) {
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0])-1;
            y = Integer.parseInt(input[1])-1;
            map[x][y] = 'x';

            wall[i][0] = x;
            wall[i][1] = y;
        }
        Arrays.sort(item, (f, s) -> {
            if (f[0] == s[0]) {
                return f[1] - s[1];
            }
            return f[0] - s[0];
        });
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        for (int i = 0; i <= a+1; i++) {
//            System.out.println(Arrays.toString(item[i]));
//        }
        long  result = 1;
        for (int i = 0; i <= a; i++) {
            result *= findRootCount(
                    item[i][0], item[i][1],
                    item[i+1][0], item[i+1][1]
            );
        }

        System.out.println(result);
    }
    public static long  findRootCount(int startX, int startY, int endX, int endY) {

        if (startX > endX || startY > endY) return 0;

        long [][] dp = new long [map.length][map[0].length];

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {

                if (map[i][j] == 'x') {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == startX && j == startY) {
                    dp[i][j] = 1;
                } else {
                    long  fromUp = 0;
                    long  fromLeft = 0;

                    if (i > startX)
                        fromUp = dp[i - 1][j];

                    if (j > startY)
                        fromLeft = dp[i][j - 1];

                    dp[i][j] = fromUp + fromLeft;
                }
            }
        }

        return dp[endX][endY];
    }
}
