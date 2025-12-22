//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        String[] arr = new String[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = br.readLine();
//        }
//
//        for (int i = 0; i < n; i++) {
//            String s = arr[i];
//            int idx = 0;
//            boolean ok = true;
//
//            while (idx < s.length()) {
//                if (s.charAt(idx) == '0') {
//                    // 01
//                    if (idx + 1 < s.length() && s.charAt(idx + 1) == '1') {
//                        idx += 2;
//                    } else {
//                        ok = false;
//                        break;
//                    }
//                } else { // 1로 시작
//                    if (idx + 2 < s.length() && s.charAt(idx + 1) == '0' && s.charAt(idx + 2) == '0') {
//                        idx += 3;
//                        // 0+ 반복
//                        while (idx < s.length() && s.charAt(idx) == '0') {
//                            idx++;
//                        }
//                        // 1+
//                        int cnt = 0;
//                        while (idx < s.length() && s.charAt(idx) == '1') {
//                            idx++;
//                            cnt++;
//                        }
//                        if (cnt < 1) {
//                            ok = false;
//                            break;
//                        }
//
//                    } else {
//                        ok = false;
//                        break;
//                    }
//                }
//            }
//
//            System.out.println(ok ? "YES" : "NO");
//        }
//    }
//}

//===============================================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            // 100+1+ 또는 01 패턴이 반복
            if (s.matches("(100+1+|01)+")) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}


