import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
           int n = Integer.parseInt(br.readLine());
            boolean[] dp = new boolean[7];
            dp[1] = true;

            for (int j = 0; j < n; j++) {
                String[] str = br.readLine().split(" ");
                int v1 = Integer.parseInt(str[1]);
                int v2 = Integer.parseInt(str[3]);

                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < dp.length; k++) {
                    if (dp[k]){
                        if (str[0].equals("+"))     set.add((k+v1)%7);
                        else                        set.add((k*v1)%7);

                        if (str[2].equals("+"))     set.add((k+v2)%7);
                        else                        set.add((k*v2)%7);
                    }
                }
                for (int k = 0; k < 7; k++) {
                    if (set.contains(k))    dp[k] = true;
                    else                    dp[k] = false;

                }

            }
            if (dp[0]) System.out.println("LUCKY");
            else        System.out.println("UNLUCKY");

        }

    }
}
