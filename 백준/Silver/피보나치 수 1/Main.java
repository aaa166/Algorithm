import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] num = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int read = Integer.parseInt(br.readLine());

        fib_A(read);
        fib_B(read);
        System.out.printf("%d %d",num[0],num[1]);

    }

    public static int fib_A(int n){
        if (n == 1 || n == 2){
            num[0]++;
            return 1;
        }
        else    return fib_A(n-1) + fib_A(n-2);
    }
    public static int fib_B(int n){
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1)   arr[i] = 1;
            else{
                arr[i] = arr[i-1] + arr[i-2];
                num[1]++;
            }
        }
        return arr[n-1];
    }
}
