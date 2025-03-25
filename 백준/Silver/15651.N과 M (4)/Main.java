import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String read =  br.readLine();


        String[] N = read.split(" ");
        int n = Integer.parseInt(N[0]);
        int m = Integer.parseInt(N[1]);

        StringBuffer sb = new StringBuffer();
        List<Integer> list = new ArrayList<>();

        baekjoon15652(n,m,0 , sb, bw);
        bw.flush();
    }

    public static void baekjoon15652(int n, int m,int min, StringBuffer sb, BufferedWriter bw) throws IOException {
        if (m == 0) {
            bw.write(sb.toString().trim() + "\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            StringBuffer newSb = new StringBuffer(sb);
            if(min <= i){
            newSb.append(i).append(" ");
            min = i;
            baekjoon15652(n, m-1, min, newSb, bw);
            }
        }
    }
}
