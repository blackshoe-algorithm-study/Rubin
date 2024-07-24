package july_week3;

import java.io.*;
import java.util.*;
public class 플로이드 {
    static int N, M;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dist = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            dist[start][end] = Math.min(weight, dist[start][end]);
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
//                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
//                        dist[i][j] = dist[i][k] + dist[k][j];
//                    }
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dist[i][j] = dist[i][j] == INF ? 0 : dist[i][j];
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
