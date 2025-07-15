import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr  = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
            arr[i][2] = Integer.parseInt(input[2]);
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }


        System.out.println(affinityScore(arr));;

    }
    public static int affinityScore(int[][] arr){
        int result =Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int a = Math.abs(arr[i][0]-arr[j][0]) +
                        Math.abs(arr[i][1]-arr[j][1]) +
                        Math.abs(arr[i][2]-arr[j][2]);

                if (a < min1){
                    min2 = min1;
                    min1 = a;
                }
                else if (a<min2) min2 = a;
            }
            result = Math.min(result,min1 + min2);
        }
        return result;


//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (i == j) continue;
//                for (int k = j+1; k < n; k++) {
//                    if (i == k || j == k) continue;
//                    int a = Math.abs(arr[i][0]-arr[j][0]) +
//                            Math.abs(arr[i][1]-arr[j][1]) +
//                            Math.abs(arr[i][2]-arr[j][2]);
//                    if (a >= min)   continue;
//                    int b = Math.abs(arr[j][0]-arr[k][0]) +
//                            Math.abs(arr[j][1]-arr[k][1]) +
//                            Math.abs(arr[j][2]-arr[k][2]);
//
//                    min = Math.min(a+b,min);
//                }
//            }
//        }
//        return min;
    }
}
