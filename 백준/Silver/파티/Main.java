import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n, m, x;
    static ArrayList<int[]>[] graph, reverseGraph;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2])-1;

        graph = new ArrayList[n];
        reverseGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0])-1;
            int end = Integer.parseInt(input[1])-1;
            int len = Integer.parseInt(input[2]);

            graph[start].add(new int[]{end, len});
            reverseGraph[end].add(new int[]{start, len});
        }
        int[] distFromX = dijkstra(x, graph);
        int[] distToX = dijkstra(x, reverseGraph);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, distFromX[i] + distToX[i]);
        }

        System.out.println(max);
    }

    static int[] dijkstra(int start, ArrayList<int[]>[] g) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] next : g[now]) {
                int nextNode = next[0];
                int nextCost = cost + next[1];

                if (dist[nextNode] > nextCost) {
                    dist[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
        return dist;
    }
}

