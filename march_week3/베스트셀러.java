package march_week3;

import java.io.*;
import java.util.*;

public class 베스트셀러 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> hashMap = new HashMap<>();

        int times = Integer.parseInt(br.readLine());

        while(times-->0) {
            String key = br.readLine();

            int value = hashMap.getOrDefault(key, 0);

            hashMap.put(key, ++value);
        }

        List<String> keySetToList = new ArrayList<>(hashMap.keySet());

        Collections.sort(keySetToList, (s1, s2) -> {
           int compare = hashMap.get(s2).compareTo(hashMap.get(s1)); // value 내림차순 정렬
           if(compare == 0) //만약 value가 같다면
               compare = s1.compareTo(s2); //
           return compare;
        });

        bw.write(keySetToList.get(0));
        bw.flush();

    }
}
