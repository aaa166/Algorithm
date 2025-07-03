import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrN =new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arrN);
        int m = Integer.parseInt(br.readLine());
        int[] arrM =new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int count = up(arrN, arrM[i]) - down(arrN, arrM[i]);
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString().trim());

    }

    public static int up(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int down(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
