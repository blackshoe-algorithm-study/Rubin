package algorithm;
import java.io.*;
import java.util.*;
class 단방향_다익스트라 {
    static ArrayList<Node>[] graph; //int[] graph -> ArrayList<Node>[] graph라고 생각하면 됨. v번째에 Node들을 ArrayList 형태로 넣는다.

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //n : vertex, 정점의 갯수, m : edge, 간선의 갯수
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        int start = Integer.parseInt(br.readLine());

        Dijkstra(n, start);
    }

    public static void Dijkstra(int n, int start){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int nowVertexIdx = pq.poll().idx;

            if(visited[nowVertexIdx]) continue;
            visited[nowVertexIdx] = true;

            for(Node next : graph[nowVertexIdx]) {
                if(dist[next.idx] > dist[nowVertexIdx] + next.cost){
                    dist[next.idx] = dist[nowVertexIdx] + next.cost;

                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        for(int i : dist){
            if(i == INF) System.out.print(0 + " ");
            else System.out.print(i + " ");
        }
    }
}

class Node implements Comparable<Node>{
    int idx;
    int cost;

    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other){
        return Integer.compare(this.cost, other.cost);
    }
}

/*
입력
5
9
1 2 10
1 3 5
2 3 2
3 1 1
3 2 13
4 1 8
4 5 3
5 4 9
5 2 31
4 3

출력 결과
0 8 18 13 0 3 //인덱스 0은 사용 x
 */