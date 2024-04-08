package april_week2;

import java.io.*;
import java.util.*;

public class 퇴사 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;

        int T = Integer.parseInt(br.readLine());
        int[][]arr = new int[T][2];
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int cIdx = 1;
        int w = 0;
        int sol = 0;


        for(int i = 0; i < T; i++){
            int cSum = 0;

            for(int j = i; j < T; j++){
                if(j + arr[j][0] > T) break;

                System.out.println("cSum : " + cSum + " j : "+ j + " arr[j][0] : " + arr[j][0] + " arr[j][1] : " + arr[j][1] + " sol : " + sol);
                cSum += arr[j][1];
                j = j + arr[j][0] - 1;

            }

            System.out.println("sol : " + sol + " cSum : " + cSum);

            sol = Math.max(sol, cSum);
        }

        bw.write(sol + "\n");
        bw.flush();
    }
}
