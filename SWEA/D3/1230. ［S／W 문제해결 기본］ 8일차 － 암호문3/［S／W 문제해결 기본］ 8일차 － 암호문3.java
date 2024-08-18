import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            List<Integer> script = new LinkedList<>();
            for (int i = 0; i < N; i++){
                script.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++){
                String cmd = st.nextToken();
                if (cmd.equals("I")){
                    insert(script, st);
                }
                else if (cmd.equals("D")){
                    delete(script, st);
                }
                else {
                    add(script, st);
                }
            }
            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < 10; i++){
                sb.append(script.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void insert(List<Integer> script, StringTokenizer st){
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < y; i++){
            script.add(x + i, Integer.parseInt(st.nextToken()));
        }
    }
    public static void delete(List<Integer> script, StringTokenizer st){
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < y; i++){
            script.remove(x);
        }
    }
    public static void add(List<Integer> script, StringTokenizer st){
        int y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < y; i++){
            script.add(Integer.parseInt(st.nextToken()));
        }
    }
}