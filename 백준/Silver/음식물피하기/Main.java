import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] food,arr;
    static int n,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        arr = new int[n][m];
        food = new int[k][2];
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            food[i][0] = x;
            food[i][1] = y;

            arr[x][y] = 1;
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        for (int i = 0; i < k; i++) {
//            System.out.println(Arrays.toString(food[i]));
//        }


        int max = 0;
        for (int i = 0; i < k; i++) {
            int x = food[i][0];
            int y = food[i][1];

            if (arr[x][y] == 1) max = Math.max(max, foodSize(x,y));
        }
        System.out.println(max);
    }
    public static int foodSize(int x,int y){
        arr[x][y]=2;
        int size = 1;

        if (x > 0){
            if (arr[x-1][y] == 1)   size = size + foodSize(x-1,y);
        }
        if (y > 0){
            if (arr[x][y-1] == 1)   size = size + foodSize(x,y-1);
        }
        if (x < n-1){
            if (arr[x+1][y] == 1)   size = size + foodSize(x+1,y);
        }
        if (y < m-1){
            if (arr[x][y+1] == 1)   size = size + foodSize(x,y+1);
        }


        return size;
    }
}
