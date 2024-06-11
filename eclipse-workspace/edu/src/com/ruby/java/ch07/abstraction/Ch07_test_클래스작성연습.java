package com.ruby.java.ch07.abstraction;
//7장 실습 구현 
abstract class Person {
	int pid;
	String name;
	int age;
	public Person(int pid, String name, int age) {//생성자
		this.pid=pid;
		this.name=name;
		this.age=age;
	}
	public String toString() {//서로 다른 결과를 반환
		return pid + "," + name + "," + age + ",";
	}
}

class Student extends Person {
	//sid, dept, year
	int sid;
	String dept;
	int year;
	//super 사용
	public Student(int pid, String name, int age, int sid, String dept, int year) {
		super(pid, name,age);
		this.sid=sid;
		this.dept=dept;
		this.year=year;
	}

	@Override
	public String toString() {
		return super.toString()+ sid + "," + dept + "," + year;
	}

}
class Employee2 extends Person {
	//eno, dept, salary
	int eno;
	String dept;
	int salary;
	//super 사용
	public Employee2(int pid, String name, int age, int eno, String dept,int salary) {
		super(pid,name,age);
		this.eno=eno;
		this.dept=dept;
		this.salary=salary;
	}
	public String toString() {
		return super.toString() + eno + "," + dept + "," + salary;
	}
}

public class Ch07_test_클래스작성연습 {

	public static void main(String[] args) {
		Person arr[] = new Person[5];
		arr[0] = new Student(1, "Kim", 20, 1001, "Computer Science", 3);
		arr[1] = new Student(2, "Lee", 21, 1002, "Mathematics", 2);
		arr[2] = new Employee2(3, "Park", 30, 2001, "HR", 3000);
		arr[3] = new Employee2(4, "Choi", 35, 2002, "Engineering", 4000);
		arr[4] = new Student(5, "Kang", 22, 1003, "Physics", 4);
		for(Person p : arr) {
			System.out.println(p.toString());
		}

	}

}
