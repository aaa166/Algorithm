import java.io.*;
import java.util.*;

public class Main {

    static int[][] map = new int[501][501];
    static int[][] dist = new int[501][501];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i <= 500; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int x=Math.min(x1,x2);x<=Math.max(x1,x2);x++)
                for(int y=Math.min(y1,y2);y<=Math.max(y1,y2);y++)
                    map[x][y]=1;
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int x=Math.min(x1,x2);x<=Math.max(x1,x2);x++)
                for(int y=Math.min(y1,y2);y<=Math.max(y1,y2);y++)
                    map[x][y]=2;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;

        while(!pq.isEmpty()){

            int[] cur = pq.poll();
            int x=cur[0];
            int y=cur[1];
            int cost=cur[2];

            if(x==500 && y==500){
                System.out.println(cost);
                return;
            }

            for(int d=0;d<4;d++){
                int nx=x+dx[d];
                int ny=y+dy[d];

                if(nx<0||ny<0||nx>500||ny>500) continue;
                if(map[nx][ny]==2) continue;

                int ncost = cost + map[nx][ny];

                if(dist[nx][ny] > ncost){
                    dist[nx][ny] = ncost;
                    pq.add(new int[]{nx,ny,ncost});
                }
            }
        }

        System.out.println(-1);
    }
}