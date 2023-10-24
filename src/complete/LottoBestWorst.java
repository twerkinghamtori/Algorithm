package complete;

//프로그래머스 로또의 최고 순위와 최저 순위
//최저 : 0의 개수만큼 다른 번호인 경우
//최고 : 0의 개수만큼 같은 번호인 경우
public class LottoBestWorst {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zerocnt = 0;
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i]==0) zerocnt++;
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) cnt++;
            }
        }
        answer[0] = (cnt+zerocnt)<=1?6:7-(cnt+zerocnt);
        answer[1] = cnt<=1?6:7-cnt;
        return answer;
    }
}
