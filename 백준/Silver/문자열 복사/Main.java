import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();
        int lenS = S.length();
        int lenP = P.length();

        char cur;
        int result = 0;
        for (int i = 0; i <lenP; i++) {
            int max = 1;
            for (int j = 0; j < lenS; j++) {
                if (P.charAt(i) == S.charAt(j)){

                    int len = 1;

                    while (i+(len-1)<lenP-1 && j+(len-1)<lenS-1 && P.charAt(i+len) == S.charAt(j+len)){
                        len++;
                    }
                    max = Math.max(max,len);
                }
            }
            result++;
            i = i+(max-1);
        }

        System.out.println(result);

    }
}
