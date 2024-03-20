import java.io.*;
import java.util.*;
public class 수_정렬하기_2 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int times = Integer.parseInt(br.readLine());

        ArrayList<Integer> intArr = new ArrayList<>();

        for(int i = 0; i < times; i++){

            intArr.add(Integer.parseInt(br.readLine()));

        }

        Collections.sort(intArr);

        for(int j = 0; j < times; j++)
            bw.write(intArr.get(j) + "\n");

        bw.flush();
    }
}
