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
        for (int i = 1 ; i <= n ; i++ ){
            list.add(i);
        }
        baekjoon15650(n,m, sb, bw,list);
        bw.flush();
    }

    public static void baekjoon15650(int n, int m, StringBuffer sb, BufferedWriter bw, List<Integer> list) throws IOException {

        if (m==0) {
            bw.write(sb.toString().trim() + "\n");
            return;
        }

        List<Integer> newList = new ArrayList<>(list);
        while (newList.size() != 0){
            StringBuffer newSb = new StringBuffer(sb);

            newSb.append(newList.get(0)).append(" ");
            newList.remove(0);
            baekjoon15650(n, m-1, newSb, bw,newList);
        }
    }
}
