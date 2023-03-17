package complete;
/*
 * 에라토스테네스의 체
 * 소수 구하는 알고리즘
 * 대량의 소수를 한꺼번에 판별할 경우 사용
 * 
 * 소수를 판별할 범위만큼 배열을 할당 -> 해당하는 값을 넣고, 하나씩 지워나감
 * 1. 배열을 생성하여 초기화한다.
 * 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다. (자기자신은 지우지 않고, 이미 지워진 수는 건너뛴다.)
 * 3. 2부터 시작하여 남아있는 수를 구한다.
 */
public class EratosthenesPrimeNum {
	public static void main(String[] args) {
		primeNumberSieve();
	}
	
	static void primeNumberSieve() {
		int num = 100000;
		int[] a = new int[100001];
		for(int i=2; i<=num; i++) {
			a[i]=i;
		}
		for(int i=2; i<=num; i++) {
			if(a[i]==0) continue;
			for(int j=2*i; j<=num; j+=i) {
				a[j]=0;
			}
		}
		for(int i=2; i<=num; i++) {
			if(a[i]!=0) System.out.printf("%d\n", a[i]);
		}
		
	}
	

}
