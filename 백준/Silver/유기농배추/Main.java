import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            int c = 0;

            arr = new int[n][m];
            for (int j = 0; j < k; j++) {
                String[] input2 = br.readLine().split(" ");
                int x = Integer.parseInt(input2[0]);
                int y = Integer.parseInt(input2[1]);
                arr[x][y] = 1;
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (arr[x][y] == 1) {
                        c++;
                        find(x,y);
                    }
                }
            }

            sb.append(c).append("\n");

//            for (int j = 0; j < n; j++) {
//                System.out.println(Arrays.toString(arr[j]));
//            }
//            System.out.println();
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
    public static void find(int x,int y){
        arr[x][y] = 2;

        if (x > 0){
            if (arr[x-1][y]==1) find(x-1,y);
        }
        if (y > 0){
            if (arr[x][y-1]==1) find(x,y-1);
        }
        if (x < arr.length - 1) {
            if (arr[x+1][y]==1) find(x+1,y);
        }
        if (y < arr[x].length - 1){
            if (arr[x][y+1]==1) find(x,y+1);
        }

    }
}
