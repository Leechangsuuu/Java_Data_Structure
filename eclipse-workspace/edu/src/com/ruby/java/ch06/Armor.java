package com.ruby.java.ch06;

class Student{
	private String sname;
	private int age;
	
}
public class Armor {
	private String name;
	private int height;
	
	public String getName() {
		return name;
		
	}
	public void setName(String value) {
		name = value;
	}
	public static void main(String[] args) {
		Armor a[] = new Armor[10];//베열 생성자
			
		a[i]=new Armor();
			
		
		
		// TODO Auto-generated method stub
		Armor a = new Armor();//셍성자
		a.name = "LEE"; // 접근 못한다
//		a.age = 10;
		a.setName("LEE");
		System.out.println(a.getName());
		Student s = new Student();
		s.sname = 
		a.getName();
	}

}
