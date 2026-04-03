import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int number  = Integer.parseInt(st.nextToken());

        System.out.println(solution(n,number));

    }
    public static int solution(int n, int number) {
        Set<Integer>[] set = new HashSet[9];

        for (int i = 1; i < 9; i++) {
            set[i] = new HashSet<>();
        }

        int num = 0;
        for (int i = 1; i < set.length; i++) {
            num = num * 10 + n;
            set[i].add(num);

            for (int j = 1; j < i; j++) {
                for(int a : set[j]){
                    for(int b : set[i-j]){
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        if (b != 0) set[i].add(a / b);
                    }
                }
            }
            if (set[i].contains(number))    return i;
        }
        return -1;
    }
}
