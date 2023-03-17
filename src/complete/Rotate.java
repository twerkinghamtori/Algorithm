package complete;

/*
 주어진 배열을 시계방향으로 90도 회전시켜서  출력하는 프로그램을 완성하시오.
주어진 배열에 값
  **  
  **  
  *****
  *****
[결과]
  ****
  ****
  ** 
  ** 
  ** 
 */
public class Rotate {
	public static void main(String[] args) {
		char[][] star = { { '*', '*', ' ', ' ', ' ' }, 
				          { '*', '*', ' ', ' ', ' ' }, 
				          { '*', '*', '*', '*', '*' },
				          { '*', '*', '*', '*', '*' } 
				          };

		for(int i=0; i<5; i++) {
			for(int j=3; j>=0; j--) {
				System.out.print(star[j][i]);
			}
			System.out.println();
		}
		
		
	}
}