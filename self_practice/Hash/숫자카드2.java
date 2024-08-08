package self_practice.Hash;

import java.io.*;
import java.util.*;

public class 숫자카드2 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, M;
        N = Integer.parseInt(br.readLine());
        Map<String, Integer> hashMap = new HashMap<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String currCard = st.nextToken();
            int count = hashMap.getOrDefault(currCard, 0);
            hashMap.put(currCard, count+1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            String currCard = st.nextToken();
            bw.write(hashMap.getOrDefault(currCard, 0)+ " ");
        }
        bw.flush();

    }
}
