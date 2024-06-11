package com.ruby.java.ch14;

import java.util.ArrayList;
/*
 * public interface Comparator<T>{
 *    int compare(T 01, T 02);
 *    }
 *    
 * public interface Comparable<T> {
 *   public int compareTo(T o);
 *   }   
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
class Student {
	String sno;
	String sname;

	public Student(String sno, String sname){
		this.sno = sno;
		this.sname = sname;
	}
	public String getSno() {
		return this.sno;
	}
	public String getSname() {
		return this.sname;
	}
	
	public String toString() {
		return sno +' '+ sname; 
	}
}
public class test_객체배열리스트정렬comparator {
	
	static void sortStudents(String sname, Student[] s) {
		System.out.println(sname);
		for(Student stu : s)
			System.out.println(stu);
	}
	static void showStudents(String msg, Student[] s) {
		System.out.println(msg);
		for(Student st : s)
			System.out.println(st);
	}
	public static void main(String[] args) {
		Comparator<Student> compSno = new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {
				return Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
			}
			};
	
		Comparator<Student> compSname = new Comparator<Student>(){
			
			public int compareTo(Student s1  Student s2) {
				return (compareTo(s1.sname , s2.sname));
			}
			};
	
        Student[] sArray = new Student[5];
        
        // Student 객체 생성 및 배열에 할당
        sArray[0] = new Student("121", "Alice");
        sArray[1] = new Student("33", "Bob");
        sArray[2] = new Student("9", "Charlie");
        sArray[3] = new Student("2", "John");
        sArray[4] = new Student("39", "Bobby");
        // ArrayList로 변환
        ArrayList<Student> sList = new ArrayList<>();
        for (Student student : sArray) {
            sList.add(student);
        }
           
        showStudents("sno 정렬전", sArray);
        //문제1: Arrays.sort()를 사용한 sArray 정렬 - sno 사용, 익명클래스 사용
//        Arrays.sort(sArray);
        Arrays.sort(sArray, compSno);
        showStudents("sno 정렬후", sArray);
        
        showStudents("sname 정렬전", sArray);
        //문제2: Arrays.sort()를 사용한 sArray 정렬 - sname 사용, 익명 객체 사용
        Arrays.sort(sArray,compSname);
        showStudents("sname 정렬후", sArray);
        
        showStudents("sno 정렬전", sList);
        //문제3: Collections.sort()를 사용한 sList 정렬 - sno 사용, 람다식 사용
        
        showStudents("sno 정렬후", sList);
        
        showStudents("sname 정렬전", sList);
        //문제4: Collections.sort()를 사용한 sList 정렬 - sname 사용
        Collections.sort(sList,람다식으로 표현);
        showStudents("sname 정렬후", sList);
        
        showStudents("sno 정렬전", sArray);
        //문제5: sortStudents()를 사용한 sArray 정렬 - sno 사용
        showStudents("sname 정렬후", sArray);
	}

}


