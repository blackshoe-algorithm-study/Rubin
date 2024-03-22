package march_week3;

import java.io.*;
import java.util.*;

public class ATM {
    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int times = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < times; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        List<Integer> sum = new ArrayList<>();
        int temp = 0;

        sum.add(list.get(0));

        for(int j = 1; j < times; j++) {
            temp = list.get(j);
            sum.add(temp + sum.get(j-1));
        }

        int solution = 0;

        for(int k = 0; k < times; k++){
            solution += sum.get(k);
        }
        bw.write(String.valueOf(solution));
        bw.flush();
    }
}
