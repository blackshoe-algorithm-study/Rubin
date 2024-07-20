package self_practice.DP;
import java.io.*;
import java.util.*;
public class _1로만들기 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int X = 2; X <= N; X++){
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c;
            if(X%3 == 0 && X >= 3)
                a = dp[X/3] + 1;
            if(X%2 == 0 && X >= 2)
                b = dp[X/2] + 1;
            c = dp[X-1] + 1;

            dp[X] = Math.min(Math.min(a,b), c);
        }

        bw.write(dp[N] - 1 + "\n");
        bw.flush();
    }
}
