package july_week3;

import java.io.*;
import java.util.*;

public class 운동 {
    static int N, M;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());

            dist[start][end] = weight;
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(dist[i][k] != INF && dist[k][j] != INF)
                        Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(dist[i]));
        }
        int minSum = INF;


        //시작점에서 시작점으로 오는 사이클 계산, 1->2->3->1
        for(int i = 0; i < N; i++){
            int tmpSum = 0;
            for(int j = 0; j < N; j++){

                if(dist[i][j] != INF && dist[i][j] != 0 && dist[j][i] != INF && dist[j][i] != 0) {
                    //System.out.println("i:" + i + ", j:" + j + ", tmp:" + (dist[i][j]+dist[j][i]));
                    tmpSum += (dist[i][j]);
                }
            }
            if(tmpSum != 0)
                minSum = Math.min(minSum, tmpSum);
        }

        if(minSum == INF) bw.write(-1 + "\n");
        else
            bw.write(minSum + "\n");
        bw.flush();
    }

    //완탐을 위한 DFS
    static int DFS(int start, int end, int depth, int sum, boolean[] visited){
        if(depth != 0){
            if(start == end) return sum;
        }
        if(depth == N-1 || visited[start]) return sum;
    }
}
