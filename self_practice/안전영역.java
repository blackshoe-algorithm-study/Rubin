package self_practice;

import java.io.*;
import java.util.*;

public class 안전영역 {
    static int[][] map;
    static boolean[][] visited;
    static int N, maxSafeZone, rain;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int maxHeight = 0;
        visited = new boolean[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        maxSafeZone = 1;
        for(rain = 0; rain < maxHeight; rain++){
            int safeZone = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && map[i][j] > rain){
                        bfs(i, j, rain);
                        safeZone++;
                    }
                }
            }
            maxSafeZone = Math.max(safeZone, maxSafeZone);
        }

        bw.write(maxSafeZone + "\n");
        bw.flush();
        bw.close();

    }
    static void bfs(int row, int col, int rain){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!deque.isEmpty()){
            int[] current = deque.poll();
            for(int i = 0; i < 4; i++){
                int cRow = current[0] + dRow[i];
                int cCol = current[1] + dCol[i];

                if(validate(cRow, cCol, rain)){
                    deque.offer(new int[]{cRow, cCol});
                    visited[cRow][cCol] = true;
                }

            }
        }
    }

    static boolean validate(int row, int col, int rain){
        return row>=0 && row<N && col>=0 && col<N && !visited[row][col] && map[row][col] > rain;
    }
}
