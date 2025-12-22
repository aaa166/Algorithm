import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r1 = Integer.parseInt(input[1]);
        int c1 = Integer.parseInt(input[2]);
        int r2 = Integer.parseInt(input[3]);
        int c2 = Integer.parseInt(input[4]);

        int size = 2 * n - 1;
        int center = n - 1;

//        StringBuilder sb = new StringBuilder();

        for (int i = r1; i <= r2; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = c1; j <= c2; j++) {

                int ti = Math.floorMod(i, size);
                int tj = Math.floorMod(j, size);

                int m = Math.abs(ti - center) + Math.abs(tj - center);
                if (m > center) {
                    sb.append('.');
                } else {
                    sb.append((char) ('a' + m));
                }
            }
            System.out.println(sb);
//            sb.append('\n');
        }
//        sb.setLength(sb.length()-1);
//        System.out.print(sb);
    }


}

