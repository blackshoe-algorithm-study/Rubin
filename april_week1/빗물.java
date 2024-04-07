package april_week1;

import java.io.*;
import java.util.*;

public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] origin = new int[col];

        for(int i = 0; i < origin.length; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[col];
        int[] reverseArr = new int[col];

        int max = 0;
        int reverseMax = 0;

        for(int i = 0; i < origin.length; i++){
            max = Math.max(max, origin[i]);
            reverseMax = Math.max(reverseMax, origin[col - i - 1]);

            arr[i] = max;
            reverseArr[col - i - 1] = reverseMax;
        }
        int sum = 0;

//        for(int i = 0; i < origin.length; i++){
//            System.out.println("arr " + i + " " + arr[i]);
//            System.out.println("reverseArr " + i + " " + reverseArr[i]);
//        }

        for(int i = 0; i < origin.length; i++){
            int limit = Math.min(arr[i], reverseArr[i]);

            sum += (limit - origin[i]);
        }

        bw.write(sum+"\n");
        bw.flush();
    }
}