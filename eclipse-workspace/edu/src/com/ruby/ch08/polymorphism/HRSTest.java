package com.ruby.ch08.polymorphism;

abstract class Employee {
	String name;
	int salary;

	public abstract void calcSalary();

	public abstract void calcBonus();
}

class Salesman extends Employee {
	public int annual_sales;

	public void calcSalary() {
		System.out.println("Salesman �޿� = �⺻�� + �Ǹ� ����");
	
	}

	public void calcBonus() {
		System.out.println("Salesman ���ʽ� = �⺻�� * 12 * 4");
	}
}

class Consultant extends Employee {
	public int num_project;

	public void calcSalary() {
		System.out.println("Consultant �޿� = �⺻�� + ������ Ư�� ����");
	}

	public void calcBonus() {
		System.out.println("Consultant ���ʽ� = �⺻�� * 12 * 2");
	}
}

class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager급여 = 기본급 + 팀 성과 수당");
	}
	public void calcBonus() {
		System.out.println("manager 보너스 = 기본급 * 12 * 6");
	}
	int num_team;

}

class Director extends Manager {
	public void calcBonus() {
		System.out.println("Director ���ʽ� = �⺻�� * 12 * 6");
	}
}


//public class HRSTest {
//	public static void calcTax(Employee e) {
//		System.out.println("소득세를 계산합니다");
//	}
//	
//	public static void main(String[] args) {
//		Salesman s1 = new Salesman();
//		Employee s2 = new Salesman();
//		Object s3 = new Salesman();
//		
//		Object m1 = new manager();
//		Employee m2 = new manager();
//		Manager m3 = new manager();
//		
//		Object arr[] = new Object[6];
//		arr[0] = s1;
//		arr[2] = s2;
//		arr[3] = s3;
//		arr[4] = m1;
//		arr[5] = m2;
//		arr[6] = m3;
//		
//		for(int i = 0; i < arr.length ; i++ ) {
//			System.out.println(arr[i]);
//		}
//		
//		
////		calTax(s);
////		calTax(c);
////		calTax(d);
//	
//		Salesman s2 = s;
//		System.out.println(s2.toString());
//		
//		
//		System.out.println(s.toString());
//		System.out.println(c.toString());
//		System.out.println(d.toString());
//		
//		if(s.equals(s2)) {
//			System.out.println("동일한 객체입니다");
//			
//		} else {
//			System.out.println("서로 다른 객체입니다");
//		}
//	}			
//}
	
public class HRSTest {
	public static void calcTax(Employee e) {
		if(e instanceof Salesman) {
			Salesman s = (Salesman)e;
			s.annual_sales = 650000;
			System.out.println("Salesman 입니다" + s.annual_sales);
			
		}else if(e instanceof Manager) {
			Manager m = (Manager)e;
			m.num_team = 5;
			
			System.out.println("Manager입니다" + m.num_team);
		}else if(e instanceof Consultant) {
			Consultant c = (Consultant)e;
			c.num_project = 35;
			System.out.println("Consultant입니다" + c.num_project);
		}else {
			System.out.println("Employee입니다");
		}
	}
	
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Manager m = new Manager();
		Consultant c = new Consultant();
		
		
		calcTax(s);
		calcTax(m);
		calcTax(c);
		
	}
}






























