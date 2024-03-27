package march_week4;

import java.util.*;
import java.io.*;
public class 최소_힙 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){

            int num = Integer.parseInt(br.readLine());

            if(num == 0 && minHeap.isEmpty())
                bw.write("0\n");
            else if(num == 0)
                bw.write(String.valueOf(minHeap.remove())+"\n");
            else
                minHeap.add(num);
        }
        bw.flush();
    }
}
