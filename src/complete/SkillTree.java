package complete;
import java.util.ArrayList;
import java.util.List;

/* 완료
스킬트리
문제 설명
선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 
썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 
라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 
따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 
skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 
solution 함수를 작성해주세요.
제한 조건
스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
스킬 순서와 스킬트리는 문자열로 표기합니다.
예를 들어, C → B → D 라면 CBD로 표기합니다
선행 스킬 순서 skill의 길이는 2 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
skill_trees는 길이 1 이상 20 이하인 배열입니다.
skill_trees의 원소는 스킬을 나타내는 문자열입니다.
skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
입출력 예
skill	skill_trees	          return
CBD	[BACDE, CBADF, AECB, BDA]	2
입출력 예 설명
BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
CBADF: 가능한 스킬트리입니다.
AECB: 가능한 스킬트리입니다.
BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
스킬 트리: 유저가 스킬을 배울 순서  
*/
public class SkillTree {
	static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		int cnt=0;
		for(int i=0; i<skill_trees.length; i++) { //3중 for문 개에바인듯ㅋ
			for(int a=0; a<skill_trees[i].length(); a++) { //C,B,D를 0,1,2로 생각하고 skill_trees에 있다면 해당하는 숫자를 list에 추가
				for(int j=0; j<skill.length(); j++) {
					if(skill_trees[i].charAt(a) == (skill.charAt(j))) {
						list.add(j); 
					}
				}
			} //ex. C,B,D -> B,A,C,D,E => list [1,0,2]
			  //ex. C,B,D -> C,B,A,D,F => list [0,1,2]
//			System.out.println(list); //확인용
			if(list.contains(0)) {
				cnt++; //0없이 1,2만 나오면 안되니까 0갖고 있으면 cnt증가
				for(int l=0; l<list.size()-1; l++) { //for문 하나 더 있지롱^^
					if(list.get(l)>list.get(l+1)) cnt--; //근데 순서가 0,1,2 순서가 안맞으면 다시 cnt감소
				}
			}
			if(!list.contains(0)&&!list.contains(1)&&!list.contains(2)) answer++; //AZM
//			System.out.println(cnt);
			if(cnt>=1) answer++; //list[1,0,2] -> 0있으니까 cnt=1 -> 순서 안맞으니까 cnt=0// 조건 모두 만족하는 애들만 answer증가.
			cnt=0;
			list.clear(); //그래도 이번문제는 list 썼다 휴.
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println
		("결과:" + solution
			("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA", "AZM" })); 
	}
}
