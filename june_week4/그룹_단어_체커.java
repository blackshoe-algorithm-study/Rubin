package june_week4;
import java.io.*;
import java.util.*;

public class 그룹_단어_체커{
    //그룹 단어 정의
    //문자는 문자열에서 연속하지 않고 떨어져서 나오는 경우 false
    //모든 문자가 연속해서 나오는 경우 true
    //그룹 단어의 개수를 출력한다.

    static int N, solution;
    public static void main(String[]args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            if(groupWordCheck(br.readLine())) solution++;
        }
        bw.write(solution + "\n");
        bw.flush();
    }

    static boolean groupWordCheck(String word){
        char lastChar = ' ';
        //a b c d e f g h i j k l m n o p q r s t u v w x y z, 26개
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);

        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(visited[idx] && c == lastChar){
                //아무것도 하지 않음. 다음 거 수행.
            }else if(visited[idx]) { //만약 이전에 나온적 있는 숫자지만 직전 문자와 다른 경우
                return false;
            }else if(!visited[idx]){
                visited[idx] = true;
            }
            lastChar = c;
        }
        //반복문 다 수행했다면
        return true;
    }
}
