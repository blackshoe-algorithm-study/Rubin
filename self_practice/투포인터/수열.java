package self_practice.투포인터;
import java.io.*;
import java.util.*;

public class 수열 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = K - 1;

        int partialSum = Integer.MIN_VALUE;
        int sum;
        while(right < N){
            sum = 0;
            for(int i = left; i <= right; i++){
                sum += nums[i];
            }
            partialSum = Math.max(sum, partialSum);

            left++;
            right++;
        }

        bw.write(partialSum + "\n");
        bw.flush();
    }
}
