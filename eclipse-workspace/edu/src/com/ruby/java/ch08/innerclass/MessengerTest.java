package com.ruby.java.ch08.innerclass;

public class MessengerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Messenger test = new Messenger() {
			public void setMessage(String msg) {
				System.out.println("test에서 메시지룰 설정합니다 : " + msg);
			}
			public String getMessage() {
				return "test";
			}
			
		};
		System.out.println(test.getMessage());
		test.setMessage("hahahahaha");
		
		
	}

}
