package march_week4;

import java.util.*;
import java.io.*;
public class 최대_힙 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int t = Integer.parseInt(br.readLine());
        while(t-->0){

            int num = Integer.parseInt(br.readLine());

            if(num == 0 && maxHeap.isEmpty())
                bw.write("0\n");
            else if(num == 0)
                bw.write(String.valueOf(maxHeap.remove())+"\n");
            else
                maxHeap.add(num);
        }
        bw.flush();
    }
}
