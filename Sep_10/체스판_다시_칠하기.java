package Sep_10;

import java.io.*;
import java.util.*;

public class 체스판_다시_칠하기 {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int COUNT = 0;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int minRepaint = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaint = count(map, i, j);
                minRepaint = Math.min(minRepaint, repaint);
            }
        }
        bw.write(minRepaint + "\n");
        bw.flush();
    }
    public static int count(char[][] map, int startRow, int startCol){
        int countW = 0; //왼 상단 White
        int countB = 0; //왼 상단 Black

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i+j) % 2 == 0){
                    if (map[startRow + i][startCol + j] != 'W') countW++;
                    if (map[startRow + i][startCol + j] != 'B') countB++;
                } else{
                    if (map[startRow + i][startCol + j] != 'B') countW++;
                    if (map[startRow + i][startCol + j] != 'W') countB++;
                }
            }
        }

        return Math.min(countW, countB);
    }

    /*
    MN개의 단위 정사각형으로 나누어져있는 M*N 보드
    MN 맵, B혹은 W값을 가짐. 맨 왼쪽 위 칸이 흰색이거나 검은색인 경우.
    보드는 랜덤하게 칠해져있음.
    MN 중 8*8을 아무데서나 골라서 다시 칠해야 하는 정사각형 최소 갯수.
     */
}