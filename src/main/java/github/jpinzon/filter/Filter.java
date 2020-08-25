package github.jpinzon.filter;

import java.util.Arrays;
import java.util.List;

public class Filter {

	public static void EvenFilter(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		list.stream().filter(v -> v % 2 == 0);
	}

}
