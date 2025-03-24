import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                arr[i][j] = ' ';
            }
        }
        drawStar(arr, 0, n - 1, n);

        for (int i = 0; i < n; i++) {
            System.out.println(new String(arr[i]));
        }
    }

    public static void drawStar(char[][] arr, int x, int y, int size) {
        if (size == 3) {
            arr[x][y] = '*';
            arr[x + 1][y - 1] = '*';
            arr[x + 1][y + 1] = '*';
            arr[x + 2][y - 2] = '*';
            arr[x + 2][y - 1] = '*';
            arr[x + 2][y] = '*';
            arr[x + 2][y + 1] = '*';
            arr[x + 2][y + 2] = '*';
        } else {
            int newSize = size / 2;

            drawStar(arr, x, y, newSize);
            drawStar(arr, x + newSize, y - newSize, newSize);
            drawStar(arr, x + newSize, y + newSize, newSize);
        }
    }
}