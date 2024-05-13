package may_week3;

import java.io.*;
import java.util.*;
public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //최소 + 최소(poll) = 최소2
        //최소2 + 최소(poll) = 최소3
        //최소3 + 최소(poll) = 최소4 반복
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQ = new PriorityQueue<>(N);

        for(int i = 0; i < N; i++){
            minQ.offer(Integer.parseInt(br.readLine()));
        }

        int result = minQ.poll();
        int tmp = 0;

        for(int i = 0; i < N-1; i++){
            int num = minQ.poll();
            //System.out.println("num : " + num);

            int tmp2 = tmp + num;
            //System.out.println("tmp2 : " + tmp2);

            result += tmp + num; // 20 + (20 + 20)
            //System.out.println("result : " + result);

            if(i != 0)
                tmp = result - tmp2; // 20
            else
                tmp = result;
            //System.out.println("tmp : " + tmp);
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
//(10 + 10) + (20 + 10) + (30 + 10) + (40 + 10)
