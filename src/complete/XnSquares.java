package complete;

/*
 * 11*11 크기의 사각형이 있다고 가정할때 다음 결과를 출력되도록 프로그램 작성하기
X□■□■□■□■□X
□X□■□■□■□X□
■□X□■□■□X□■
□■□X□■□X□■□
■□■□X□X□■□■
□■□■□X□■□■□
■□■□X□X□■□■
□■□X□■□X□■□
■□X□■□■□X□■
□X□■□■□■□X□
X□■□■□■□■□X
*/
public class XnSquares {
	public static void main(String[] args) {
		String square[][] = new String[11][11];
		
		for(int i=0; i<=5; i++) {
			  square[i][i] = "X";
	          square[i][10-i] = "X";
		}
		for(int i=6; i<square.length; i++) {
			square[i][10-i] = "X";
			square[i][i] = "X";
		}
		for(int i=0; i<=5; i++) {
			for(int j=0; j<=4; j++)
			square[2*i][2*j+1] = "□";
		}
		for(int i=0; i<=4; i++) {
			for(int j=0; j<=5; j++) {
				square[2*i+1][2*j] = "□";
			}
		}
		for(int i=0; i<square.length; i++) {
			for(int j=0; j<square[i].length; j++) {
				if(square[i][j]==null) System.out.print("■");
				else System.out.print(square[i][j]);
			}System.out.println();
		}
		
		

	}
}