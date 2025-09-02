import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] memo = new int[3200000];
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        long  sum = 0;
        int[] arr = new int[B+1];
        for (int i = A; i <= B; i++) {
            sum += method(i);
        }
        System.out.println(sum);
    }

    public static int method(int n){
        if (memo[n] != 0) {
            return memo[n];
        }

        char[] arr;
        int min = n;
        List<Integer> list = new ArrayList();

        while (!list.contains(n)){
            list.add(n);
            arr = String.valueOf(n).toCharArray();
            int sum = 0;
            for (char a : arr) {
                sum += (int)Math.pow(Character.getNumericValue(a),K);
            }
            n = sum;
            min = Math.min(min, n);
        }

        for (int node : list) {
            memo[node] = min;
        }

        return min;
    }
}
