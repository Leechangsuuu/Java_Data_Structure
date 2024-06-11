package com.ruby.java.ch11;

import java.io.FileInputStream;

public class Test04 {

	public static void main(String[] args) {
		FileInputStream fi = new FileInputStream("a.txt");
		int c = fi.read();
		System.out.println((char) c);
			
	}

}
