import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Integer[] arr;
    static Integer[] p;
    static boolean[] visited;
    static int line = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Integer[n];
        p = new Integer[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        countLine(0);

        System.out.println(line);
    }

    public static void countLine(int cur) {
        if (cur == n) {
            int currentLines = checkPermutation(p);
            line = Math.max(line, currentLines);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                p[cur] = arr[i];

                countLine(cur + 1);

                visited[i] = false;
            }
        }
    }
    private static int checkPermutation(Integer[] permutation) {
        int count = 0;
        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            for (int i = 0; i < n; i++) {
                int index = (start + i) % n;
                currentSum += permutation[index];

                if (currentSum == 50) {
                    count++;
                    break;
                }
                if (currentSum > 50) {
                    break;
                }
            }
        }
        return count / 2;
    }
}