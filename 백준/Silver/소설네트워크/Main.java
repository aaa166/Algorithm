import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][n];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0])-1;
            int b = Integer.parseInt(input[1])-1;

            if (a > b)  arr[b][a] = -1;
            else arr[a][b] = -1;
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        System.out.println();

        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i].clone();
        }

        int count = m;
        int day = 1;
        int[] result = new int[20];
        while (count < n * (n - 1) / 2) {
            int newFriendsThisDay = 0;

            for (int i = 0; i < n; i++) {
                for (int k = i + 1; k < n; k++) {
                    if (arr[i][k] != 0) {
                        continue;
                    }

                    for (int j = 0; j < n; j++) {
                        if (i == j || k == j) {
                            continue;
                        }

                        int friend1_row = Math.min(i, j);
                        int friend1_col = Math.max(i, j);
                        int friend2_row = Math.min(j, k);
                        int friend2_col = Math.max(j, k);

                        if (arr[friend1_row][friend1_col] != 0 && arr[friend2_row][friend2_col] != 0) {
                            copy[i][k] = -1;
                            newFriendsThisDay++;
                            break;
                        }
                    }
                }
            }

            if (newFriendsThisDay == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                arr[i] = copy[i].clone();
            }

            result[day] = newFriendsThisDay;
            count += newFriendsThisDay;
            day++;
        }

//        while (count < n*(n-1)/2){
//            for (int i = 0; i < n; i++) {
//                for (int j = i+1; j < n; j++) {
//                    if (arr[i][j] != 0){
//                        for (int k = j+1; k < n; k++) {
//                            if (arr[j][k] != 0) {
//                                if (copy[i][k] == 0) {
//                                    copy[i][k] = day;
//                                    result[day]++;
//                                }
//                            }
//                        }
//                    }
//
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                arr[i] = copy[i].clone();
//            }
//
////            for (int i = 0; i < n; i++) {
////                System.out.println(Arrays.toString(arr[i]));
////            }
//            System.out.println();
//
//            count += result[day];
//            day++;
//        }

        System.out.println(day-1);
        for (int i = 1; i < day; i++) {
            System.out.println(result[i]);
        }


//        day = 3;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (arr[i][j] != 0){
//                    for (int k = j+1; k < n; k++) {
//                        if (arr[j][k] != 0) {
//                            if (arr[i][k] == 0) copy[i][k] = day;
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            arr[i] = copy[i].clone();
//        }







    }
}

