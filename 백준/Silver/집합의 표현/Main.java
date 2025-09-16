import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x = m+1;

        List<Integer> list = new LinkedList<>();


        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            boolean tf  = Objects.equals(input[0], "0");
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (tf){
                if (list.contains(a) && list.contains(b)){
                    if (a == b) continue;

                    int aStart = list.indexOf(a);
                    while (aStart > 0 && list.get(aStart - 1) != x) {
                        aStart--;
                    }
                    int aEnd = aStart;
                    while (list.get(aEnd) != x) {
                        aEnd++;
                    }

                    int bStart = list.indexOf(b);
                    while (bStart > 0 && list.get(bStart - 1) != x) {
                        bStart--;
                    }
                    int bEnd = bStart;
                    while (list.get(bEnd) != x) {
                        bEnd++;
                    }

                    if (aEnd != bEnd) {
                        List<Integer> tempSet = new LinkedList<>();
                        for (int k = bStart; k < bEnd; k++) {
                            tempSet.add(list.get(k));
                        }

                        for (int k = bEnd; k >= bStart; k--) {
                            list.remove(k);
                        }

                        aStart = list.indexOf(a);
                        while (aStart > 0 && list.get(aStart - 1) != x) aStart--;
                        while (list.get(aStart) != x) aStart++;

                        list.addAll(aStart, tempSet);
                    }

                }
                else if (list.contains(a) && !list.contains(b)){
                    int aIndex = list.indexOf(a);
                    while (list.get(aIndex) != x) {
                        aIndex++;
                    }
                    list.add(aIndex, b);
                }
                else if (list.contains(b) && !list.contains(a)){
                    int bIndex = list.indexOf(b);
                    while (list.get(bIndex) != x) {
                        bIndex++;
                    }
                    list.add(bIndex, a);
                }else{
                    list.add(a);
                    list.add(b);
                    list.add(x);
                }


            }//1일때
            else{
                if (a == b){
                    System.out.println("YES");
                    continue;
                }

                if (list.contains(a) && list.contains(b)){
                    int s = Math.min(list.indexOf(a),list.indexOf(b));
                    int e = Math.max(list.indexOf(a),list.indexOf(b));

                    boolean foundNo = false;
                    for (int j = s; j < e ; j++) {
                        if (j > s && list.get(j) == x) {
                            System.out.println("NO");
                            foundNo = true;
                            break;
                        }
                    }
                    if (!foundNo) {
                        System.out.println("YES");
                    }
                }else {
                    System.out.println("NO");
                }
            }
//            System.out.println(list);
        }


    }
}

