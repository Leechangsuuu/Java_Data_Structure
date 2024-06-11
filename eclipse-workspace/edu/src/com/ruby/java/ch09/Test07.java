package com.ruby.java.ch09;

public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "한국,일본,중국,미국,독일,프랑스";
		
		
		String[] list = s.split(".");
		String[] list2 = s.split(".",2);
		
		for(String item : list) {
			System.out.println(item);
		}
		System.out.println("==============");
		for(String item: list2) {
			System.out.println(item);
		}
		System.out.println("==============");
		
		
		String email = "purim@rubypaper.co.kr";
		int i = email.index("@");
		
		String id = email.substring(0,i);
		
	}

}
