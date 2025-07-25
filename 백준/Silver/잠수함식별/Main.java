import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            que.add(input.charAt(i));
        }
        System.out.println(isSubmarine(que));
        br.close();
    }

    public static String isSubmarine(Queue<Character> que){
//        char next;
//        while (que.size() >= 2){
//            next = que.poll();
//            if (next == '0'){
//                if (que.poll() != '1')  return "NOISE";
//            } else if (next == '1' && que.size() >= 4) {
//                if (que.poll()=='0' && que.poll()=='0'){
//                    while (que.peek() == '0'){
//                        que.poll();
//                    }
//                    if (!que.isEmpty() && que.peek() == '1'){
//                        while (que.peek() == '1'){
//                            que.poll();
//                        }
//                    }
//                }else return "NOISE";
//
//            }else return "NOISE";
//        }
//        if (que.isEmpty())  return "SUBMARINE";
//        else return "NOISE";

        while (!que.isEmpty()) {
            if (que.size() >= 2 && que.peek() == '0') {
                que.poll();
                if (que.poll() != '1') return "NOISE";
                continue;
            }

            if (que.size() >= 4 && que.peek() == '1') {
                que.poll();

                if (que.poll() != '0') return "NOISE";
                if (que.poll() != '0') return "NOISE";

                while (!que.isEmpty() && que.peek() == '0') {
                    que.poll();
                }

                if (que.isEmpty() || que.peek() != '1') return "NOISE";

                while (!que.isEmpty() && que.peek() == '1') {
                    que.poll();
                }

                continue;
            }

            return "NOISE";
        }

        return "SUBMARINE";
    }
}