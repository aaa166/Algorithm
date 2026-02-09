//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder(br.readLine());
//        int idx = -1, min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < sb.length(); i++) {
//            int charCode = (int) sb.charAt(i);
//            if (min > charCode)   {
//                min = charCode;
//                idx = i;
//            }
//        }
//        System.out.println(flip(sb, idx+1));
//    }
//    public static  StringBuilder flip(StringBuilder sb,int n){
//        StringBuilder result = new StringBuilder();
//
//        StringBuilder part1 = new StringBuilder(sb.substring(0, n));
//        part1.reverse();
//        String part2 = sb.substring(n);
//
//        return result.append(part1).append(part2);
//    }
//}
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 결과 문자열을 담을 변수 (첫 번째 문자로 시작)
        String res = String.valueOf(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);

            /* * 핵심 로직:
             * 지금까지 만든 res의 마지막 글자(res.charAt(i-1))보다
             * 현재 글자(current)가 작거나 같다면 '앞'에 붙입니다.
             * 반대의 경우 '뒤'에 붙입니다.
             */
            if (res.charAt(i - 1) >= current) {
                res = current + res;
            } else {
                res = res + current;
            }
        }

        // 마지막에 한 번 더 뒤집어줘야 사전순으로 가장 작은 문자열이 완성됩니다.
        // (앞으로 보낸 작은 글자들이 역순으로 정렬되어 있기 때문)
        StringBuilder sb = new StringBuilder(res);
        System.out.println(sb.reverse().toString());
    }
}

