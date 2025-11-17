import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static boolean possible;
    static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[6][3];
        a:
        for (int z = 0; z < 4; z++) {
            String[] input = br.readLine().split(" ");
            int w = 0, d = 0, l = 0;
//            int maxD = 0;
            int match = 0;
            int totalSum = 0;

            for (int i = 0; i < input.length; i++) {
                int x = i / 3;
                int y = i % 3;
                int num = Integer.parseInt(input[i]);

                arr[x][y] = num;
                totalSum += num;

                match = match+num;
                if (y == 0)         w = w + num;
                else if (y == 1){
                    d = d + num;
//                    maxD = Math.max(maxD,num);
                }
                else{
                    if (match != 5){
                        sb.append("0 ");
                        continue a;
                    }
                    match = 0;
                    l = l + num;
                }
            }
            if (totalSum != 30) {
                sb.append("0 ");
                continue a;
            }

            possible = false;
            dfs(0);

            if (possible){
                 sb.append("1 ");
            }else{
                 sb.append("0 ");
            }

//            for (int i = 0; i < 6; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println();
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static void dfs(int matchIndex) {
        if (possible) {
            return;
        }

        if (matchIndex == 15) {
            possible = true;
            return;
        }

        int t1 = team1[matchIndex];
        int t2 = team2[matchIndex];

        if (arr[t1][0] > 0 && arr[t2][2] > 0) {
            arr[t1][0]--;
            arr[t2][2]--;
            dfs(matchIndex + 1);
            arr[t1][0]++;
            arr[t2][2]++;
        }

        if (arr[t1][1] > 0 && arr[t2][1] > 0) {
            arr[t1][1]--;
            arr[t2][1]--;
            dfs(matchIndex + 1);
            arr[t1][1]++;
            arr[t2][1]++;
        }

        if (arr[t1][2] > 0 && arr[t2][0] > 0) {
            arr[t1][2]--;
            arr[t2][0]--;
            dfs(matchIndex + 1);
            arr[t1][2]++;
            arr[t2][0]++;
        }
    }
}
