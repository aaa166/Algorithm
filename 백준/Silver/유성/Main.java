import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        char[][] arr =new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        
//        빈공간 계산
//        int min = Integer.MAX_VALUE;
//        for (int j = 0; j < m; j++) {
//            int num = 0;
//            for (int i = 0; i < n; i++) {
//                if (arr[i][j] =='X')     num = 0;
//                else if (arr[i][j] == '.') num++;
//                else{
//                    min = Math.min(min,num);
//                    break;
//                }
//            }
//        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int num = 0;
            boolean isMeteor = false;
            for (int i = 0; i < n; i++) {
                if (arr[i][j] =='X'){
                    num = 0;
                    isMeteor = true;
                }
                else if (arr[i][j] == '.') num++;
                else{
                    if (isMeteor)   min = Math.min(min,num);

                    break;
                }
            }
        }

        char[][] result = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '#')   result[i][j] ='#';
                else if (arr[i][j] == 'X') result[i+min][j] ='X';
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(result[i]));
//        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 'X' )sb.append('X');
                else if (result[i][j] == '#' )sb.append('#');
                else sb.append('.');
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }


}

