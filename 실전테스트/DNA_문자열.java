package 실전테스트;

import java.io.*;
import java.util.*;

public class DNA_문자열 {
    static Set<String> sets = new HashSet<>();
    static int aMin = 0;
    static int cMin = 0;
    static int gMin = 0;
    static int tMin = 0;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //해당 문자열의 길이와, 해당 문자열에서 부분 문자열인 비밀번호 문자열의 길이
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        //A C G T가 들어간 임의의 문자열 str
        String str = br.readLine();
        System.out.println(str.toString());
        st = new StringTokenizer(br.readLine());

        //각 A, C, G, T가 들어가야 하는 최소 갯수
        aMin = Integer.parseInt(st.nextToken());
        cMin = Integer.parseInt(st.nextToken());
        gMin = Integer.parseInt(st.nextToken());
        tMin = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[S];
        Arrays.fill(visited, false);

        comb(str, visited, 0, S, P);

        bw.write(sets.size()+"\n");
        bw.flush();
    }

    static void comb(String str, boolean[] visited, int depth, int S, int P){
        if(P == 0){
            int aCnt=0;
            int cCnt=0;
            int gCnt=0;
            int tCnt=0;
            System.out.println(str);
            for(char c : str.toCharArray()){
                System.out.println(c);
                if(c=='A') aCnt++;
                else if(c=='C') cCnt++;
                else if(c=='G') gCnt++;
                else if(c=='T') tCnt++;
            }

            if(aCnt <= aMin || cCnt <= cMin || gCnt <= gMin || tCnt <= tMin)
                return;
            else
                sets.add(str.toString());
            return;
        }

        if(depth == S) {
            return;
        }

        visited[depth] = true;
        comb(str, visited, depth+1, S, P-1);

        visited[depth] = false;
        comb(str, visited, depth+1, S, P);
    }
}
