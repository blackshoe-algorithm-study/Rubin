package march_week4;

import java.io.*;
import java.util.*;

public class 전화번호_목록{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            String flag = "YES";

            int t = Integer.parseInt(br.readLine());
            List<String> strList = new ArrayList<>();

            for(int i = 0; i < t; i++){
                String item = br.readLine();
                strList.add(item);
            }
            Collections.sort(strList);

            for(int j = 0; j < t-1; j++){
                if (strList.get(j+1).startsWith(strList.get(j))) {
                    flag = "NO";
                    break;
                }
            }

            bw.write(flag + "\n");
        }
        bw.flush();
    }
}
