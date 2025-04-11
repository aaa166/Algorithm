import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        String read;
        for (int i =0 ; i < n; i++){
            read = br.readLine();
            String[] Sarr = read.split(" ");

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(Sarr[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n ; i++ ){
            list.add(i);
        }

        int halfN = n/2;
        List<Integer> team1 = new LinkedList<>();

        int[] min = new int[]{Integer.MAX_VALUE};
        System.out.println(baekjoon14889(n,min,arr,team1,list,0));



    }

    public static int baekjoon14889(int n,int[] min, int[][] arr, List<Integer> team1, List<Integer> list,int start){
        if (team1.size() == n/2){
            List<Integer> team2 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (!team1.contains(i)) team2.add(i);
            }
//            System.out.printf("%s  :  %s ",team1,team2);
            int num = 0;
            for (int i = 0; i < team1.size(); i++) {
                for (int j = 0; j < team1.size(); j++) {
                    num = num + arr[team1.get(i)][team1.get(j)] - arr[team2.get(i)][team2.get(j)];
                }
            }
            min[0] = Math.min(min[0], Math.abs(num));
//            System.out.println(min[0]);
            return min[0];
        }

        for (int i = start; i < n; i++) {
            team1.add(i);
            baekjoon14889(n, min, arr, team1, list, i + 1);
            team1.remove(team1.size() - 1);
        }
        return min[0];

    }
}
