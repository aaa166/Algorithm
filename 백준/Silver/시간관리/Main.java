import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));


        int start = arr[0][1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i][0];
            int s = arr[i][1];

            if (s - sum < 0){
                start = -1;
                break;
            }else if (s - sum < start){
                start = s - sum;
            }


        }
        System.out.println(start);
    }
}


