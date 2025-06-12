import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int sign = 1;


        List<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+'){
                list.add(sb.toString());
                list.add(String.valueOf(input.charAt(i)));
                sb.setLength(0);
            }else{
                sb.append(input.charAt(i));
            }
            if (i == input.length()-1){
                list.add(sb.toString());
            }
        }
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("-"))    sign = -1;
            if (!list.get(i).equals("-") && !list.get(i).equals("+")){
                sum = sum + (sign * Integer.parseInt(list.get(i)));
            }

        }
        System.out.println(sum);
    }
}
