package exercise.d_testForRamda256.a_callRecordSummary;

/*
문제 : https://programmers.co.kr/learn/courses/30/lessons/60057
답 : https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%95%95%EC%B6%95-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java

  s	              result
"aabbaccc"	        7
"ababcdcdababcdcd"	9
"abcabcdede"		8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd"	17
*/
import java.util.Scanner;

//import com.sun.tools.javac.util.Assert;

public class B_stringCompression2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int resultCnt = 0;
		resultCnt = solution("ababcdcdababcdcd");
		System.out.println(resultCnt);

	}

	public static int solution(String s) {
		int min = s.length();

		for (int i = 1; i <= s.length() / 2; i++) {
			int compLeng = compression(s, i).length();
			min = Math.min(min, compLeng);
		}

		return min;
	}

	/**
	 * 문자열 압축
	 *
	 * @param str 입력받은 문자열
	 * @param i   i값
	 * @return 압축된 문자열
	 */
	private static String compression(String str, int i) {

		int count = 1;
		String compression = "";
		String pattern = "";

		for (int j = 0; j <= str.length() + i; j += i) {

			String nowStr;

			// 전 문자열과 비교할 현재 문자열
			if (j >= str.length()) { // 현재 문자열이 없을 때
				nowStr = "";
			} else if (str.length() < j + i) { // 마지막 현재 문자열일 때
				nowStr = str.substring(j);
			} else {
				nowStr = str.substring(j, j + i); // 그 외
			}

			// 1. 전 문자열이랑 똑같은지 비교한다. (맨 처음이면 비교 X)
			if (j != 0) {
				if (nowStr.equals(pattern)) { // 똑같으면
					count++;
				} else if (count >= 2) { // 다르고 count가 2회 이상이면 압축 가능
					compression += count + pattern;
					count = 1;
				} else { // 압축 불가능하면 그냥 그대로 문자열 이어붙이기
					compression += pattern;
				}
			}
			// 2. i 길이만큼 문자열을 자른다.
			pattern = nowStr;
		}

		return compression;
	}

	/*
	 * //@Test public void sol() { Assert.assertEquals(7, solution("aabbaccc"));
	 * Assert.assertEquals(9, solution("ababcdcdababcdcd")); Assert.assertEquals(8,
	 * solution("abcabcdede")); Assert.assertEquals(14,
	 * solution("abcabcabcabcdededededede")); Assert.assertEquals(17,
	 * solution("xababcdcdababcdcd")); }
	 */
}
