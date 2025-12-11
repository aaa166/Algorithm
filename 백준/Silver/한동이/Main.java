import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            isVisited = new boolean[n+1];

            int c = visit(i,0);
            if (max < c){
                max = c;
                result = i;
                if (c == n) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
    public static int visit(int n,int c){
        int next = arr[n];

        if (isVisited[n]){
            return c;
        }
        else {
            isVisited[n] = true;
            c++;
            return visit(next,c);
        }
    }
}
