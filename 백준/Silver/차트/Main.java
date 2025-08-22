import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static Integer[] arr;
    static int line = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        if (arr[0]>50){
            System.out.println(0);
            return;
        }else if (arr[0]==50){
            System.out.println(1);
            return;
        }
        countLine(0,arr[0]);
        System.out.println(line);
    }
    public static void countLine(int cur, int num){
//        for (int i = cur; i < arr.length; i++) {
//            int sum = num+ arr[i];
//            if (sum == 50){
//                line++;
//            }else if (sum<50){
//                countLine(cur+1,sum);
//            }
//        }
        if (num == 50) {
            line++;
            return;
        }

        for (int i = cur; i < arr.length; i++) {
            if (num + arr[i] <= 50) {
                countLine(i + 1, num + arr[i]);
            }
        }
    }
}
