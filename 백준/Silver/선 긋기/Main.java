import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int min = lines[0][0];
        int max = lines[0][1];
        long len = 0;

        for (int i = 1; i < n; i++) {
            if (lines[i][0] <= max) {
                max = Math.max(max, lines[i][1]);
            } else {
                len += (max - min);
                min = lines[i][0];
                max = lines[i][1];
            }
        }

        len += (max - min);

        System.out.println(len);
    }
}