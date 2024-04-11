package april_week2;
import java.util.*;
import java.io.*;
public class DFS와BFS {
    static ArrayList<ArrayList<Integer>> graph;
    static Deque<Integer> q;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(w);
            graph.get(w).add(u);
        }

        for(int i = 0; i <= n; i++){
            Collections.sort(graph.get(i));
        }

        boolean[] isVisited = new boolean[n+1];

        Arrays.fill(isVisited, false);
        DFS(v, isVisited);
        Arrays.fill(isVisited, false);
        BFS(v, isVisited);

        bw.write(dfsResult.toString().trim() + "\n");
        bw.write(bfsResult.toString().trim() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    static void DFS(int startIdx, boolean[] isVisited){
        ArrayList<Integer> connectedNodes = graph.get(startIdx);
        isVisited[startIdx] = true;

        dfsResult.append(startIdx).append(" ");

        for(int v : connectedNodes){
            if(!isVisited[v])
                DFS(v, isVisited);
        }
    }

    static void BFS(int startIdx, boolean[] isVisited){
        q = new ArrayDeque<>();
        isVisited[startIdx] = true;
        q.offer(startIdx);

        while(!q.isEmpty()){
            int start = q.poll();
            bfsResult.append(start).append(" ");

            for(int v : graph.get(start)){
                if(!isVisited[v]) {
                    isVisited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

}

