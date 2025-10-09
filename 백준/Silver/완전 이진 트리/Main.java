import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int k;
    static int[] arr;
    static List<Integer>[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int n = input.length;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        level = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            level[i] = new ArrayList<>();
        }

        findTree(0,n-1,0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int s : level[i]) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }

    public static void findTree(int start, int end, int depth){
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;

        level[depth].add(arr[mid]);

        findTree(start, mid - 1, depth + 1);
        findTree(mid + 1, end, depth + 1);
    }
}

