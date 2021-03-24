package exercise.d_testForRamda256.c_productPlaceStrategy;
//https://st-lab.tistory.com/137
//- 방법 4 : [BufferedReader + Bottom-Up],입력 방법만 Scanner 대신 BufferedReader 을 사용한 풀이방식이다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
테스트 예시
6
10 20 10 30 20 50
답 : 4
 */
public class B1_LIS {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());//7
		int[] seq = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");//15 11 4 8 5 2 4

		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			dp[i] = 1;

			// 0 ~ i 이전 원소들 탐색
			for (int j = 0; j < i; j++) {

				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1; // j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}

		// 최댓값(최대 길이) 탐색
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		System.out.println(max);

	}

}