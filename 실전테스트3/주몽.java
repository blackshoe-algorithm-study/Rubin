package 실전테스트3;
import java.io.*;
import java.util.*;
public class 주몽 {
    static int N, M, sol;
    static int[] m;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        m = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            m[i] = Integer.parseInt(st.nextToken());
        }

        sol = 0;
        combination(-1, new ArrayList<>());

        bw.write(String.valueOf(sol));
        bw.flush();
    }
    static void combination(int start, ArrayList<Integer> selected){
        if(selected.size() == 2){
            if(m[selected.get(0)] + m[selected.get(1)] == M){
                sol++;
            }
            return;
        }

        for(int i = start + 1; i < N; i++){
            selected.add(i);
            combination(i, selected);
            selected.remove(selected.size() - 1);
        }
    }
}
