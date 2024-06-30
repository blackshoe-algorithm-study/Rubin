package june_week4;

import java.io.*;
import java.util.*;
public class 설탕_배달 {
    static int cnt;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        solution(N);


        bw.write(cnt + "\n");
        bw.flush();
    }

    static void solution(int N){
        //int[] kg = {3, 5};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int quote = N/5; //N을 5로 나눈 몫

        for(int i = 0; i < quote + 1; i++){
            //현재 5kg 쓴 갯수 : i
            int node = INF;
            int newN = N - (5 * i);
            System.out.println("newN : " + newN);
            if(newN%3 == 0){
                node = i + (newN/3);
            }
            System.out.println("node : " + node);
            pq.add(node);
        }
        System.out.println(Arrays.toString(pq.toArray()));
        if (pq.peek() == INF) cnt = -1;
        else cnt = pq.poll();
    }
}
