import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long numerator = factorial[n]; // n!
        long denominator = ((factorial[k] % MOD) * (factorial[n - k] % MOD)) % MOD;
        long inverse = modPow(denominator, MOD - 2); // 역원

        long result = (numerator * inverse) % MOD;
        System.out.println(result);

    }
    public static long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            //(exp & 1) == 1와 exp % 2 == 1 은 같음
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }


}
