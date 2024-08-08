package self_practice.너비와깊이우선탐색;
import java.io.*;
import java.util.*;
public class 촌수 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, start, target, sol = -1;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        graph = new ArrayList[N];

        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken()) - 1;
        target = Integer.parseInt(st.nextToken()) - 1;

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            graph[from].add(to);
            graph[to].add(from);
        }
        DFS(start, 0);
        //BFS(start);
        bw.write(sol + "\n");
        bw.flush();
    }
    static void DFS(int current, int depth){
        if(visited[current]) return;

        if(current == target){
            sol = depth;
            return;
        }
        visited[current] = true;

        for(int Node2 : graph[current]){
            DFS(Node2, depth+1);
        }
    }

    public static void BFS(int start){
        Deque<Node2> q = new ArrayDeque<>();
        q.offer(new Node2(start, 0));

        while(!q.isEmpty()){
            Node2 current = q.poll();

            if(current.idx == target) {
                sol = current.dist;
                return;
            }

            for(int next : graph[current.idx]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new Node2(next, current.dist+1));
                }
            }
        }
    }
}

class Node2{
    int idx;
    int dist;
    public Node2(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
}
