package march_week4;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class 괄호 {
    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int times = Integer.parseInt(br.readLine());

        String answer = "";

        while(times-- > 0){
            Deque deque = new ArrayDeque<Character>();
            char[] charArr = br.readLine().toCharArray();

            answer = "YES";

            for(int i = 0; i < charArr.length; i++){
                deque.addLast(charArr[i]);

                if(deque.peekFirst().equals(')')) {
                    answer = "NO";
                    break;
                }

                if(deque.peekLast().equals(')')) {
                    deque.removeLast();
                    deque.removeLast();
                }


                if(i == charArr.length-1 && deque.size() > 0){
                    answer = "NO";
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();

    }
}
