package October_08;

import java.io.*;
import java.util.*;

public class 파일_정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> treeMap  = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String file = st.nextToken();
            String expander = st.nextToken();

            int cnt = treeMap.getOrDefault(expander, 0) + 1;
            treeMap.put(expander, cnt);

        }

        for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.flush();
    }
}
