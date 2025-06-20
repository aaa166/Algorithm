import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        long c = Integer.parseInt(input[2]);


////        System.out.println(Math.pow(a,b)%c);
//        if (a%c ==0) {
//            System.out.println(0);
//        }else {
//            long n = a % c;
//            List<Long> list = new ArrayList<>();
//            for (int i = 2; i < 1000000; i++) {
//                if (!list.contains(n)) {
//                    list.add(n);
//                    n = (n * a) % c;
//                } else break;
//            }
////            System.out.println(list);
//            System.out.println((list.get((int) ((b - 1) % list.size()))));
//        };
        System.out.println(pow(a, b, c));
    }

    public static long pow(long a, long b, long c) {
        if (b == 0) return 1;
        long half = pow(a, b / 2, c);
        long result = (half * half) % c;
        if (b % 2 == 1) result = (result * a) % c;
        return result;
    }
}
