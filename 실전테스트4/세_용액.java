package 실전테스트4;

import java.io.*;
import java.util.*;

public class 세_용액 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[]arr = new long[N];

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long[] sol = new long[3];
        long closestSum = Long.MAX_VALUE;

        for(int i = 0; i < N-2; i++){
            int left = i+1;
            int right = N-1;

            while(left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if(Math.abs(sum) < Math.abs(closestSum)){
                    closestSum = sum;
                    sol[0] = arr[i];
                    sol[1] = arr[left];
                    sol[2] = arr[right];
                }

                if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }else{
                    bw.write(arr[i] + " " + arr[left] + " " + arr[right]);
                    bw.flush();
                    return;
                }
            }
        }

        Arrays.sort(sol);
        for(int i = 0; i < 3; i++){
            bw.write(sol[i] + " ");
        }
        bw.flush();
    }
}