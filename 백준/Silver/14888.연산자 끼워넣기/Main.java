import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1
        int n1 = Integer.parseInt(br.readLine());
        //2
        String read1 = br.readLine();
        String[] sarr1 = read1.split(" ");
        int[] arr1 = new int[n1];
        for (int i = 0 ; i < arr1.length ; i++){
            arr1[i] = Integer.parseInt(sarr1[i]);
        }
        //3
        String read2 = br.readLine();
        String[] sarr2 = read2.split(" ");
        int[] arr2 = new int[4];
        for (int i = 0 ; i < arr2.length ; i++){
            arr2[i] = Integer.parseInt(sarr2[i]);
        }

        baekjoon14888(arr1,arr2,1,arr1[0]);
        System.out.println(min);
        System.out.println(max);
    }

    public static void baekjoon14888(int[] arr1, int[] arr2, int index, int result){
        if (index == arr1.length) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (arr2[i] > 0) {
                arr2[i]--;
                int newResult = 0;

                switch (i) {
                    case 0: newResult = result + arr1[index]; break;
                    case 1: newResult = result - arr1[index]; break;
                    case 2: newResult = result * arr1[index]; break;
                    case 3: newResult = result / arr1[index]; break;
                }

                baekjoon14888(arr1, arr2, index + 1, newResult);

                arr2[i]++;
            }
        }
    }
}
