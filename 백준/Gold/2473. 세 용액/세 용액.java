import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        arr = new Integer[N];
        String[] split = in.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        
        Arrays.sort(arr);
        ansArr = new Integer[3];
        ans = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                findClosest(i, j);
            }
        }

        Arrays.sort(ansArr);
        System.out.println(ansArr[0] + " " + ansArr[1] + " " + ansArr[2]);
    }

    static Integer[] arr;
    static int N;
    static long ans;
    static Integer[] ansArr;

    private static void findClosest(int i, int j) {
        int start = j + 1;
        int end = N - 1;
        long sum = (long) arr[i] + arr[j];

        while (start <= end) {
            int mid = (start + end) / 2;
            long currentSum = sum + arr[mid];

            if (Math.abs(currentSum) < ans) {
                ans = Math.abs(currentSum);
                ansArr[0] = arr[i];
                ansArr[1] = arr[j];
                ansArr[2] = arr[mid];
            }

            if (currentSum < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}