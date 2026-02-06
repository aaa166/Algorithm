import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder head,tail,sb;
//        int n = Integer.parseInt(br.readLine());
//        String input = br.readLine();
//        sb = new StringBuilder(input);
//
//        int len = input.length();
//        for (int i = 0; i < n; i++) {
//            head = new StringBuilder();
//            tail = new StringBuilder();
//            for (int j = 0; j < len; j++) {
//                if (j % 2 == 0){
//                    head.append(sb.charAt(j));
//
//                }else{
//                    tail.append(sb.charAt(j));
//                }
//            }
//            tail.reverse();
//            sb.setLength(0);
//            sb.append(head).append(tail);
//        }
//        System.out.println(sb);
//    }
static int getNewIndex(int oldIndex, int len) {
    if (oldIndex % 2 == 0) {
        return oldIndex / 2;
    } else {
        return len - 1 - (oldIndex / 2);
    }
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int len = chars.length;

        int[] perm = new int[len];
        for (int i = 0; i < len; i++) {
            perm[i] = getNewIndex(i, len);
        }

        char[] result = chars.clone();
        while (n > 0) {
            if (n % 2 == 1) {
                char[] tmp = new char[len];
                for (int i = 0; i < len; i++) {
                    tmp[perm[i]] = result[i];
                }
                result = tmp;
            }
            int[] nextPerm = new int[len];
            for (int i = 0; i < len; i++) {
                nextPerm[i] = perm[perm[i]];
            }
            perm = nextPerm;
            n /= 2;
        }

        System.out.println(new String(result));
    }

}

