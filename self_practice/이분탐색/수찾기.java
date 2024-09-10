package self_practice.이분탐색;
import java.io.*;
import java.util.*;

public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int i = 0, j = list.size()-1;

            int target = Integer.parseInt(st.nextToken());
            boolean flag = false;

            while(i <= j){
                int m = (i+j)/2;
                if(target < list.get(m)){
                    j = m-1;
                }else if(target > list.get(m)){
                    i = m+1;
                }else{
                    flag = true;
                    break;
                }
            }

            if(flag) bw.write("1\n");
            else bw.write("0\n");
        }

        bw.flush();
    }
}
