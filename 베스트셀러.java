import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

        System.out.println(hashMap);

    }
}
