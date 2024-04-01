package april_week1;
import java.util.*;
import java.io.*;
import java.util.stream.*;
public class ATM {
    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        List<Integer> initialSortedList = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Collections.sort(initialSortedList);

        List<Integer> sumInitialSortedList = new ArrayList<>();
        for(int i = 0; i < T; i++){
            if(i==0)
                sumInitialSortedList.add(initialSortedList.get(i));
            else {
                sumInitialSortedList.add(sumInitialSortedList.get(i-1) + initialSortedList.get(i));
            }
        }

        int sol = 0;
        for(int j = 0; j < T; j++){
            sol += sumInitialSortedList.get(j);
        }

        bw.write(sol + "\n");

        bw.flush();
    }
}
