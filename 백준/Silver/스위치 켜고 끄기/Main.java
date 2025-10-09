import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            onOff(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
            if ((i+1) % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
    public static void onOff(int gender,int num){
        if (gender == 1){
            for (int i = num; i <= n; i += num) {
                arr[i-1] = arr[i-1] ^ 1;
            }
        }else {
            int cur = num-1;
            arr[cur] = arr[cur] ^ 1;

            int left = num-2;
            int right = num;

            while (left >= 0 && right < n){
                if (arr[left] == arr[right]){
                    arr[left] = arr[left] ^ 1;
                    arr[right] = arr[right] ^ 1;
                }else break;

                left--;
                right++;
            }

        }
    }
}

