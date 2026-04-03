import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            String[] task = br.readLine().split(" ");

            if (task[0].equals("1")){
                int score = Integer.parseInt(task[1]);
                int time = Integer.parseInt(task[2]);

                if (time == 1)   result = result + score;
                else    stack.push(new int[]{score,time-1});
            }else{
                if (!stack.empty()){
                    int[] top = stack.pop();
                    if (top[1] == 1){
                        result = result + top[0];
                    }else {
                        top[1]--;
                        stack.push(top);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
