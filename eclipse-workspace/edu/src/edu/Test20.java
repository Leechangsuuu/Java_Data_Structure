package edu;

import java.util.Scanner;

public class Test20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		int score = sc.nextInt();
//		System.out.println("점수입력:");
//		char grade;
		
		//표준입력장치로부터 입력을 받기 위한 입력객체를 생성한다
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번쨰 점수:");
		int a = sc.nextInt();//정수형 값을 입력받아서 변수a에 저장한다
		
		System.out.print("첫번쨰 점수:");
		int b = sc.nextInt();//정수형 값을 입력받아서 변수b에 저장한다
		
		System.out.print("op:");//문자열 값을 입력받기위한 메세지를 화면에 출력한다
		String ops = sc.next();//문자열을 입ㅇ력받아서 문자열 변수에 저장
		char op = ops.charAt(b);//ops에 저장된 첫번쨰 문자를 문자변수 op에 저장
				
		if(score >= 90){
	       grade = 'A';
		} else if(score >= 80){
		   grade = 'B';
		} else if(score >= 70){
		   grade = 'C';
		} else if(score >= 60){
		   grade = 'D';
		} else {
		   grade = 'F';
		}
		System.out.println(grade);

	}

}
