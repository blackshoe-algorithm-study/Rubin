package april_week3;

import java.io.IOException;
import java.io.*;
import java.util.*;
public class 배열_합치기 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        int T = sizeA + sizeB;

        PriorityQueue<Integer> q = new PriorityQueue<>(T);

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        for(int i = 0; i < sizeA; i++)
            q.add(Integer.parseInt(st2.nextToken()));

        for(int i = 0; i < sizeB; i++)
            q.add(Integer.parseInt(st3.nextToken()));


        for(int i = 0; i < T; i++)
            bw.write(q.remove()+ " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
