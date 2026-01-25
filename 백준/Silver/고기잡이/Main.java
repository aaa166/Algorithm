import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int len = Integer.parseInt(input[1])/2;
        int fish = Integer.parseInt(input[2]);

        int[][]pos = new int[fish][2];
        for (int i = 0; i < fish; i++) {
            input = br.readLine().split(" ");

            pos[i][0] = Integer.parseInt(input[0])-1;
            pos[i][1] = Integer.parseInt(input[1])-1;
        }

        int max = 0;

        for (int w = 0; w <= len; w++) {
            int h = len - w;

            for (int y = 0; y + h < n; y++) {
                for (int x = 0; x + w < n; x++) {
                    int count = 0;
                    for (int k = 0; k < fish; k++) {
                        if (pos[k][0] >= y && pos[k][0] <= y + h &&
                                pos[k][1] >= x && pos[k][1] <= x + w) {
                            count++;
                        }
                    }
                    if (count > max) max = count;
                }
            }
        }
        System.out.println(max);

    }
}

