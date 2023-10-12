package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
2023-10-12

백준 2606 바이러스

1. 시작 번호가 정해짐 1번
2. 시작 번호에 따라 Queue 인접 행렬 처리
3. 인접 행렬 값을 1로 설정하고, 1이고 방문하지 않았으면 queue에 담고 count
*/
public class Boj2606 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[] visit;
    static Queue<Integer> qu = new LinkedList<>();
    private static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[101][101];
        visit = new boolean[101];


        StringTokenizer st;
        for(int i = 0; i < m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        bfs(1);
        System.out.println(count);

    }

    public static void bfs(int start) {
        visit[start] = true;
        qu.offer(start);
        while ( !qu.isEmpty() ){
            int node = qu.poll();

            for(int i = 1; i<n+1;i++){
                if(map[node][i]==1 && !visit[i]){
                    qu.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
    }
}