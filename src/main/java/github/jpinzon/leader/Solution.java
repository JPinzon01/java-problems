package github.jpinzon.leader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {

	public int[] solution(int K, int M, int[] A) {
		// Map with the frequencies of all elements.
		Map<Integer, Integer> m = getFrequency(A);
		// Ordered result set.
		TreeSet<Integer> leaders = new TreeSet<>();
		// Map with the frequency of the last K elements.
		Map<Integer, Integer> interFr = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			// The loop starts adding the element to the internal frequency map.
			int curElement = A[i];
			int lastElement = -1;
			interFr.put(curElement, interFr.getOrDefault(A[i], 0) + 1);
			if (i >= K) {
				// After the index passes K we eliminate the last element from the frequency
				// list.
				lastElement = A[i - K];
				interFr.put(lastElement, interFr.get(lastElement) - 1);
			}
			// If the sub-array was just filled we check all elements inside.
			// This happens only once, so the complexity is still linear.
			if (i + 1 == K) {
				interFr.forEach((k, v) -> {
					if (checkElement(k, interFr, m, A.length)) {
						leaders.add(k + 1);
					}
				});
			} else if (i + 1 > K) {
				// Check new Element.
				if (!leaders.contains(curElement + 1) && checkElement(curElement, interFr, m, A.length)) {
					leaders.add(curElement + 1);
				}
				// Check last element. An element going out can result in a new leader.
				if (lastElement != -1 && lastElement != curElement && !leaders.contains(lastElement)
						&& checkElement(lastElement - 1, interFr, m, A.length)) {
					leaders.add(lastElement);
				}
			}

		}
		return leaders.stream().mapToInt(Integer::intValue).toArray();

	}

	/**
	 * Returns true if the element can become a leader given the frequencies in the
	 * array and a sub-array.
	 * 
	 * @param element  Element to check
	 * @param interFr  Frequency map of elements in the sub-array.
	 * @param totalFr  Frequency map of elements in the array.
	 * @param arrayLen Length of the main array.
	 * @return
	 */
	private boolean checkElement(int element, Map<Integer, Integer> interFr, Map<Integer, Integer> totalFr,
			int arrayLen) {
		return interFr.getOrDefault(element, 0) - interFr.getOrDefault(element + 1, 0)
				+ totalFr.getOrDefault(element + 1, 0) > arrayLen / 2;

	}

	/** Returns a map with the frequency of the elements. O(n). */
	private Map<Integer, Integer> getFrequency(int[] A) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			m.put(A[i], m.getOrDefault(A[i], 0) + 1);
		}
		return m;
	}

}