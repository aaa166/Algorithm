import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int[] target = new int[n];
            for (int j = 0; j < n; j++) {
                target[j] = Integer.parseInt(input[j]);
            }
            if (isSame(arr,target)){
                count++;
                for (int j = 0; j < n; j++) {
                    sb.append(target[j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(count);
        System.out.println(sb);
        br.close();
    }

    public static boolean isSame(int[] arr,int[]target){
        int n = arr.length;
        //정방향
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[(i+j)%n] != target[j])  break;
                if (j==n-1) return true;
            }
        }


        //역방향
        int[] reverse = new int[n];
        for (int i = 0; i < n; i++) {
            switch (target[i]) {
                case 1:
                    reverse[i] = 3;
                    break;
                case 2:
                    reverse[i] = 4;
                    break;
                case 3:
                    reverse[i] = 1;
                    break;
                case 4:
                    reverse[i] = 2;
                    break;
                default:
                    System.out.println("X");
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (arr[(i-j+n)%n] != reverse[j])  break;
                if (j==n-1) return true;
            }
        }



        return false;
    }
}

