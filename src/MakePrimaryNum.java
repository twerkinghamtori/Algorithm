

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
소수 만들기
문제 설명
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록
solution 함수를 완성해주세요.
제한사항
nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
입출력 예
nums	result
[1,2,3,4]	1
[1,2,7,6,4]	4
입출력 예 설명
입출력 예 #1
[1,2,4]를 이용해서 7을 만들 수 있습니다.
입출력 예 #2
[1,2,4]를 이용해서 7을 만들 수 있습니다.
[1,4,6]을 이용해서 11을 만들 수 있습니다.
[2,4,7]을 이용해서 13을 만들 수 있습니다.
[4,6,7]을 이용해서 17을 만들 수 있습니다. */
public class MakePrimaryNum {
	private static int cnt=0;
	private static List<int[]> list = new ArrayList<>();
	public static void combine(int[] nums, boolean[] checked, int start) {
		if(cnt==3) {
			System.out.println(Arrays.toString(checked));
			int[] temp = new int[nums.length];
			for(int i=0; i<nums.length; i++) {
				if(checked[i]) {
					temp[i] = nums[i];
				}
			}
			list.add(temp);
			System.out.println(Arrays.toString(temp));
			return;
		}
		for(int i=start; i<nums.length; i++) {
			if (!checked[i]) {
				checked[i]=true;
				cnt++;
				combine(nums, checked, i+1);
				checked[i]=false;
				cnt--;
			}
		}
	}
    static int solution(int[] nums) {
        int answer = 0;
        boolean[] checked = new boolean[nums.length];
        combine(nums, checked, 0);
        int[] sum = new int [nums.length];
        int hap = 0;
        int cnt=0;
        for(int[] i : list) {
        	for(int j=0; j<nums.length; j++) {
        		hap += i[j];
        	}
        	for(int z=1; z<=hap; z++) {
        		if(hap%z==0) {
        			cnt++;
        		}
        	}
        	if(cnt==2) answer++; 
        	cnt=0;
        	hap=0;
        }
        list.clear();
        return answer;
   }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4})); //1
		System.out.println(solution(new int[] {1,2,7,6,4})); //4
		System.out.println(solution(new int[] {1,2,3,4,5,6})); //6
	}
}