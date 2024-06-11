package com.ruby.java.ch06;

public class StaticMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticMethodTest.print1();
		StaticMethodTest smt = new StaticMethodTest();
		smt.print2();

	}
	
	}
	private static void print() {//클래스 메소드
		System.out.println("hh");
		
	}
	
	public void print2(){//인스턴스 메소드
		System.out.println("jj");
	}

}
