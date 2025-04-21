import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] read = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            read[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,read[i]);
        }
        long[] arr = new long[max+1];
        beakjoon9461(max+1,arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[read[i]]);
        }

    }
    public static void beakjoon9461(int n,long[] arr){
        if (n > 1) arr[1] = 1;
        if (n > 2) arr[2] = 1;
        if (n > 3) arr[3] = 1;
        if (n > 4) arr[4] = 2;
        if (n > 5) arr[5] = 2;

        for (int i = 6; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }
    }

}
