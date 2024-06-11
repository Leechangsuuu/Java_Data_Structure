package Quiz;

import java.util.Scanner;

public class Dada1 {

	public static void main(String[] args) {
		//두 수를 입력받아서 곱을 출력
		//앞의 수를 뒤의 수로 나누어서 몫과 나머지를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째수를 입력하시오.:");
		int a = sc.nextInt();
		System.out.print("두번째수를 입력하시오.:");
		int b = sc.nextInt();
			System.out.println("곱은" + a*b + "몫은" + a/b + "나머지는" + a%b );

	}
	

}

