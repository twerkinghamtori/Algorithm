package complete;

import java.util.ArrayList;
import java.util.List;

public class Babbling {

	public static void main(String[] args) {
		int answer=0;
		String[] can = {"aya", "ye", "woo", "ma" };
		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		for(int i=0; i<babbling.length; i++) {
			for(int j=0; j<can.length; j++) {
				if(babbling[i].contains(can[j])) {
					babbling[i] = babbling[i].replace(can[j], " ");
				}
			}
		}
		for(String s : babbling) {
			System.out.println(s);
			if(s.trim().equals("")) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
