package 실전테스트5;

import java.io.*;
import java.util.*;
public class 타임머신 {

    static ArrayList<Node>[] graph;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            Node node = new Node(to, dist);
            graph[from].add(node);
        }
        int[][] results = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            results[i] = Dijkstra(i);
        }


        for(int i = 2; i <= N; i++){
            if (Long.valueOf(results[1][i]) + Long.valueOf(results[i][1]) < 0L) {
                System.out.println("-1\n");
                return;
            } else {
                if (results[1][i] == Integer.MAX_VALUE) bw.write("-1\n");
                else bw.write(results[1][i] + "\n");
            }
        }
        bw.flush();

    }

    static int[] Dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.add(new Node(start, dist[start]));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(visited[curr.idx]) continue;
            visited[curr.idx] = true;

            for(Node adjNode : graph[curr.idx]){
                //if(adjNode.dist >= 0) {
                if (dist[adjNode.idx] > dist[curr.idx] + adjNode.dist) {
                    dist[adjNode.idx] = dist[curr.idx] + adjNode.dist;
                    pq.offer(adjNode);
                }
                //}
//                else if(adjNode.dist < 0){
//                    //DFS 돌면서 다시 1번째로 돌아갈 수 있으면 -1
//                    Deque<Node> stack = new ArrayDeque<>();
//                    stack.push(adjNode);
//                    boolean[] visited2 = new boolean[N+1];
//
//                    while(!stack.isEmpty()){
//                        Node curr2 = stack.pop();
//                        if(curr2.idx == 1) return -1;
//                        if(visited[curr2.idx]) continue;
//                        visited[curr2.idx] = true;
//
//                        for(Node adjNode2 : graph[curr2.idx]){
//                            stack.push(adjNode2);
//                        }
//                    }
//                }
            }
        }

        return dist;
    }
}
class Node implements Comparable<Node>{
    int idx;
    int dist;

    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node others){
        return Integer.compare(this.dist, others.dist);
    }
}
