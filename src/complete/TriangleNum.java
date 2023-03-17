package complete;

/*
[결과]
 46
 47  37
 48  38  29
 49  39  30  22
 50  40  31  23  16
 51  41  32  24  17  11
 52  42  33  25  18  12   7
 53  43  34  26  19  13   8   4
 54  44  35  27  20  14   9   5   2
 55  45  36  28  21  15  10   6   3   1

 1.가변 배열 선언 int arr[][] = new int[10][]
 2.각행의 1차원 배열 객체 생성 
 3.배열의 내부에 숫자 채우기
 4.결과 출력
*/
public class TriangleNum {
	public static void main(String[] args) {
		int arr[][] = new int[10][];
		for(int i=0; i<arr.length; i++) {
			arr[i] = new int[i+1];
		}
		int num = 1;
		int sum = 0;
		int minus = 0;
		
		for(int i=9; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				if(i == j) {
					num+=sum++;
					arr[i][j] +=num;
				}
				else {minus += (10-j); 
					arr[i][j] = arr[i][i] + minus;}
			}
			minus = 0;
		}
		
	  for(int i=0; i<=9; i++) {
			for(int j=0; j<=i; j++) { 
				System.out.print(arr[i][j]+ "\t");
			}
			System.out.println();
		}
	  
	}
}