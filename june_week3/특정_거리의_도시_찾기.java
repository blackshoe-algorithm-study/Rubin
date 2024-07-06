package june_week3;

import java.io.*;
import java.util.*;

public class 특정_거리의_도시_찾기 {
    static ArrayList<Integer>[] graph;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        //@TODO: ArrayList<Integer>[] graph 초기화 방법 기억할것.
        graph = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }

        ArrayList<Integer> answer = BFS(X, K, N);
        if(answer.size() == 0) bw.write("-1\n");
        else {
            Collections.sort(answer);
            for (int sol : answer) {
                bw.write(sol + "\n");
            }
        }
        bw.flush();
    }

    public static ArrayList<Integer> BFS(int start, int K, int N){
        ArrayList<Integer> answer = new ArrayList<>();

        Deque<Integer> q = new ArrayDeque<>();
        int[] distance = new int[N+1];
        Arrays.fill(distance, -1);

        q.addLast(start);
        distance[start] = 0;

        while(!q.isEmpty()){
            int now = q.removeFirst();

            if(distance[now] == K) {
                answer.add(now);
                continue;
            }

            for(int v : graph[now]){
                if(distance[v] == -1){
                    q.addLast(v);
                    distance[v] = distance[now] + 1;
                }
            }
        }


        return answer;
    }
}
