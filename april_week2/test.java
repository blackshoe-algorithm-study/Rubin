package april_week2;

import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 쌓이는 피로도
        int b = Integer.parseInt(st.nextToken()); // 일
        int c = Integer.parseInt(st.nextToken()); // 회복 피로도
        int m = Integer.parseInt(st.nextToken()); // 번아웃
        int tired = 0, work = 0;
        int DAY = 24;

        for (int i=0; i<DAY; i++) {
            if (tired + a <= m) {
                tired += a;
                work += b;
            } else {
                if (tired - c >= 0) tired -= c;
                else {
                    while (tired > 0 && c > 0) {
                        tired -= 1;
                        c--;
                    }
                }
            }
        }

        System.out.println(work);
    }
}