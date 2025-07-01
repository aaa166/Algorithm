import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (true) {
            input = br.readLine();
            if (input.equals("0")) break;

            String[] arrS = input.split(" ");
            int n = Integer.parseInt(arrS[0]);
            int[] arr = new int[n];

            for (int i = 1; i <= n; i++) {
                arr[i - 1] = Integer.parseInt(arrS[i]);
            }

            System.out.println(rect(arr));
        }
    }

    public static long rect(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int i = 0;
        int n = arr.length;

        while (i < n) {
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                long area = 1L * arr[top] * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            long area = 1L * arr[top] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
    public static int rect2(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n+1; j++) {
                int min = min(arr,i,j-1);
                max = Math.max(max,(j-i)*min);
            }
        }

        return max;
    }
    public static int min(int[] arr,int s, int e){
        int min = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

}
