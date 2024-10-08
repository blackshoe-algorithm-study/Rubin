package toss_NEXT;

import java.io.*;
import java.util.*;

public class 로봇_청소기 {
    static int[][] MAP;
    static int R, C, D;
    // 북, 동, 남, 서
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        MAP = new int[R][C];

        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(clean(startRow, startCol) + "\n");
        bw.flush();
    }

    static int clean(int row, int col) {
        int cnt = 0;

        if (MAP[row][col] == 0) {
            MAP[row][col] = 2;
            cnt++;
        }

        int origin = D;

        for (int i = 0; i < 4; i++) { // 현재 칸의 주변 4칸 확인
            D = (D + 3) % 4; // 반시계 방향으로 90도 회전
            int nRow = row + dRow[D];
            int nCol = col + dCol[D];

            if (nRow >= 0 && nRow < R && nCol >= 0 && nCol < C) {
                if (MAP[nRow][nCol] == 0) { // 청소할 공간 발견
                    cnt += clean(nRow, nCol); // 청소하고 다시 탐색
                    return cnt;
                }
            }
        }

        // 네 방향 모두 청소가 이미 되어있거나 벽인 경우
        int back = (D + 2) % 4; // 바라보는 방향에서 뒤쪽 방향 계산
        int bRow = row + dRow[back];
        int bCol = col + dCol[back];
        if (bRow >= 0 && bRow < R && bCol >= 0 && bCol < C) {
            if (MAP[bRow][bCol] != 1) { // 후진할 곳이 벽이 아닌 경우
                cnt += clean(bRow, bCol); // 후진하여 다시 탐색
            }
        }

        return cnt;
    }
}