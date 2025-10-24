import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][5];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split(" ");
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        Set<Character> set = new HashSet<>();
        char c;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!set.contains(arr[i][j].charAt(0))){
                    c = arr[i][j].charAt(0);
                    set.add(c);
                    set.add(switchChar(c));
                    arr[i][j] = "[" + arr[i][j].charAt(0) + "]" + arr[i][j].substring(1);
                    continue outer;
                }
            }
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 1; k < arr[i][j].length(); k++) {
                    if (!set.contains(arr[i][j].charAt(k))){
                        c = arr[i][j].charAt(k);
                        set.add(c);
                        set.add(switchChar(c));
                        arr[i][j] = arr[i][j].substring(0,k) + "[" + arr[i][j].charAt(k) + "]" + arr[i][j].substring(k+1);
                        continue outer ;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
    public static char switchChar(char c){
        if (Character.isLowerCase(c))   return Character.toUpperCase(c);
        else    return Character.toLowerCase(c);
    }
}
