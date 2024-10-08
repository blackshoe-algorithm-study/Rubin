package October_08;

import java.io.*;
import java.util.*;

public class 쿼드트리 {
    static StringBuilder sb;
    static char[][] originMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        originMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                originMap[i][j] = line.charAt(j);
            }
        }

        recursion(0, 0, N);

        bw.write(sb.toString() + "\n");
        bw.flush();
    }

    static void recursion(int startRow, int startCol, int N){
        if (N==1 || isAllSame(startRow, startCol, N)){
            sb.append(originMap[startRow][startCol]);
            return;
        }

        sb.append("(");

        int halfN = N / 2;
        recursion(startRow, startCol, halfN); //row : 0-3 col : 0-3 왼쪽위
        recursion(startRow, startCol + halfN, halfN); //row : 0-3 col : 4-7 오른쪽위
        recursion(startRow + halfN, startCol, halfN); // row : 4-7 col : 0-3 왼쪽아래
        recursion(startRow + halfN, startCol + halfN, halfN); // 오른쪽 아래

        sb.append(")");
    }

    static boolean isAllSame(int startRow, int startCol, int N){
        char startChar = originMap[startRow][startCol];
        for (int i = startRow; i < startRow + N; i++) {
            for (int j = startCol; j < startCol + N; j++){
                if(originMap[i][j] != startChar){
                    return false;
                }
            }
        }
        return true;
    }

}