package self_practice.DP;

import java.io.*;
import java.util.*;
public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp[1][0] = Integer.parseInt(st.nextToken());
        dp[1][1] = Integer.parseInt(st.nextToken());
        dp[1][2] = Integer.parseInt(st.nextToken());

        for(int X = 2; X <= N; X++){
            st = new StringTokenizer(br.readLine());

            dp[X][0] = Math.min(dp[X-1][1], dp[X-1][2]) + Integer.parseInt(st.nextToken());
            dp[X][1] = Math.min(dp[X-1][0], dp[X-1][2]) + Integer.parseInt(st.nextToken());
            dp[X][2] = Math.min(dp[X-1][0], dp[X-1][1]) + Integer.parseInt(st.nextToken());

        }

        int min = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);

        bw.write(min + "\n");
        bw.flush();
    }
}
