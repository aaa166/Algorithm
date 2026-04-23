import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] iceberg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int year = 0;
        List<int[]> list = new ArrayList<>();

        iceberg = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                if (h != 0)     list.add(new int[]{i,j,0});
                iceberg[i][j] = h;
            }
        }


        while (true){
            int count = countIsland(list);
            if (count >= 2) {
                System.out.println(year);
                break;
            }
            if (count == 0) {
                System.out.println(0);
                break;
            }

            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                int z = iceberg[x][y];
                int c = 0;

                if (x == 0 || iceberg[x-1][y] ==0)  c++;
                if (x == n-1 || iceberg[x+1][y] ==0)  c++;
                if (y == 0 || iceberg[x][y-1] ==0)  c++;
                if (y == m-1 || iceberg[x][y+1] ==0)  c++;
                if (z > c){
                    list.set(i, new int[]{x,y,z-c});
                }else   list.set(i, new int[]{x,y,0});
            }

            int idx = 0;
            while (idx < list.size()){
                int x = list.get(idx)[0];
                int y = list.get(idx)[1];
                int h = list.get(idx)[2];
                iceberg[x][y] = h;
                if (h == 0){
                    list.remove(idx);
                    continue;
                }
                idx++;
            }
            year++;
        }


    }

    public static int countIsland(List<int[]> list) {
        if (list.isEmpty()) return 0;

        boolean[][] visited = new boolean[n][m];
        int islands = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int[] p : list) {
            if (!visited[p[0]][p[1]]) {
                islands++;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{p[0], p[1]});
                visited[p[0]][p[1]] = true;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = cur[0] + dx[i];
                        int ny = cur[1] + dy[i];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                            if (!visited[nx][ny] && iceberg[nx][ny] > 0) {
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
