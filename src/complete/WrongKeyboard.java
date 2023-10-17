package complete;

//프로그래머스 대충 만든 자판
public class WrongKeyboard {
	
	public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];        
        for(int i=0; i<targets.length; i++) {
            int answer1 = 0;
            for(int j=0; j<targets[i].length(); j++) {
                int min = Integer.MAX_VALUE;
                boolean check = false;
                for(int z=0; z<keymap.length; z++) {                     
                    for(int a=0; a<keymap[z].length(); a++) {
                        if(targets[i].charAt(j) == keymap[z].charAt(a)) {
                            min = Math.min(min, a+1);
                            check = true;
                        }                        
                    }
                }
                if(!check) {
                    answer1 = -1;
                    break;
                } else {
                    answer1 += min;
                }                 
            }
            answer[i] = answer1;
        }
        return answer;
    }
}
