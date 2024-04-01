package april_week1;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class 잃어버린_괄호 {
    public static void main(String[]args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sik = br.readLine();

        char[] sikChar = sik.toCharArray();

        List<String> sikStrList = new ArrayList<>();

        StringBuilder tmp = new StringBuilder();

        for(int i=0; i < sikChar.length; i++) {
            if (sikChar[i] == '-' || sikChar[i] == '+') {
                sikStrList.add(tmp.toString());
                sikStrList.add(String.valueOf(sikChar[i]));

                System.out.println(tmp + String.valueOf(sikChar[i]));
                tmp = new StringBuilder();
            } else {
                tmp.append(sikChar[i]);
                if(i==sikChar.length-1) sikStrList.add(tmp.toString());
            }
        }

        String c;

        for(int i = 0; i < sikStrList.size(); i++){

            c = sikStrList.get(i);

            if(c.equals("-") || c.equals("+")){

                for(int j = i; j < sikStrList.size(); j++){



                }

            }
        }


    }

    int minus(int n1, int n2){
        return n1 - n2;
    }

    int plus(int n1, int n2){
        return n1 + n2;
    }
}
