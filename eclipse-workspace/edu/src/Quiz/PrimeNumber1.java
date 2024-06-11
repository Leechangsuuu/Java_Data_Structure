package Quiz;

import java.util.Scanner;

public class PrimeNumber1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {

			System.out.print("Number[0:exit]:");

			int num = sc.nextInt();

			if (num == 0) break;

			if(isPrime(num) == true) {
				System.out.println(num + " is a Prime.");
				
			}else {
				System.out.println(num + " is not a Prime.");
			}
		}
		sc.close();
		System.out.println("Done!");
	}
	// num이 소수면 true, 그렇지 않으면 false를 리턴
	public static boolean isPrime(int n) {
		if(n == 1) return false;
		if(n == 2 || n == 3) return true;
		// 코드 작성
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	

}
