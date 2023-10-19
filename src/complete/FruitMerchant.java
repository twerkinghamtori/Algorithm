package complete;
import java.util.*;

public class FruitMerchant {

	public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] scoreArray = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            scoreArray[i] = score[i];
        }
        Arrays.sort(scoreArray, Collections.reverseOrder());
        for(int i=0; i<scoreArray.length; i+=m) {
            if(scoreArray.length-i<m) break;
            else {
                answer += m*scoreArray[i+m-1];
            }
        }
        return answer;
    }

}
