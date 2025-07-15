import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int n, m;
    static int maxSquare = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {


                for (int dr = -n; dr < n; dr++) {
                    for (int dc = -m; dc < m; dc++) {
                        if (dr == 0 && dc == 0) continue;

                        int x = i;
                        int y = j;
                        StringBuilder sb = new StringBuilder();

                        while (0 <= x && x < n && 0 <= y && y < m) {
                            sb.append(arr[x][y]);
                            int num = Integer.parseInt(sb.toString());


                            if (isSquare(num)) {
                                System.out.println(num);
                            }

                            x += dr;
                            y += dc;
                        }

                    }
                }

            }
        }

        System.out.println(maxSquare);

        br.close();
    }

    public static boolean isSquare(int n){
        if (n < 0) return false;
        int root = (int)Math.sqrt(n);
        return root * root == n;
    }
}

