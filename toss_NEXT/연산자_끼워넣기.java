package toss_NEXT;

import java.io.*;
import java.util.*;

public class 연산자_끼워넣기 {
    static int MAX;
    static int MIN;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //수 고정, 연산자 끼워 넣기.

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N];

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] y = new int[4];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            y[i] = Integer.parseInt(st.nextToken());
        }
        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;

        dfs_14888(1, y, num, num[0]);

        bw.write(MAX + "\n");
        bw.write(MIN + "\n");
        bw.flush();

    }

    static void dfs_14888(int depth, int[] y, int[] num, int subResult){

        if(depth == num.length){

            MAX = Math.max(MAX, subResult);
            MIN = Math.min(MIN, subResult);

            return;
        }

        for(int i = 0; i < 4; i++){
            if(y[i] == 0) continue;
            y[i]--;
            switch(i) {
                case 0:
                    dfs_14888(depth+1, y, num, subResult + num[depth]);
                    break;
                case 1:
                    dfs_14888(depth+1, y, num, subResult - num[depth]);
                    break;
                case 2:
                    dfs_14888(depth+1, y, num, subResult * num[depth]);
                    break;
                case 3:
                    dfs_14888(depth+1, y, num, subResult / num[depth]);
                    break;
            }
            y[i]++;
        }
    }
}
