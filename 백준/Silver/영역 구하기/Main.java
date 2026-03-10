import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static  int m, n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        map = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int y1 = Integer.parseInt(input[0]);
            int x1 = Integer.parseInt(input[1]);
            int y2 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);

            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    map[j][l] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!map[i][j]){
                    list.add(section(i,j,0));
                    count++;
                }
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        sb.setLength(sb.length()-1);

        System.out.println(count);
        System.out.println(sb);
    }
    public static int section(int x, int y,int size){
        map[x][y] = true;
        size++;
        if (x > 0){
            if (!map[x-1][y])   size = section(x-1,y,size);
        }
        if (y > 0){
            if (!map[x][y-1])   size = section(x,y-1,size);
        }
        if (x < m-1){
            if (!map[x+1][y])   size = section(x+1,y,size);
        }
        if (y < n-1){
            if (!map[x][y+1])   size = section(x,y+1,size);
        }
        return size;
    }
}

