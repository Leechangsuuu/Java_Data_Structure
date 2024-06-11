package com.ruby.java.test1;

public class Test {

	public static void main(String[] args) {
		
		Armor armor = new Armor();
		
		armor.setData("PARK", 160, "PINK");
		
		System.out.println(armor.name);
		armor.setName("SIA");
		System.out.println(armor.name);
		
		System.out.println(armor.height);
		armor.setHeight(190);
		System.out.println(armor.height);
		
		System.out.println(armor.color);
		armor.setcolor("BLUE");
		System.out.println(armor.color);
		
		
		
		
		

	}

}
