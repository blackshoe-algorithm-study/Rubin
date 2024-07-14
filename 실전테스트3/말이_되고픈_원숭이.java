package 실전테스트3;

import java.io.*;
import java.util.StringTokenizer;

public class 말이_되고픈_원숭이 {
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    static int[] dHolseRow = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dHolseCol = {-2, -1, 1, 2, -2, -1, 1, 2};

    static int arriveRow, arriveCol;
    static int holseMove;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        holseMove = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arriveRow = Integer.parseInt(st.nextToken()) + 1;
        arriveCol = Integer.parseInt(st.nextToken()) + 1;
        map = new int[arriveRow][arriveCol];

        DFS(0, 0);


    }

    static void DFS(int row, int col){
        //끝에 도착하거나 더이상 움직이지 못할 시
        if(row == arriveRow && col == arriveCol){
            
        }
    }
}
