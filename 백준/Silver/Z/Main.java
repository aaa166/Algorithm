import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int seq = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int result = 0;

        arr = new int[n+1];
        findSeq(n,r,c);

        for (int i = 1; i <= n; i++) {
            result += arr[i];
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(result);

    }
    public static void findSeq(int n,int r, int c){
        if (n==0)   return;
        int half = (int)Math.pow(2,n-1);
        //1
        if (half > r && half > c){
            arr[n] = 0;
            findSeq(n-1,r,c);
        }//2
        else if (half > r) {
            arr[n] = half * half;
            findSeq(n-1,r,c-half);
        }//3
        else if (half > c) {
            arr[n] = half * half * 2;
            findSeq(n-1,r-half,c);
        }//4
        else {
            arr[n] = half * half * 3;
            findSeq(n-1,r-half,c-half);
        }
    }

}

