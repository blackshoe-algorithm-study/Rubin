package may_week4;

import java.io.*;
import java.util.*;
public class 시험_감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N개의 시험관 3
        //각 시험관의 수험생, 띄어쓰기로 구별 1 2 3
        //총감독관 감시가능수, 부감독관 감시가능수
        //필요한 감독 최솟값을 출력
        int N = Integer.parseInt(br.readLine());
        List<Integer> tester = new ArrayList<>();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            tester.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        int main = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        Collections.sort(tester, Collections.reverseOrder());

        int cnt = 0;
        //최솟값 구하는 로직
        //현재 배열로 구별되어있음
        //그 방보다 크도록 하고 반복문 빠져나오면 됨.
        int currentRoom = tester.get(0);
        currentRoom = currentRoom < main ? 0 : currentRoom - main;

        tester.set(0, currentRoom);
        cnt++;

        for(int i = 0; i < N; i++){
            currentRoom = tester.get(i);
            int quote = 0;

            if(currentRoom >= sub) {
                quote = currentRoom / sub;
                currentRoom -= quote*sub;
            }
            else if(currentRoom < sub){
                quote = 1;
                currentRoom = 0;
            }

            System.out.println("currentRoom : " + currentRoom + " quote : " + quote);
            if(currentRoom > 0)
                quote++;

            System.out.println("currentRoom : " + currentRoom + " quote : " + quote);

            cnt = cnt + quote;

            System.out.println("cnt : " + cnt);
        }

        bw.write(cnt + "\n");
        bw.flush();


    }
}
