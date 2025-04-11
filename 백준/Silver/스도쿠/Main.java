import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
//    static List<int[]> list = new ArrayList<>();
static boolean found = false;

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[9][9];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 9; i++) {
            String[] read =  br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(read[j]);
//                if (arr[i][j] == 0){
//                    list.add(new int[]{i,j});
//                }
            }
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }
        baekjoon2580(arr);

    }


    public static void baekjoon2580(int[][] arr){
        if (found) return;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0){
                    List<Integer> list = new ArrayList<>();

                    outer:
                    for (int k = 1; k < 10; k++) {
                        //가로, 세로
                        for (int l = 0; l < 9; l++) {
                            if (k == arr[i][l]) continue outer;
                            if (k == arr[l][j]) continue outer;
                        }
                        //3x3
                        int a = (i/3)*3;
                        int b = (j/3)*3;
                        for (int l = a; l < a+3; l++) {
                            for (int m = b; m < b+3; m++) {
                                if (k == arr[l][m]) continue outer;
                            }
                        }
                        list.add(k);
                    }
                    if (list.isEmpty()) return;

                    for (int k = 0; k < list.size(); k++) {
                        arr[i][j] = list.get(k);
                        baekjoon2580(arr);
                        if (found) return;
                        arr[i][j] = 0;
                    }
                    return;
                }


            }
        }
        // 모든 칸을 채운 경우
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        found = true;

    }



    public static void baekjoon2580(){
    }
    public static boolean isPossible(int x,int j){
        return true;
    }
}
