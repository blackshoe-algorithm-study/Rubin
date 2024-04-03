package april_week1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 수_찾기 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> hashMap = new HashMap<>();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        st  = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            hashMap.put(st.nextToken(), "v");
        }

        int T = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < T; i++){
            if(hashMap.get(st.nextToken()) != null)
                bw.write("1\n");
            else
                bw.write("0\n");
        }

        bw.flush();
    }
}
