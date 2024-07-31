package 실전테스트4;
import java.io.*;
import java.util.*;
public class 나는야_포켓몬_마스터_이다솜 {
    public static void main(String[]args) throws IOException{
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, String> pocketmonMap = new HashMap<>(N);
        Map<String, String> numberMap = new HashMap<>(N);
        for(int i = 0; i < N; i++){
            String pocketmon = br.readLine();
            pocketmonMap.put(pocketmon, String.valueOf(i+1));
            numberMap.put(String.valueOf(i+1), pocketmon);
        }

        for(int i = 0; i < M; i++){
            String key = br.readLine();

            String result = pocketmonMap.getOrDefault(key, String.valueOf(-1));
            if(result.equals("-1")){
                result = numberMap.getOrDefault(key, String.valueOf(-1));
            }
            bw.write(result+"\n");
        }

        bw.flush();
    }
}
