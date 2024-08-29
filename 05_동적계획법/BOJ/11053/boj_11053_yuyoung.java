import java.util.Scanner;

public class boj_11053_yuyoung {

    static int[] seq;
    static Integer[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수열의 길이

        seq = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        // 0부터 N-1까지 모든 위치에 대해 최장 증가 부분 수열 길이
        for (int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        // 최장 증가 부분 수열의 길이
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static int LIS(int N) {

        // 아직 탐색하지 않은 위치의 경우
        if (dp[N] == null) {
            dp[N] = 1; // 최소 길이 1

            for (int i = N - 1; i >= 0; i--) {
            	// seq[i]가 seq[N]보다 작을 경우
                if (seq[i] < seq[N]) {
                    // 해당 위치의 dp 값 갱신
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }
        return dp[N];
    }
}