package march_week4;

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class 프린터_큐 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> ranks;
        Deque<Integer> q;

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(t-->0){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int targetIdx = Integer.parseInt(st.nextToken());

            String[] brReadLine = br.readLine().split(" ");

            ranks = new PriorityQueue<>(Collections.reverseOrder());

            ranks.addAll(Stream.of(brReadLine)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));


            q = Stream.of(brReadLine)
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayDeque::new));

            int rank = 1;
            while(!q.isEmpty() && !ranks.isEmpty()){

                //주어진 q에서 첫번째 요소 제거
                int num = q.remove();

                //만약 첫 번째 요소가 우선순위가 제일 높다면
                if (num == ranks.peek()){

                    if(targetIdx == 0){

                        bw.write(rank+"\n");
                        break;
                    }

                    //우선순위 제일 높은 것 제거, 자동으로 최대 heapify됨
                    ranks.remove();
                    rank++;
                }

                //다시 맨 뒤에 삽입
                q.addLast(num);

                targetIdx--;
                if (targetIdx < 0) {
                    targetIdx = q.size() - 1;
                }

            }
        }
        bw.flush();
    }
}
