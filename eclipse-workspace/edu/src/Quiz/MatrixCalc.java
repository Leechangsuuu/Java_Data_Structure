package Quiz;


import java.util.Scanner;

public class MatrixCalc {
	
	private int[][] matrix = new int[3][3];
	
	public void work(boolean flag) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("n?");
		int n = sc.nextInt();
		System.out.println("m?");
		int m = sc.nextInt();
		Math.random();
		int matrix[][];
		matrix = new int [n][m];
		
		int sum = 0;
		for( int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
				sum = sum + matrix[i][j];
			}
		}
		for( int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				matrix[j][i] = sc.nextInt();
				sum = sum + matrix[j][i];
			}
		}
		System.out.println(sum);
		sc.close();		
	}
	
	
}
		//가로합출력
		//1+2+3,matrix[0][0]+matrix[0][1]+matrix[0][2]
		//4+5+6,matrix[1][0]+matrix[1][1]+matrix[1][2]
		//7+8+9 matrix[2][0]+matrix[2][1]+matrix[2][2]
//		for(int j = 0; j<3; j++) {
//			int sum = 0;
//			for(int i=0 ; i<3; i++) {
//				sum = sum + matrix[j][i];
//			}
//			System.out.println(sum);
//			
//		}
//		//1+4+7,matrix[0][0]+matrix[1][0]+matrix[2][0]
//		//2+5+8,matrix[0][1]+matrix[1][1]+matrix[2][1]
//		//3+6+9 matrix[0][2]+matrix[1][2]+matrix[2][2]
//		for(int j = 0; j<3; j++) {
//			int sum = 0;
//			for(int i = 0; i<3; i++) {
//				sum = sum + matrix[i][j];
//			}
//			System.out.println(sum);
//		}	

public void 


