package com.ruby.java.ch07.abstraction;

public class IPhoneMessenger implements Messenger{
	public String getMessenger() {
		return "IPhone";
	}
	public void setMessenger(String msg) {
		System.out.println("message");
	}
	
}
