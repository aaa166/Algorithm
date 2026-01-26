import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String action = br.readLine();

        char[][] map = new char[101][101];
        int x =50;
        int y =50;
        int direction = 2;      //북,동,남,서 순으로 0123
        map[x][y] = '.';
        int left = 50;
        int right = 50;
        int up = 50;
        int down = 50;

        for (int i = 0; i < action.length(); i++) {
            if (action.charAt(i) == 'F'){
                if (direction == 0){
                    x = x-1;
                    if (up > x)   up = x;
                }
                else if (direction == 1){
                    y = y+1;
                    if (right < y)   right = y;
                }
                else if (direction == 2){
                    x = x+1;
                    if (down < x)   down = x;
                }
                else{
                    y = y-1;
                    if (left > y)   left = y;
                }
                map[x][y] = '.';
            } else if (action.charAt(i) == 'R') {
                direction = (direction + 1) % 4;
            } else{
                if (direction >= 1)     direction = direction - 1;
                else                    direction = 3;
            }
        }
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (map[i][j] == '\u0000') map[i][j] = '#';
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

