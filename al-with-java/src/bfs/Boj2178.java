package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visit;
    static Queue<pair> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];


        for(int i = 0; i < N;i++){
            String str = br.readLine();
            char[] ch = str.toCharArray();

            for(int j = 0;j < ch.length;j++){
                map[i][j] = Character.getNumericValue(ch[j]);
            }
        }

        bfs(0,0);
        visit[0][0] = true;

        System.out.println(map[N-1][M-1]);

    }
    public static void bfs(int x, int y){
        qu.offer(new pair(x,y));

        while(! qu.isEmpty()) {
            pair p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visit[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                qu.offer(new pair(nx, ny));
                visit[nx][ny] = true;
                map[nx][ny] = map[p.x][p.y] + 1;
            }
        }
    }
    public static class pair{
        private int x;
        private int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
