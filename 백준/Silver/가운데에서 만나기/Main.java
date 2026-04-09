import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] len = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            len[i][0] = Integer.parseInt(st.nextToken());
            len[i][1] = Integer.parseInt(st.nextToken());
            len[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(len, Comparator.comparingInt(o -> o[0]));


        int k = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int[][] minLen = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(minLen[i], 1000000000);
            minLen[i][i] = 0;
        }

        for (int[] i : len) {
            minLen[i[0]][i[1]] = i[2];
        }

        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (minLen[i][j] > minLen[i][l] + minLen[l][j]) {
                        minLen[i][j] = minLen[i][l] + minLen[l][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int max = 0;
            boolean possible = true;

            for (int f : list) {
                if (minLen[f][i] == 1001 || minLen[i][f] == 1001) {
                    possible = false;
                    break;
                }
                max = Math.max(max, minLen[f][i] + minLen[i][f]);
            }

            if (!possible) continue;

            if (max < min) {
                min = max;
                answer.clear();
                answer.add(i);
            } else if (max == min) {
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for (int i : answer) {
            System.out.print(i + " ");
        }


    }
}
