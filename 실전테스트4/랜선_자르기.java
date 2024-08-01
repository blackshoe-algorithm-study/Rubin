package 실전테스트4;
import java.io.*;
import java.util.*;
public class 랜선_자르기 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), base = Integer.parseInt(st.nextToken());

        long max = 0L;
        long[] arr = new long[N];
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i], max);
        }
        long left = 1, right = max;
        long mid;
        long maxLen = 0;

        while(left<=right){
            mid = (left+right)/2;

            long quote, curr = 0;

            for(int i = 0; i < N; i++){
                quote = arr[i]/mid;
                curr += quote;
            }

            if(curr >= base){
                left = mid + 1;
                maxLen = Math.max(maxLen, mid);
            }else if(curr < base){
                right = mid - 1;
            }

        }

        bw.write(maxLen + "\n");
        bw.flush();
    }
}
