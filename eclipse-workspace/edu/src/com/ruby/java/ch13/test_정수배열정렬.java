package com.ruby.java.ch13;
/*
 * 정수 배열을 정렬후 출력
 * 실수 배열을 정렬후 출력
 * 스트링 배열을 정렬후 출력하는 코드 완성 
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class test_정수배열정렬 {
	static void showData(Object[]data) {
		
	}
	public static void main(String[] args) {
		Random rand = new Random();
		for(int i = 0; i < 100; i++) {
			int i = rand.nextInt(10);
		}
		int [] data = new int[20]; //int는 객체로 받을수 없다
		System.out.println(Arrays.toString(data));//오룸차순
	    Arrays.sort(data);
	    for (int i = 0; i < data.length / 2; i++) {
	      int temp = data[i];
	      data[i] = data[data.length - 1 - i];
	      data[data.length - 1 - i] = temp;
	    }
	    System.out.println(Arrays.toString(data));//내림차순
		
		
	    double []doubleData = new double[20];
		Arrays.sort(doubleData);
		for (int i = 0; i < doubleData.length / 2; i++) {
		      double temp = doubleData[i];
		      doubleData[i] = doubleData[doubleData.length - 1 - i];
		      doubleData[doubleData.length - 1 - i] = temp;
		}
		System.out.println(Arrays.toString(doubleData));

		
		String []stringData = {"apple","grape","blueberry","banana"};
		Arrays.sort(stringData, Comparator.reverseOrder());
		System.out.println(Arrays.toString(stringData));
		showData(stringData);
		//출력 
		
			
//		
//		
	}
}