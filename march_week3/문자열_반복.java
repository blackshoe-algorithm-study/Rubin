package march_week3;

import java.io.*;
import java.util.*;

public class 문자열_반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int times = Integer.parseInt(br.readLine());

        StringBuilder sb;

        for(int i = 0; i < times; i++) {
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int repeat = Integer.parseInt(st.nextToken());

            char[] characters = st.nextToken().toCharArray();

            for(int j = 0; j < characters.length; j++)
                for(int k = 0; k < repeat; k++)
                    sb.append(characters[j]);

            bw.write(sb.toString() + "\n");
            bw.flush();
        }
    }
}
