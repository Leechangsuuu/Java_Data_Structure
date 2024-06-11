package com.ruby.java.test2;

public class Test02 {

	static void test(String name, int...v) {
		System.out.print(name + ":");
		for(int x : v) 
			System.out.print(x + " ");
		System.out.println();
	}

	
	public static void main(String[] args) {
		test("오정임", 98,85,88);
		test("김푸름", 90,95,93);
		test("김하늘", 89,97,85);
	}

}
