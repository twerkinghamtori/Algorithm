package complete;


import java.util.Scanner;
/*

삼각형의 높이를 홀수로 입력하세요
5
*****   0    01234
 ***    1     123   
  *     2      2    
 ***    3     123
*****   4    01234 

  *     0      2
 ***    1     123
*****   2    01234
 ***    1     123
  *     2      2


 */
public class Stars2 {
	public static void main(String[] args) {

		System.out.println("삼각형의 높이를 홀수로 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int m = h/2; 
		int i=0, j=0;
		
		for(i=0; i<=m; i++) {
			for(j=0; j<=(h-1)-i; j++) { // 앞은 공백을 찍어야 되니까 0부터, 뒤는 안찍어도 남으니까 범위 제한.
				if(j<i)System.out.print(" "); 
				else System.out.print("*");
			} System.out.println();
		}
		for(i=m+1; i<h; i++) {
			for(j=0; j<=i; j++) { // 여기서 j를 4,5까지만으로 잘랐기 때문에 뒤에 공백 출력됨. 
			if(j >= h - i - 1) System.out.print("*"); // 시작부분만 체크 ex. i=4일때 2부터, i=5일때 1부터 * 찍음
			else System.out.print(" ");
			} System.out.println();
		}
		System.out.println("\n");
		
		// 다이아몬드 찍어보기
		for(i=0; i<=m; i++) {
			for(j=0;j<=h-1;j++) {
				if(j<=m+i && j>=m-i) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		for(i=1; i<=m; i++) {
			for(j=0;j<=(h-1)-i;j++) {
				if(j>=i) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}			
	}	
}
