import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{k, 0});

        int num,time = 1;
        while (!queue.isEmpty()){
            num = queue.peek()[0];
            time = queue.poll()[1];

            if (num == n) {
                System.out.println(time);
                break;
            }

            visited[num]=true;
            if (num%2==0 && !visited[num/2])    queue.offer(new int[]{num/2, time+1});

            if (num + 1 <= 100000 && !visited[num + 1])    queue.offer(new int[]{num+1, time+1});

            if (num - 1 >= 0 && !visited[num - 1])    queue.offer(new int[]{num-1, time+1});
        }



    }
}

