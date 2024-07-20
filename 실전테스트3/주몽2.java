package 실전테스트3;

import java.io.*;
import java.util.*;
public class 주몽2 {
    static int N, M, sol;
    static int[] m;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        m = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            m[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(m);

        sol = 0;
        int left = 0;
        int right = N-1;
        while(left < right){
            int sum = m[left] + m[right];
            if(sum == M){
                sol++;
                left++;
                right--;
            }else if(sum < M){
                left++;
            }else{
                right--;
            }
        }
        bw.write(String.valueOf(sol));
        bw.flush();
    }

}
