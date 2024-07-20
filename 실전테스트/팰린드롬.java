package 실전테스트;

import java.io.*;
import java.util.StringTokenizer;

public class 팰린드롬 {
    /*
    7
1 2 1 3 1 2 1
4
1 3
2 5
3 3
5 7
     */
    static int N;
    static String pelindrom;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(st.nextToken());
        }
        pelindrom = sb.toString();

        int M = Integer.parseInt(br.readLine());

    }
}

