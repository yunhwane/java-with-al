package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
백준 1926 그림 문제
1. 그림 개수와 그림 중에 넓이가 가장 넓은 것을 출력
2. 1로 연결된 것이 그림임
3. 대각선은 떨어진 그림

*/

public class Boj1926 {
    static int n, m;
    static int[][] graph;
    static boolean[][] isVisited;
    static int count = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int area;
    static int max = 0;
    static Queue<Pair> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        isVisited = new boolean[n][m];


        /*
        배열값 set
        */
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k<n;k++){
            for(int l = 0; l < m;l++){
                if(graph[k][l]==1 && !isVisited[k][l]) bfs(k,l);
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
    public static void bfs(int x, int y){
        qu.offer(new Pair(x,y));
        isVisited[x][y] = true;
        area = 0;
        count++;
        while(!qu.isEmpty()){
            Pair p = qu.poll();
            area++;
            for(int i = 0; i < 4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (isVisited[nx][ny] || graph[nx][ny] == 0) {
                    continue;
                }
                isVisited[nx][ny] = true;
                qu.offer(new Pair(nx,ny));
            }
        }
        if(area > max){
            max = area;
        }
    }
    public static class Pair{
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
