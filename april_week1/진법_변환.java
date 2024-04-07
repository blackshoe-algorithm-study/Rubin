package april_week1;
import java.io.*;
import java.util.*;

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

        String number = st.nextToken();

        int B = Integer.parseInt(st.nextToken());

        int sum = 0;

        for(int i = 0; i < number.length(); i++){
            int tmp = number.charAt(i);

            if(Character.isAlphabetic(tmp)){
                tmp = tmp - 'A' + 10;
            }else{
                tmp = tmp - '0';
            }

            sum += tmp * Math.pow(B, number.length() - i - 1);
        }
        bw.write(sum+ "\n");
        bw.flush();
    }
}
