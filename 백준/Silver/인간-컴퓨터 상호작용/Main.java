import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int N = name.length();
        int[][] count = new int[26][N + 1];
        for (int i = 1; i <= N; i++) {
            int ch = name.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                count[j][i] = count[j][i - 1];
            }
            count[ch][i]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            char c = input[0].charAt(0);
            int s = Integer.parseInt(input[1]);
            int e = Integer.parseInt(input[2]);

            int idx = (Integer)(c - 'a');
            int result = count[idx][e+1] - count[idx][s];

            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String name = br.readLine();
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            String[] input = br.readLine().split(" ");
//
//            char c = input[0].charAt(0);
//            int s = Integer.parseInt(input[1]);
//            int e = Integer.parseInt(input[2]);
//
//            int count = 0;
//            for (int j = s; j <= e; j++) {
//                if (c == name.charAt(j)){
//                    count++;
//                }
//            }
//            System.out.println(count);
//        }
//    }
}
