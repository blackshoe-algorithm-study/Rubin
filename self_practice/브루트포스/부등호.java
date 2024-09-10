package self_practice.브루트포스;
import java.util.*;
import java.io.*;

public class 부등호 {
    static char[] arrows;
    static int k;
    static String max = "0";
    static String min = "9876543210";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        arrows = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            arrows[i] = st.nextToken().charAt(0);
        }

        boolean[] used = new boolean[10];
        dfs("", 0, used);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
    }
    static void dfs(String num, int depth, boolean[] used){
        if (depth == k + 1){
            if (Long.parseLong(max) < Long.parseLong(num)) max = num;
            if (Long.parseLong(min) > Long.parseLong(num)) min = num;
            return;
        }

        for(int i = 0;  i <= 9; i++){
            if (used[i]) continue;
            if(depth == 0 || compare(num.charAt(depth - 1) - '0', i, arrows[depth - 1])){
                used[i] = true;
                dfs(num + i, depth + 1, used);
                used[i] = false;
            }
        }

    }
    static boolean compare(int a, int b, char op){
        return op == '<' ? a < b : a > b;
    }
}
