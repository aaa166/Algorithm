import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String read =  br.readLine();
//        int n = Integer.parseInt(br.readLine());
//		while ((read = br.readLine()) != null) {
//			list.add(Integer.parseInt(read));
//		}

        String[] N = read.split(" ");
        int n = Integer.parseInt(N[0]);
        int m = Integer.parseInt(N[1]);

        StringBuffer sb = new StringBuffer();
        List<Integer> list = new ArrayList<>();

        baekjoon15651(n,m,0 , sb, bw);
        bw.flush();
    }
    //	N과 M (3)
    public static void baekjoon15651(int n, int m,int count, StringBuffer sb, BufferedWriter bw) throws IOException {
        if (count == m) {
            bw.write(sb.toString().trim() + "\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            StringBuffer newSb = new StringBuffer(sb);
            newSb.append(i).append(" ");
            baekjoon15651(n, m, count + 1, newSb, bw);
        }
    }
}
