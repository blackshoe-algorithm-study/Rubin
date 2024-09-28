package Sep_24;
import java.io.*;
import java.util.*;

public class 오르막수 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[10][N+1];

        for(int i = 0; i < 10; i++) {
            dp[i][1] = 1;
        }

        for(int i = 2; i < N+1; i++){
            for(int j = 0; j < 10; j++){
                if(j==0) dp[j][i] = dp[j][i-1];
                else dp[j][i] = (dp[j][i-1] + dp[j-1][i]) % 10007;
            }
        }
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum = (sum + dp[i][N]) % 10007;
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}
