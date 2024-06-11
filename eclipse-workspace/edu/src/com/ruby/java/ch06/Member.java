package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;

	public Member() {
		name = "guest";
		age = 0;
	}

	public Member(String name) {
		System.out.print("Member(String) ������ ���� : ");
		System.out.println(name);
	}

	public Member(String name, int age) {
		System.out.print("Member(String, int) ������ ���� : ");
		System.out.println(name + " : " + age);
	}

	public void setName(String name) {
	}

	public static void main(String[] args) {
		System.out.println("main()매서드 실행");
		Member m1=new Member();
		Member m2=new Member("Amy");
		Member m3=new Member("Amy", 23);
	}
}
