package may_week3;

import java.io.*;
import java.util.*;
public class N번째큰수 {

    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int T = N*N;

        PriorityQueue<Integer> maxQ = new PriorityQueue<>(T, Collections.reverseOrder());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
                maxQ.offer(Integer.parseInt(st.nextToken()));
        }
        int result = 0;
        for(int i = 0; i < N; i++){
            result = maxQ.poll();
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
