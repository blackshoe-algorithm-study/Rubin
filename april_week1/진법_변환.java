package april_week1;
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class 진법_변환 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        int a = 90;
//        char A = (char)a;
//        System.out.println(A); //65:A, 90:Z
//
//        char test = '9';
//
//        System.out.println((int)test);
//        System.out.println(57-9);

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] N = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;

        for(int i = N.length; i > 0; i--){
            //숫자 : 1~9 map to 49 ~ 57
            //문자 : A~Z map to 65 ~ 90
            int tmp = (int)N[i-1];

            if(tmp >= 49 && tmp <= 57){
                tmp = tmp - 48;
            }else if(tmp >= 65 && tmp <= 90){
                tmp = tmp - 55;
            }
            int ttmp = (int) Math.pow(B, i-1);
            tmp *= ttmp;
            sum += tmp;

        }
        bw.write(String.valueOf(sum)+ "\n");
        bw.flush();
    }
}
