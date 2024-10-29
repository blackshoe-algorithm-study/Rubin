package October_29;
import java.io.*;
import java.util.*;

public class 가장가까운세사람의심리적거리 {

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            if(n > 32){
                System.out.println(0);
                continue;
            }

            String[] MBTI = new String[n];

            for(int i = 0; i < n; i++){
                MBTI[i] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;

            for(int j = 0; j < n; j++){
                for(int k = j+1; k < n; k++){
                    for(int l = k+1; l < n; l++){
                        int cnt = 0;
                        for(int m = 0; m < 4; m++){
                            cnt += MBTI[j].charAt(m) != MBTI[k].charAt(m) ? 1 : 0;
                            cnt += MBTI[j].charAt(m) != MBTI[l].charAt(m) ? 1 : 0;
                            cnt += MBTI[k].charAt(m) != MBTI[l].charAt(m) ? 1 : 0;
                        }
                        min = Math.min(cnt, min);
                        if(min == 0) break;
                    }
                }
            }

            bw.write(min + "\n");
        }
        bw.flush();

    }
}
