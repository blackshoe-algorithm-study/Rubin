package self_practice.Dijkstra;

import java.io.*;
import java.util.*;
public class 최단경로 {
    static int V, E;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[index].add(new Node(to, cost));
        }

        int[] dist = Dijkstra(start);

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        bw.flush();
    }

    public static int[] Dijkstra(int start){
        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(visited[curr.index]) continue;

            visited[curr.index] = true;

            for(Node adjNode : graph[curr.index]){
                if(!visited[adjNode.index] && dist[adjNode.index] > dist[curr.index] + adjNode.cost){
                    dist[adjNode.index] = dist[curr.index] + adjNode.cost;
                    pq.offer(new Node(adjNode.index, dist[adjNode.index]));
                }
            }
        }

        return dist;
    }
}

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node others){
        return Integer.compare(this.cost, others.cost);
    }
}
