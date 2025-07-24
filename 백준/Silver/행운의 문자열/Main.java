import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) map.put(str.charAt(i),map.get(str.charAt(i))+1);
            else map.put(str.charAt(i),1);
        }
        System.out.println(map.entrySet());
        br.close();
    }

    public static void findNum(Map<Character,Integer> map,int len,char c){

    }
}

