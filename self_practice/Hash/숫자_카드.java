package self_practice.Hash;
import java.io.*;
import java.util.*;

public class 숫자_카드 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, M;
        N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> hash = new HashMap<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            hash.put(Integer.parseInt(st.nextToken()), 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            if(hash.getOrDefault(Integer.parseInt(st.nextToken()), -1) == -1){
                bw.write("0 ");
            }else{
                bw.write("1 ");
            }
        }
        bw.flush();
    }
}
