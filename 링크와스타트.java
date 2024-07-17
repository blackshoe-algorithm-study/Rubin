import java.io.*;
import java.util.*;

public class 링크와스타트 {

    static int[][] stats;
    static boolean[] team;
    static int N;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        //1 vs 4여도 됨
        stats = new int[N][N];
        team = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0,0);

        bw.write(MIN + "\n");
        bw.flush();
    }

    static void combination(int index, int count){
        if(index == N){
            if(count > 0 && count < N) {
                calculateDifference();
            }
            return;
        }


        team[index] = true;
        combination(index+1, count+1); //count는 선택한 팀원 수
        team[index] = false;
        combination(index+1, count);

    }

    static void calculateDifference(){
        int linkScore = 0;
        int startScore = 0;

        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                if(team[i] && team[j]) linkScore += stats[i][j] + stats[j][i];
                else if(!team[i] && !team[j]) startScore += stats[i][j] + stats[j][i];
            }
        }

        MIN = Math.min(MIN, Math.abs(linkScore - startScore));
    }
}
