package com.ruby.java.ch09;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("java");
		String s2 = "java";
		
		String s3 = new String("java");
		String s4 = "java";
		
		if(s1 == s3) {
			System.out.println("동일");
		}else {
			System.out.println("다름");
		}
		
		
		if(s2 == s4) {
			System.out.println("동일");
		}else {
			System.out.println("다름");
		}
		if(s1.equals(s3)) {
			System.out.println("동일");
		}else {
			System.out.println("다름");
		}
		if(s2.equals(s4)) {
			System.out.println("동일");
		}else {
			System.out.println("다름");
		}
		String s5 = "java";
		
		if(s1.equals(s5)) {
			System.out.println("동일");
		}else {
			System.out.println("다름");
		}
		if(s1.equalsIgnoreCase(s5)) {
			System.out.println("동일");
		}else {
			System.out.println("다름");
		}
		
		
		
	}

}
