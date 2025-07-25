import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][3];
        for (int a = 0; a < n; a++) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                String str = br.readLine();
                for (int j = 0; j < 3; j++) {
                    if (str.charAt(j) == '*')    arr[i][j] = 1;
                    else                    arr[i][j] = 0;
                }
            }

            int[][] copy = new int[3][3];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 2; l++) {
                            for (int m = 0; m < 2; m++) {
                                for (int o = 0; o < 2; o++) {
                                    for (int p = 0; p < 2; p++) {
                                        for (int q = 0; q < 2; q++) {
                                            for (int r = 0; r < 2; r++) {
                                                
                                                for (int s = 0; s < 3; s++) {
                                                    copy[s] = arr[s].clone();
                                                }
                                                int[] pos = {i,j,k,l,m,o,p,q,r};
                                                min = Math.min(min, flip(pos,copy)) ;
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }

        br.close();
    }

    public static int flip(int[] pos,int[][] arr){
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (pos[i] == 1){
                count++;
                switch (i) {
                    case 0:
                        arr[0][0]++;
                        arr[1][0]++;
                        arr[0][1]++;
                        break;
                    case 1:
                        arr[0][0]++;
                        arr[0][1]++;
                        arr[0][2]++;
                        arr[1][1]++;
                        break;
                    case 2:
                        arr[0][1]++;
                        arr[0][2]++;
                        arr[1][2]++;
                        break;
                    case 3:
                        arr[0][0]++;
                        arr[1][0]++;
                        arr[2][0]++;
                        arr[1][1]++;
                        break;
                    case 4:
                        arr[0][1]++;
                        arr[1][0]++;
                        arr[1][1]++;
                        arr[1][2]++;
                        arr[2][1]++;
                        break;
                    case 5:
                        arr[0][2]++;
                        arr[1][1]++;
                        arr[1][2]++;
                        arr[2][2]++;
                        break;
                    case 6:
                        arr[1][0]++;
                        arr[2][0]++;
                        arr[2][1]++;
                        break;
                    case 7:
                        arr[1][1]++;
                        arr[2][0]++;
                        arr[2][1]++;
                        arr[2][2]++;
                        break;
                    case 8:
                        arr[1][2]++;
                        arr[2][1]++;
                        arr[2][2]++;
                        break;

                }

            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((arr[i][j] % 2) != 0) return Integer.MAX_VALUE;
            }
        }

        return  count;
    }

}

