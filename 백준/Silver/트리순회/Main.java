import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    static char[][] arr;
    static HashMap<Character,String> map;
    static List<Character> pre = new ArrayList<>();
    static List<Character> in = new ArrayList<>();
    static List<Character> post = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][3];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            arr[i][0] = input.charAt(0);
            arr[i][1] = input.charAt(2);
            arr[i][2] = input.charAt(4);

            map.put(input.charAt(0),input.substring(2,5).replace(" ",""));
        }


        preorder('A');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pre.size(); i++) {
            sb.append(pre.get(i));
        }
        System.out.println(sb);

        inorder('A');
        sb = new StringBuilder();
        for (int i = 0; i < in.size(); i++) {
            sb.append(in.get(i));
        }
        System.out.println(sb);

        postorder('A');
        sb = new StringBuilder();
        for (int i = 0; i < post.size(); i++) {
            sb.append(post.get(i));
        }
        System.out.println(sb);
    }

    public static void preorder(char c){
        if (!pre.contains(c))    pre.add(c);

        if (map.get(c).charAt(0) !='.') preorder(map.get(c).charAt(0));
        if (map.get(c).charAt(1) !='.') preorder(map.get(c).charAt(1));

    }

    public static void inorder(char c){
        if (map.get(c).charAt(0) !='.'){
            inorder(map.get(c).charAt(0));

        }else {
            if (!in.contains(c))    in.add(c);
        }

        if (!in.contains(c))    in.add(c);

        if (map.get(c).charAt(1) !='.'){
            inorder(map.get(c).charAt(1));
        }else if (!in.contains(c))    in.add(c);

    }
    public static void postorder(char c){
        if (map.get(c).charAt(0) !='.'){
            postorder(map.get(c).charAt(0));
        }

        if (map.get(c).charAt(1) !='.'){
            postorder(map.get(c).charAt(1));
        }else {
            if (!post.contains(c))    post.add(c);
        }

        if (!post.contains(c))    post.add(c);
    }
}
