import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());

        System.out.println(maxNum(m));
        br.close();
    }

    public static StringBuilder maxNum(int m){
        int[] minCost = {arr[0],arr[1]};
        int[] minDigit = {-1,-1};

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < minCost[1]) {
                minCost[1] = arr[i];
                minDigit[1] = i;
            }
        }
        if (arr[0] < minCost[1]){
            minCost[0] = arr[0];
            minDigit[0] = 0;
        }else {
            minCost[0] = minCost[1];
            minDigit[0] = minDigit[1];
        }

        if (minCost[1] > m) {
            sb.append(0);
            return sb;
        }


        int len = (m - minCost[1]) / minCost[0] + 1;
        int remain = m;

        for (int i = 0; i < len; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                int cost = arr[j];
                int minTotalCostForRemaining = (len - i - 1) * minCost[0];

                // 첫 자리에 0은 올 수 없음 (길이 > 1일 때)
                if (i == 0 && j == 0 && len > 1) continue;

                // 남은 예산으로 이 숫자 고르고 나머지 자리 최소비용 충당 가능한지 체크
                if (remain - cost >= minTotalCostForRemaining) {
                    sb.append(j);
                    remain -= cost;
                    break;
                }
            }
        }

        return sb;
    }
}

