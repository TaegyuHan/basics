package hashMap.p10816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(hashMap.HashMap.PATH + "/p10816/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>(); // 해쉬 맵

        int inputCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        inputCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            if (map.get(key) == null) {
                sb.append(0);
            } else {
                sb.append(map.get(key));
            }
            if (st.hasMoreTokens()) {
                sb.append(" ");
            }
        }

        System.out.print(sb);
    }
}

