import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int len = Integer.parseInt(input[0])+1;
        int n = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[len];
        for (int i = 1; i < len; i++) {
            arr[i] = arr[i-1]+Integer.parseInt(input[i-1]);
        }

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            System.out.println(baekjoon11659(arr,Integer.parseInt(input[0]),Integer.parseInt(input[1])));
        }

    }
    public static int baekjoon11659(int[] arr ,int s, int e){
        int result = arr[e] - arr[s-1];

        return result;
    }
}
