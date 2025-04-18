import java.io.*;

public class Main {
    static int[][][] arr = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String r ;
        while( (r=br.readLine()) != null && !(r.isEmpty())) {
            String[] read = r.split(" ");
            int a = Integer.parseInt(read[0]);
            int b = Integer.parseInt(read[1]);
            int c = Integer.parseInt(read[2]);

            if (a == -1 && b == -1 && c == -1) break;

            System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,baekjoon9184(a,b,c));
        }


//        String[] read = br.readLine().split(" ");
//        int[] input = new int[3];
//        for (int j = 0; j < 3; j++) {
//            input[j] = Integer.parseInt(read[j]);
//        }
//        System.out.printf("w(%d, %d, %d) = %d",input[0],input[1],input[2],baekjoon9184(input[0],input[1],input[2]));

    }
    public static  int baekjoon9184(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) return baekjoon9184(20,20,20);

        if (arr[a][b][c] != 0) return arr[a][b][c];


        if (a < b && b < c)
            arr[a][b][c] = baekjoon9184(a, b, c-1)
                    + baekjoon9184(a, b-1, c-1)
                    - baekjoon9184(a, b-1, c);
        else arr[a][b][c] = baekjoon9184(a-1, b, c)
                +baekjoon9184(a-1, b-1, c)
                +baekjoon9184(a-1, b, c-1)
                -baekjoon9184(a-1, b-1, c-1);

        return arr[a][b][c];
    }
}
