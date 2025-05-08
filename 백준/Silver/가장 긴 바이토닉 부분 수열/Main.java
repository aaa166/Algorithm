import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] read = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(read[i]);
        }
        System.out.println(baekjoon(arr));
    }
    
    public static int baekjoon(int[] arr){
        int n = arr.length;
        int[] asc = new int[n];
        int[] desc = new int[n];


        for (int i = 0; i < n; i++) {
            asc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    asc[i] = Math.max(asc[i], asc[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            desc[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    desc[i] = Math.max(desc[i], desc[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, asc[i] + desc[i] - 1);
        }


        return maxLen;
    }
}
