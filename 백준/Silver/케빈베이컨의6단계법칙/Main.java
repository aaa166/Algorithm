import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        len = new int[n][n];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            len[start-1][end-1] = 1;
            len[end-1][start-1] = 1;
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int sum = bfs(i, n);
            if (sum < min) {
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer + 1);

    }

    private static int bfs(int start, int n) {
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < n; i++) {
                if (len[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[now] + 1;
                    queue.add(i);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dist[i];
        }

        return sum;
    }

}

