import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, String> history = new TreeMap<>();
        String cur = "";

        history.put(0, cur);

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            if (command.equals("type")) {
                String type = input[1];
                int time = Integer.parseInt(input[2]);

                cur += type;
                history.put(time, cur);

            } else {
                int undo = Integer.parseInt(input[1]);
                int time = Integer.parseInt(input[2]);

                int targetTime = time - undo - 1;

                Integer key = history.floorKey(targetTime);

                if (key == null) {
                    cur = "";
                } else {
                    cur = history.get(key);
                }

                history.put(time, cur);
            }
        }

        System.out.println(cur);
    }
}
