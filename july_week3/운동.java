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
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
//        for(int i = 0; i < N;i++){
//            System.out.println(Arrays.toString(dist[i]));
//        }
        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(dist[i][j] != INF && dist[j][i] != INF && i != j)
                    minSum = Math.min(dist[i][j] + dist[j][i], minSum);
            }
        }
        if(minSum == INF) bw.write(-1 + "\n");
        else bw.write(minSum + "\n");
        bw.flush();

    }
}
