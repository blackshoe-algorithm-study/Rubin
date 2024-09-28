package toss_NEXT;

import java.io.*;
import java.util.*;

public class 카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lines = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < lines; i++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int tX = Integer.parseInt(st.nextToken());
            int tY = Integer.parseInt(st.nextToken());

            int subResult = solution(M, N, tX, tY);
            bw.write(subResult + "\n");
        }
        bw.flush();
    }

    static int solution(int M, int N, int tX, int tY){
        int x = 1;
        int y = 1;
        int cycle = 1;

        while(cycle <= M * N){
            if(x == tX && y == tY) return cycle;

            if(x < M) {
                x++;
            } else{
                x=1;
            }
            if(y < N){
                y++;
            }else{
                y=1;
            }

            cycle++;
        }
        return -1;
    }
}
