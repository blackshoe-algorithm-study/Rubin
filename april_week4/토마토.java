package april_week4;

import java.io.*;
import java.util.*;

public class 토마토 {
    static int[][] map;
    static int zeroCount = 0;
    static Deque<Node> q;
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1]; // 행열

        for(int i=0; i<N+1; i++){
            Arrays.fill(map[i], -1);
        }
        q = new ArrayDeque<>();

        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<M+1; j++){
                int next = Integer.parseInt(st.nextToken());
                if(next == 0) zeroCount++;
                else if(next == 1) q.addLast(new Node(i, j));
                map[i][j] = next;
            }
        }

        bw.write(BFS(N, M)+"\n");
        bw.flush();
    }
    public static int BFS(int N, int M){
        if(zeroCount == 0) return 0;
        int day = 0;

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0; i<size; i++){
                Node now = q.removeFirst();
                for(int j=0; j<4; j++){
                    int nRow = now.row + dRow[j];
                    int nCol = now.col + dCol[j];
                    if(nRow<=N && nRow>0 && nCol<=M && nCol>0){
                        if(map[nRow][nCol] == 0) {
                            q.addLast(new Node(nRow, nCol));
                            map[nRow][nCol] = 1;
                            zeroCount--;
                        }
                    }
                }
            }
            day++;
        }
        return zeroCount==0 ? day-1 : -1;
    }
}

class Node{
    int row, col;
    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
