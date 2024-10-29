package October_29;
import java.io.*;
import java.util.*;
public class 트리의_부모_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] parent = new int[n];

        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[n];
        StringTokenizer st;
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adj[a].add(b);
            adj[b].add(a);
        }

        Deque<Integer> q = new ArrayDeque<>();

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : adj[curr]){
                if(visited[next]) continue;

                visited[next] = true;
                q.add(next);

                parent[next] = curr;
            }
        }
        for(int i = 1; i<n; i++){
            bw.write(parent[i]+1 + "\n");
        }

        bw.flush();
    }
}
