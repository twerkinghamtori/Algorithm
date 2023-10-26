package complete;

//프로그래머스 키패드 누르기
//초기 위치에서 2,5,8,0으로 가는 반례
public class Keypad {
	public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] keypad = {{1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-2}};
        int lastL = -1;
        int lastR = -2;
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
                sb.append("L");
                lastL = numbers[i];
            } else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
                sb.append("R");
                lastR = numbers[i];
            } else {
                int lx=0;
                int ly=0;
                int rx=0;
                int ry=0;
                int x=0;
                int y=0;
                for(int a=0; a<keypad.length; a++) {
                    for(int b=0; b<keypad[b].length; b++) {
                        if(keypad[a][b] == lastL) {
                            lx=a;
                            ly=b;
                        }
                        if(keypad[a][b] == lastR) {
                            rx = a;
                            ry = b;
                        }
                        if(keypad[a][b] == numbers[i]) {
                            x = a;
                            y = b;
                        }
                    }
                }                
                int ld = Math.abs(lx-x) + Math.abs(ly-y);
                int rd = Math.abs(rx-x) + Math.abs(ry-y);
                //거리 같은 경우
                if(ld==rd) {
                	//오른손잡이 || 왼손잡이
                    if(hand.equals("right")) {
                        sb.append("R");
                        lastR = numbers[i];
                    } else{
                        sb.append("L");
                        lastL = numbers[i];
                    }
                } else if (ld<rd) {
                    sb.append("L");
                    lastL = numbers[i];
                } else {
                    sb.append("R");
                    lastR = numbers[i];
                }
            }
        }
        return sb.toString();
    }
}
