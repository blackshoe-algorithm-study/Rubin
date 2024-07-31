package self_practice;
import java.io.*;
import java.util.*;
public class 케빈_베이컨의_6단계_법칙 {
    static int N, M;
    static int[][] dist;
    static int INF;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 관계 수

        dist = new int[N][N];
        INF = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            dist[start][end] = 1;
            dist[end][start] = 1;
        }
        floydWarshall();
        int minSum = Integer.MAX_VALUE;
        int result = 0;

        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                sum += dist[i][j];
            }
            if(sum < minSum){
                result = i + 1;
                minSum = sum;
            }
        }


        bw.write(result + "\n");
        bw.flush();

    }

    static void floydWarshall(){
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
