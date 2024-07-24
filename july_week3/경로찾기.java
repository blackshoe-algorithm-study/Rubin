package july_week3;

import java.io.*;
import java.util.*;
public class 경로찾기 {
    static int N;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dist = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int n = Integer.parseInt(st.nextToken());

                dist[i][j] = n;
            }
            dist[i][i] = 0;
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }

            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();

    }
}
