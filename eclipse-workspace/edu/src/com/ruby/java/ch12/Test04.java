package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedReader;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt));"
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			byte[] buf = new byte[1024];
			int len = 0;
			while(len = in.read(buf)) != -1) {
			
		}
		}
	}

}
