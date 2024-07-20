package self_practice;
import java.io.*;
import java.util.*;
public class 바이러스 {

    static Node[] graph;
    static int N, M, sol;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N <= 100
        N = Integer.parseInt(br.readLine());
        graph = new Node[N];

        for(int i = 0; i < N; i++){
            graph[i] = new Node(i, false);
        }

        //M
        M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int firstNodeIdx = Integer.parseInt(st.nextToken());
            int secondNodeIdx = Integer.parseInt(st.nextToken());
            Node firstNode = graph[firstNodeIdx-1];
            Node secondNode = graph[secondNodeIdx-1];

            firstNode.adjList.add(secondNode);
            secondNode.adjList.add(firstNode);

        }

        DFS(0);
        bw.write(sol-1+"\n");
        bw.flush();
    }
    static void DFS(int start){
        //먼저 출력한다.
        Node currentNode = graph[start];

        if(currentNode.visited) return;
        currentNode.visited = true;

        sol++;
        for (Node adjNode : currentNode.adjList) {
            DFS(adjNode.idx);
        }
    }
}
class Node{
    int idx;
    boolean visited;
    ArrayList<Node> adjList;

    public Node(int idx, boolean visited){
        this.idx = idx;
        this.visited = visited;
        adjList = new ArrayList<>();
    }
}
/*
7
7
1 2
2 3
1 5
5 2
5 6
4 7
3 4
 */