import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] pow = new int[10];
    static int[] memo = new int[3200000];
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

//        long  sum = 0;
//        int[] arr = new int[B+1];
//        for (int i = A; i <= B; i++) {
//            sum += method(i);
//        }
//        System.out.println(sum);
        precomputePowers();

        long sum = 0;
        for (int i = A; i <= B; i++) {
            sum += findMinInSequence(i);
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

    private static void precomputePowers() {
        for (int i = 0; i < 10; i++) {
            pow[i] = (int) Math.pow(i, K);
        }
    }

    private static int getNext(int n) {
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            sum += pow[temp % 10];
            temp /= 10;
        }
        return sum;
    }

    public static int findMinInSequence(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        List<Integer> path = new ArrayList<>();
        int current = n;

        while (memo[current] == 0 && !path.contains(current)) {
            path.add(current);
            current = getNext(current);
        }

        if (path.contains(current)) {
            // Case 1: 현재 경로에서 새로운 사이클을 발견한 경우
            int cycleStartIndex = path.indexOf(current);
            int cycleMin = Integer.MAX_VALUE;

            for (int i = cycleStartIndex; i < path.size(); i++) {
                cycleMin = Math.min(cycleMin, path.get(i));
            }
            for (int i = cycleStartIndex; i < path.size(); i++) {
                memo[path.get(i)] = cycleMin;
            }

            int tailResult = cycleMin;
            for (int i = cycleStartIndex - 1; i >= 0; i--) {
                int node = path.get(i);
                tailResult = Math.min(node, tailResult);
                memo[node] = tailResult;
            }
        } else {
            // Case 2: 이미 계산이 끝난 지점(memo[current] != 0)에 도달한 경우
            int knownResult = memo[current];
            for (int i = path.size() - 1; i >= 0; i--) {
                int node = path.get(i);
                knownResult = Math.min(node, knownResult);
                memo[node] = knownResult;
            }
        }

        return memo[n];
    }
}
