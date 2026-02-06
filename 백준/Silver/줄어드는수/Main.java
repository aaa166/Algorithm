import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list.add(0L);
        for (int i = 1; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        if (n > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(n - 1));
        }
    }

    static void dfs(long num, int lastDigit) {
        list.add(num);
        for (int next = 0; next < lastDigit; next++) {
            dfs(num * 10 + next, next);
        }
    }
}
