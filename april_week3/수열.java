package april_week3;

import java.io.*;
import java.util.*;

public class 수열 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());

        List<Integer> arraylist = new ArrayList<>(size);
        PriorityQueue<Integer> q = new PriorityQueue<>(size);

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++){
            arraylist.add(Integer.parseInt(st.nextToken()));
        }
        int max = 0;
        //j = i+1; j < block;
        //j가 size에 도달 시 break;
        boolean flag = false;

        for(int i = 0; i < size; i++){
            if(flag) break;
            int sum = 0;

            for(int j = i; j < i+block; j++){
                if(j == size-1) {
                    flag = true;
                    break;
                }
                sum += arraylist.get(j);
            }
            
            max = Math.max(sum, max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();

        br.close();
    }
}
