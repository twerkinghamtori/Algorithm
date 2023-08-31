package complete;

public class TargetNum {
    static int cnt=0;
    
    public static int solution(int[] numbers, int target) {
    	int answer = 0;
        dfs(0, target, numbers, 0);
        answer = cnt;
        return answer;
    }    
    
    static void dfs(int depth, int target, int[] numbers, int result) {
    	if(depth == numbers.length) {
    		if(result == target) cnt++;
    		return;
    	}
    	
    	int plus = result + numbers[depth];
    	int minus = result - numbers[depth];
    	
    	dfs(depth+1, target, numbers, plus);
    	dfs(depth+1, target, numbers, minus);
    }
    
	public static void main(String[] args) {
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		System.out.println("answer : " + solution(numbers, target));

	}

}
