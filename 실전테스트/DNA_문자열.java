package 실전테스트;

import java.io.*;
import java.util.*;

public class DNA_문자열 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());

        int[] minCount = new int[4];
        for(int i = 0; i < 4; i++){
            minCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4];
        Arrays.fill(count, 0);
        int result = 0;

        //초기 윈도우 설정
        for(int i = 0; i < P; i++){ //0 1 2 3
            switch(dna.charAt(i)){
                case 'A': count[0]++; break;
                case 'C': count[1]++; break;
                case 'G': count[2]++; break;
                case 'T': count[3]++; break;
            }
        }

        if(check(count, minCount)) result++;

        //슬라이딩 윈도우
        for(int i = P; i < S; i++){
            int j = i - P; //제거되는 문자

            //윈도우에 삭제되는 문자
            switch(dna.charAt(j)){
                case 'A': count[0]--; break;
                case 'C': count[1]--; break;
                case 'G': count[2]--; break;
                case 'T': count[3]--; break;
            }

            //윈도우에 추가되는 문자
            switch(dna.charAt(i)){
                case 'A': count[0]++; break;
                case 'C': count[1]++; break;
                case 'G': count[2]++; break;
                case 'T': count[3]++; break;
            }

            if(check(count, minCount)) result++;
        }

        bw.write(result+"\n");
        bw.flush();
    }

    static boolean check(int[] count, int[] minCount){
        for (int i = 0; i < 4; i++) {
            if (count[i] < minCount[i]) return false;
        }
        return true;
    }
}
