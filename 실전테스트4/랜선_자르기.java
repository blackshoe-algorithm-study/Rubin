package 실전테스트4;
import java.io.*;
import java.util.*;
public class 랜선_자르기 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //정해진 것 : 잘라진 랜선 총 갯수보다 커야하며, 자를 수 있는 최대 길이

        // 1. 랜선을 다 자른 뒤 N보다 커야함
        // 2. 자른 각각의 랜선 길이는 최대여야함.
        // -> 자른 각각의 랜선 길이가 최대가 되도록 하며 자른 갯수가 N보다 큰 답을 출력
        // -> 브루트포스, 모든 경우의 수

        /*
        4 11
802
743
457
539
         */

        int K, N;
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int div = 1;

        int max = Integer.MIN_VALUE;

        //count = 막대 갯수
        //div = 막대 나누는 수

        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        while(true) {
            int chunk = 0;
            div++;
            boolean cFlag = false;

            for(int i = 0; i < K; i++){
                chunk += arr[i]/div;

                if(chunk >= N && i < K-1) {
                    //System.out.println("chunk :" + chunk + " i : " + i);
                    cFlag = true;
                    break;
                }
            }
            if(cFlag) continue;

            if(chunk >= N){
                max = Math.max(max, div);
            } else if(chunk < N && max < div){
              break;
            }

        }
        bw.write(max + "\n");
        bw.flush();
    }
}
