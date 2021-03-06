package exercise.d_testForRamda256.c_productPlaceStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://github.com/ndb796/python-for-coding-test/blob/master/16/4.java
/*
 7
15 11 4 8 5 2 4

테스트 예시 - 최장 증가 수열 참고 
6
sq : 10 20 10 30 20 50
i  : 0  1  2  3  4  5
dp : 1  2  1  3  2  4
j  : 0  1  2  3  4  5
 */


public class B2_soldierDeploy2 {
		
	    static int n;
	    static ArrayList<Integer> v = new ArrayList<Integer>();
	    static int[] dp = new int[2000];

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();

	        for (int i = 0; i < n; i++) {
	            v.add(sc.nextInt());
	        }

	        // 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
	        Collections.reverse(v);

	        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
	        for (int i = 0; i < n; i++) {
	            dp[i] = 1;
	        }

	        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
	        for (int i = 1; i < n; i++) {
	            for (int j = 0; j < i; j++) {
	                if (v.get(j) < v.get(i)) {
	                    dp[i] = Math.max(dp[i], dp[j] + 1);
	                }
	            }
	        }

	        // 열외해야 하는 병사의 최소 수를 출력
	        int maxValue = 0;
	        for (int i = 0; i < n; i++) {
	            maxValue = Math.max(maxValue, dp[i]);
	        }
	        System.out.println(n - maxValue);
	    }
	}
