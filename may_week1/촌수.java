package may_week1;
import java.io.*;
import java.util.*;

/*
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */
public class 촌수 {
    static ArrayList<LinkedList<Integer>> adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++){
            adjList.add(new LinkedList<>());
        }

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }

        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        int result = 0;
        result += DFS(start, target, visited, 0);
        if(result == 0) result = -1;

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }

    public static int DFS(int start, int target, boolean[] visited, int chon){

        visited[start] = true;

        for(int v : adjList.get(start)){
            if(v == target) return chon;
            else if(!visited[v]) DFS(v, target, visited, chon+1);
        }

        return chon;
    }

//    public static int BFS(int start, int target, Deque<Integer> q, boolean[] visited, ArrayList<LinkedList<Integer>> adjList){
//
//        q.offer(start);
//        visited[start] = true;
//        int chon = 1;
//        //
//
//        //1 : 2 3 4
//        //2 : 1 3
//        //3 : 1 2 5
//
//        while(!q.isEmpty()){
//            int v = q.poll();
//
//            for(int current : adjList.get(v)){
//                if(!visited[current]) {
//                    q.offer(current);
//
//                    if(current == target) return chon;
//                }
//            }
//            chon++;
//        }
//
//        return -1;
//    }
}
