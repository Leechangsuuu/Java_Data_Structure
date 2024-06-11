package chap_2장기본자료구조;

import java.lang.reflect.Array;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 */

import java.util.Arrays;
import java.util.Random;


public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		double [][]A = new double[2][3];
		double [][]B = new double[3][4];
		double [][]C = new double[2][4];

		inputData(A);
		inputData(B);
		double [][]D = A.clone();//교재83 - 배열 복제
	
		showData("A[2][3] = ",A);
		
		showData("D[2][3] = ",D);
	
		
		showData("B[3][4] = ",B);
		double [][]E = addMatrix(A,D);//행렬 덧셈
	
		showData("E[2][3] = ",E);
		C = multiplyMatrix(A,B);//행렬 곱셈
	
		showData("C[2][4] = ",C);

		double [][]F = transposeMatrix(A);//전치 행렬
		
		showData("F[3][2] = ",F);
		boolean result = equals(A, D);//행렬 동등 비교
		System.out.println(" equals(A,D) = " + result);
			
		System.out.println("F = " + Arrays.deepToString(F));//2차원 배열 처리 
	}
		
	
	static void inputData(double [][]data) {
		//double 난수 0.0 ~ 1.0 생성
		Random rnd = new Random();
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				data[i][j] = rnd.nextDouble(1.0);
			}
		}
	}
	static void showData(String str, double [][]data) {
		System.out.println(str);
		//주어진 문자열을 출력하고 배열을 2차원 형태로 출력
		//System.out.printf(str ,Arrays.toString(data));
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]+"       "); 
			}
			System.out.println();
		}
	}
	static boolean equals(double[][]A,double[][]D) {
		//두 행렬의 사이즈가 같고 값도 모두 같아야 행렬 2개는 equals을 true로 리턴
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length;j++ ) {
				if ( A[i][j] != D[i][j]) {
					return false;
				}
			}
		}
		return true;

	}
	static double[][] addMatrix(double[][]A,double[][]D) {
		//행렬 덧셈 결과를 리턴
		double[][]E = new double[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for(int j = 0; j< A[0].length; j++) {
				E[i][j] = A[i][j] + D[i][j]; 
			}
		}	
		return E;
	}
	static double[][] multiplyMatrix(double[][]A,double[][]B) {
		//행렬 곱셈 결과를 리턴
		double[][]C = new double[A.length][B[0].length];
		for( int i =0; i <A.length;i++) {
			for(int j = 0; j<B[0].length;j++) {
				int temp = 0;
				for(int k = 0; k < B.length; k++) {
					temp += A[i][k] * B[k][j];
				}
				C[i][j] = temp;
			}
		}
		return C;
	}
		
	
	static double[][] transposeMatrix(double[][] A) {
		//전치 행렬을 리턴
		double[][] F = new double[A[0].length][A.length];
		for(int i = 0; i < A.length; i++) {//row
			for(int j = 0; j < A[0].length; j++) {//col
				F[j][i] = A[i][j];
			}
		}
		return F;
		
	
	}
}
