import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0])-1;
            int e = Integer.parseInt(input[1])-1;

            change(s,e);
        }
        for (Integer i : list) {
            sb.append(i).append(" ");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    public static void change(int s, int e){
        while (s < e) {
            Collections.swap(list, s, e);

            s++;
            e--;
        }
    }
}
