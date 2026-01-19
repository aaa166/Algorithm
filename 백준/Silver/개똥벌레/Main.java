import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] down = new int[h + 2];
        int[] up = new int[h + 2];

        for (int i = 0; i < n; i++) {
            int wall = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                down[wall]++;
            } else {
                up[wall]++;
            }
        }


        for (int i = h - 1; i >= 1; i--) {
            down[i] += down[i + 1];
            up[i] += up[i + 1];
        }

        int min = n;
        int num = 0;

        for (int i = 1; i <= h; i++) {
            int wall = down[i] + up[h - i + 1];

            if (wall < min) {
                min = wall;
                num = 1;
            } else if (wall == min) {
                num++;
            }
        }

        System.out.println(min + " " + num);
    }
}


//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int h = Integer.parseInt(input[1]);
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        int min = n;
//        int num = 1;
//
//
//        int wall = 0;
//        for (int i = 1; i <= h; i++) {
//            wall = 0;
//            for (int j = 0; j < n; j++) {
//                if (j % 2 == 0) {
//                    if (arr[j] >= i) wall++;
//                } else {
//                    if (arr[j] >= h - i + 1) wall++;
//                }
//            }
//
//            if (min > wall) {
//                min = wall;
//                num = 1;
//            } else if (min == wall) {
//                num++;
//            }
//        }
//        System.out.printf("%d %d",min,num);
//
//    }
//}
