package april_week1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
public class 잃어버린_괄호 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder splitedByMinus1 = new StringBuilder();
        StringBuilder splitedByMinus2 = new StringBuilder();

        char[] original = br.readLine().toCharArray();

        boolean flag = false;

        for(int i = 0; i < original.length; i++){
            //처음 마이너스를 만나면
            if(original[i] == '-' && !flag){
                flag = true;
                continue;
            }

            //처음 마이너스를 만난 뒤
            if (flag)
                if (original[i] == '-')
                    splitedByMinus2.append('+');
                else
                    splitedByMinus2.append(original[i]);

                //처음 마이너스를 만나기 전까지
            else {
                splitedByMinus1.append(original[i]);
            }

        }

        StringTokenizer st1 = new StringTokenizer(splitedByMinus1.toString(),"+");
        StringTokenizer st2 = new StringTokenizer(splitedByMinus2.toString(),"+");

        int sum1 = 0, sum2 = 0;
        while(st1.hasMoreTokens()){
            sum1 += Integer.parseInt(st1.nextToken());
        }
        while(st2.hasMoreTokens()){
            sum2 += Integer.parseInt(st2.nextToken());
        }

        bw.write((sum1 - sum2 + "\n").toString());

        bw.flush();

    }
}
