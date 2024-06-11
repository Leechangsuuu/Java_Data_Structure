package com.ruby.java.ch06;
class Count{
	public static int totalCount;
	private int num;
	public Count() {
		num = 1;
		totalCount++;
	}
	

}
	
public class CountTest {

	public static void main(String[] args) {
		System.out.println(Count.totalCount);
//		System.out.println(Count.num);
		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();
		c1.num++;
		System.out.println(c3.totalCount);
		System.out.println(c1.totalCount);
		System.out.println(Count.totalCount);
	}

}
