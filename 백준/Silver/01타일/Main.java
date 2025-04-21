import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int read = Integer.parseInt(br.readLine());

        System.out.println(baekjoon1904(read));

    }
    public static int baekjoon1904(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i-1] + arr[i-2])%15746;
        }
        return arr[n-1];
    }
//    public static int baekjoon1904_a(int n){
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//
//        int[] arr = new int[n+1];
//        arr[1] = 1;
//        arr[2] = 2;
//        for (int a = 3; a <= n; a++) {
//            if (a % 2==0){
//                for (int i = 0; i <= a/2; i++) {
//                    arr[a] = arr[a] + (factorial(a-i)/((a-2*i == 0) ? 1 : factorial(a-2*i))/((i == 0) ? 1 : factorial(i)));
//                }
//            }else{
//                for (int i = 0; i < (a+1)/2; i++) {
//                    arr[a] = arr[a] + (factorial(a-i)/ factorial(a-2*i)/((i == 0) ? 1 : factorial(i)));
//                }
//            }
//        }
//        return arr[n];
//    }
//    public static  int factorial(int num){
//        if (num <= 1) return 1;
//        int result = 1;
//        for (int i = 2; i <= num; i++) {
//            result *= i;
//        }
//        return result;
//    }
}
