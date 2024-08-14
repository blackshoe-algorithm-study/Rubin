package 실전테스트5;

import java.io.*;
import java.util.*;
public class 감소하는_수 {
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if(n <= 10){
            bw.write(n + "\n");
        }else if(n > 1022){
            bw.write("-1\n"); //9876543210
        }else{
            for(int i = 0; i < 10; i++){
                bp(i, 1);
            }
            Collections.sort(list);

            bw.write(list.get(n) + "\n");
        }

        bw.flush();
    }
    public static void bp(long num, int idx){
        if(idx > 10) return; //9876543210

        list.add(num);
        for(int i = 0; i < num % 10; i++) {//5로 시작하면 43210까지만
            bp((num * 10) + i, idx + 1);
        }
    }

}
