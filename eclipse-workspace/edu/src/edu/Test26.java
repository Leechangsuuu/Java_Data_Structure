package edu;

import java.util.Scanner;

public class Test26 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("반복횟수:");
		int a = sc.nextInt();
		int i = 0;
		
		while(i<a) {
			System.out.println(i);
			i++;
		}
		System.out.println("OK");
	}

}
