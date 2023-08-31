package complete;
import java.util.*;

public class KthNum {
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];        
        for(int i=0; i<commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++) {
                list.add(array[j]);
            }
            list.sort((o1,o2) -> o1-o2);
            answer[i] = list.get(commands[i][2]-1);            
        }
        return answer;
    }
	
}
