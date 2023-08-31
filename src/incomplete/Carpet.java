package incomplete;

import java.util.*;

public class Carpet {

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= yellow; i++) {
			if (yellow % i == 0) {
				list.add(i);
			}
		}
		if (yellow == 1) {
			answer[0] = 3;
			answer[1] = 3;
			return answer;
		}
		if (list.size() % 2 == 0) {
			for (int i = 0; i < list.size() / 2; i++) {
				int v = list.get(list.size() - 1 - i);
				int h = (list.get(i) + 2);
				if (v * 2 + h * 2 == brown) {
					answer[0] = list.get(list.size() - 1 - i) + 2;
					answer[1] = list.get(i) + 2;
				}
			}
		} else {
			for (int a = 0; a < list.size() / 2 + 1; a++) {
				int v = list.get(list.size() - 1 - a);
				int h = list.get(a) + 2;
				if (v * 2 + h * 2 == brown) {
					answer[0] = list.get(list.size() - 1 - a) + 2;
					answer[1] = list.get(a) + 2;
				}
			}
		}
		return answer;
	}
}
