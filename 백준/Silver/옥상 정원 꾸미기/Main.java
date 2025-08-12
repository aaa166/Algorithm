import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        long count = 0;

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(reader.readLine());


            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }

//            System.out.println(stack);
            count += stack.size();

            stack.push(height);
        }

        System.out.println(count);
        reader.close();
    }
}