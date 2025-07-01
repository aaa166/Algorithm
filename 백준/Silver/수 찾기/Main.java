import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arrN =new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(input[i]);
        }
        int m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int[] arrM =new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arrN);
//        System.out.println(Arrays.toString(arrN));
//        System.out.println(Arrays.toString(arrM));


        for (int i = 0; i < m; i++) {
            int target = arrM[i];
            int left = 0;
            int right = n - 1;
            boolean found = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arrN[mid] == target) {
                    found = true;
                    break;
                } else if (arrN[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(found ? "1" : "0");
        }


    }
}
