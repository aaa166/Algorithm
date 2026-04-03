import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        l:
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] phone = new String[n];

            for (int i = 0; i < n; i++) {
                phone[i] = br.readLine();
            }

            Arrays.sort(phone);

            boolean isConsistent = true;
            for (int i = 0; i < n - 1; i++) {
                if (phone[i + 1].startsWith(phone[i])) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
