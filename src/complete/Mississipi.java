import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 
 * 알아내는 프로그램을 작성하시오. 
 * 단, 대문자와 소문자를 구분하지 않는다.
 * 
 * */
public class Mississipi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		word = word.toUpperCase();
		List<Integer> count = new ArrayList<>();
		List<String> alphabet = new ArrayList<>();
		int cnt=1;
		for(int i=0; i<word.length(); i++) {
			for(int j=i+1; j<word.length(); j++) {
				if(word.charAt(i)==(word.charAt(j))) cnt++;
			}
			count.add(cnt);
			alphabet.add(word.substring(i,i+1));
			cnt=1;
		}
		int a = 0;
		int b = Collections.max(count);
	    int ccnt=0;
		for(int i=0; i<count.size(); i++) {
			if(count.get(i)==b) {
				a=i;
				ccnt++;
			}
		}
		if(ccnt>=2) System.out.println("?");
		else System.out.println(alphabet.get(a));

	}
}
