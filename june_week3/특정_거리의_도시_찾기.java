package june_week3;

import java.io.*;
import java.util.*;

public class 특정_거리의_도시_찾기 {
    static int graph[][];
    static int INF = Integer.MAX_VALUE;
    static int N, M, K, X;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //도시 개수
        M = Integer.parseInt(st.nextToken()); //도로 개수
        K = Integer.parseInt(st.nextToken()); //거리가 K인 도시 번호 한 줄에 하나씩 오름차순 출력
        X = Integer.parseInt(st.nextToken()); //X가 시작점,

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i], INF); //INF : 방향 없음 의미
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int vertex = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            graph[vertex][next] = 1; // 1 : first -> second로 방향 있음

            // 1 -> 2, 2 -> 3에서 1 -> 3으로의 값을 업데이트
            for(int j = 1; j < N+1; j++){
                if(graph[j][vertex] != INF) graph[j][vertex]++;
                else graph[j][vertex] = 1;
            }

//            Node newNode = new Node(vertex, next);
//            q.offer(newNode);


        }

        boolean v[] = new boolean[N+1];
        Arrays.fill(v, false);
        v[X] = true;

        int[] distance = new int[N+1];
        Arrays.fill(distance, 0);

        distance = graph[X];
        int match = 0;

        for(int i = 0; i < N; i++){
            if(distance[i] == K) {
                match++;
                bw.write(i + "\n");
            }
        }
        if(match == 0) bw.write("-1");
        bw.flush();
    }

}
