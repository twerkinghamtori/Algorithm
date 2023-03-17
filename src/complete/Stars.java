package complete;

/*
 * 삼각형의 높이를 입력받아 *로 삼각형을 출력하기
 * [결과]
 * 삼각형의 높이
 * 3
 *         i        j
 1:*       1        1
   **      2        1 2
   ***     3        1 2 3
 
 2:***     1        1 2 3
   **      2        1 2
   *       3        1
 
 3:  *     3            3
    **     2          2 3
   ***     1        1 2 3
 
 4:***     1        1 2 3
    **     2          2 3
     *     3            3
 */
import java.util.Scanner;
public class Stars {
	public static void main(String[] args) {
		
		//1
		System.out.println("1: 삼각형의 높이");
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		
		for (int i=1; i<=h; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print("*"); //조건문 만족하지 않을때까지 여기서 반복, 만족하지 않으면 위의 반복문으로 이동.
			} System.out.println();
		}
		//2
		System.out.println("2: 삼각형의 높이");
		for (int i=1; i<=h; i++) {
			for (int j=h; j>=i; j--) {
				System.out.print("*"); 
			} System.out.println();
		}
	
		//3
		System.out.println("3: 삼각형의 높이");
		for (int i=h; i>=1; i--) {
			 for(int j=1; j<=h; j++) {if(j>=i) {System.out.print("*");} 
			                          else if (j<i) {System.out.print(" ");} // 31, 32, 21
			 }System.out.println();
		}
		
		//4
		System.out.println("4: 삼각형의 높이");
		for (int i=1; i<=h; i++) {
			for(int j=1; j<=h; j++) {
				if(j>=i) {System.out.print("*");}
				else if (j<i) {System.out.print(" ");}
			} System.out.println();
		}
		
		/*5
		 *   *     0  1    2   2-0 ~ 2+0 : *
		 *  ***    1  2   123  2-1 ~ 2+1 : *
		 * *****   2  3  01234 2-2 ~ 2+2
		 * h=1: 바닥 : 1
		 * h=2: 바닥 : 3
		 * h=3: 바닥 : 5
		     
		*/
		System.out.println("5: 삼각형의 높이");
		
		int b = h*2-1; // 바닥의 * 갯수
		int m = b/2; // *중간 인덱스
		for(int i=0; i<h; i++) {
			for(int j=0;j<b;j++) {
				if(j >= m-i && j <=m+i) // m-i <= j <= m+i
					System.out.print("*");
				else 
					System.out.print(" ");
			}
			System.out.println();
			
	    //배열로 풀어보기
		}			
    }
}