import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int[][] matchs = new int[num][3];
            int count = 1;

            for (int j = 0; j < num; j++) {
                String[] input = br.readLine().split(" ");
                matchs[j][0] = Integer.parseInt(input[0]);
                matchs[j][1] = Integer.parseInt(input[1]);
                matchs[j][2] = Integer.parseInt(input[2]);
            }
            Arrays.sort(matchs, Comparator.comparingInt((int[] a) -> a[0])
                    .thenComparingInt(a -> a[1])
                    .thenComparingInt(a -> a[2]));
//            for (int j = 0; j < num; j++) {
//                System.out.println(Arrays.toString(matchs[j]));
//            }


            int[] cur = new int[]{matchs[0][0],matchs[0][1],matchs[0][2]};
            for (int j = 1; j < num; j++) {
                if (matchs[j][0]==cur[0]){
                    if (cur[2] <= matchs[j][1]){
                        count++;
                        System.arraycopy(matchs[j], 0, cur, 0, 3);
                    }else if (cur[2] > matchs[j][2]){
//                        cur[0] = matchs[j][0];
//                        cur[1] = matchs[j][1];
//                        cur[2] = matchs[j][2];
                        System.arraycopy(matchs[j], 0, cur, 0, 3);
                    }
                }else{
                    count++;
                    System.arraycopy(matchs[j], 0, cur, 0, 3);
                }
            }


            System.out.printf("Scenario #%d:\n",i+1);
            System.out.printf("%d\n\n",count);
        }
    }
}

