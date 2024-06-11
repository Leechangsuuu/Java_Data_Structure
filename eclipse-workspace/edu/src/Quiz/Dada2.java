package Quiz;

import java.util.Scanner;

public class Dada2 {

	public static void main(String[] args) {
		//0보다 큰 하나의 정수를 입력받아서 전체 합, 홀수 합, 짝수 합응 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자:");
		int n = sc.nextInt();
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 1; i <= n; i++ ){
			if( i % 2 == 0)
				sum2 += 1;
				else
					sum1 += 1;
				
		}
		System.out.println("합:"+ (sum1 + sum2));
		System.out.println("합1:"+ (sum1));
		System.out.println("합2:"+ (sum2));
	}
	
}
