package github.jpinzon.leader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeaderTest {

	@Test
	public void emptyResult() {
		int[] a = { 2, 1, 3, 8, 4, 7, 3 };
		int[] sol1 = {};
		Solution sol = new Solution();
		Assertions.assertArrayEquals(sol1, sol.solution(3, 10, a));

	}

	@Test
	public void givenExample() {
		int[] a = { 2, 1, 3, 1, 2, 2, 3 };
		int[] sol1 = { 2, 3 };
		Solution sol = new Solution();
		Assertions.assertArrayEquals(sol1, sol.solution(3, 5, a));
	}

	@Test
	public void leaderAtTheEnd() {
		int[] a = { 1, 1, 1, 5, 5, 5, 5 };
		int[] sol1 = { 6 };
		Solution sol = new Solution();
		Assertions.assertArrayEquals(sol1, sol.solution(4, 5, a));
	}

	@Test
	public void leaderAtFirstGroup() {
		int[] a = { 1, 1, 3, 2, 1, 2, 3 };
		int[] sol1 = { 2, 3 };
		Solution sol = new Solution();
		Assertions.assertArrayEquals(sol1, sol.solution(3, 5, a));

	}

	@Test
	public void testLeaderFoundAtEnd() {
		int[] a = { 2, 2, 1, 1, 3, 3, 2, 1, 1 };

		int[] sol1 = { 2 };
		Solution sol = new Solution();
		Assertions.assertArrayEquals(sol1, sol.solution(4, 6, a));

	}

	@Test
	public void testLeaderFoundAtEnd2() {
		int[] a = { 6, 6, 6, 6, 9, 10, 5, 4, 6, 4, 5 };

		int[] sol1 = { 6 };
		Solution sol = new Solution();
		Assertions.assertArrayEquals(sol1, sol.solution(5, 6, a));

	}
}
