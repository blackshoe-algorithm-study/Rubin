package may_week3;

import java.io.*;
import java.util.*;

public class 절댓값_힙 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ = new PriorityQueue<>(N);
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(N, Collections.reverseOrder());
        for(int i = 0; i < N; i++){
            int next = Integer.parseInt(br.readLine());

            if(next < 0) // 음수면
                maxQ.offer(next); // 최대힙에
            else if(next > 0) // 양수면
                minQ.offer(next); // 최소힙에
            else { // 0 입력됐고
                if(maxQ.isEmpty() && minQ.isEmpty()) //둘 다 비어있으면
                    bw.write(0 + "\n"); // 0 출력
                else if(maxQ.isEmpty()) // 음수 힙이 비어있으면
                    bw.write(minQ.poll() + "\n"); // 양수 힙 출력
                else if(minQ.isEmpty()) // 양수 힙이 비어있으면
                    bw.write(maxQ.poll() + "\n"); // 음수 힙 출력
                else { //둘 다 값이 있으면 비교
                    if(minQ.peek() > (maxQ.peek() * (-1)) ) {
                        bw.write(maxQ.poll() + "\n");
                    }else if(minQ.peek() < (maxQ.peek() * (-1))){
                        bw.write(minQ.poll() + "\n");
                    }else { //둘이 같으면 음수힙에서 빼기
                        bw.write(maxQ.poll() + "\n");
                    }
                }
            }
        }

        bw.flush();
    }
}
