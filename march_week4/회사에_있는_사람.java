package march_week4;
import java.util.*;
import java.util.stream.*;
import java.io.*;
public class 회사에_있는_사람 {
    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int times = Integer.parseInt(br.readLine());

        Map<String, String> hashMap = new HashMap<>();

        StringTokenizer st;

        String name;

        String move;

        while(times --> 0){
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            move = st.nextToken();

            if(move.equals("enter"))
                hashMap.put(name, move);
            else
                hashMap.remove(name);
        }

        List<String> list = new ArrayList<>();

        hashMap.keySet().forEach(s1 -> list.add(s1));

        Collections.sort(list, Collections.reverseOrder()); // 몰랐음

        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i));
            bw.write("\n");
        }
        bw.flush();
    }
}
