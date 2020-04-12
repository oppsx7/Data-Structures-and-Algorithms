import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }



    public static void main(String[] args) {
        FastReader input = new FastReader();
        int N = input.nextInt();
        List<Integer> list = new ArrayList<>();
        int[] array = new int[N - 1];
        Map<Integer,Integer> hashMap = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < N - 1; i++)
            array[i] = input.nextInt();
        for (int i = 0; i < N - 1; i++) {
            int count = hashMap.containsKey(array[i]) ? hashMap.get(array[i]) : 0;
            hashMap.put(array[i], count + 1);
            list.add(input.nextInt());
            if (hashMap.containsKey(list.get(i)) && hashMap.get(list.get(i))!=0){
                hashMap.put(list.get(i),hashMap.get(list.get(i))-1);
                continue;
            } else
                counter++;
        }

        System.out.println(counter);

    }
}