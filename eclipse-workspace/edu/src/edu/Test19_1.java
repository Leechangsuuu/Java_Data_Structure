package edu;

public class Test19_1 {

	public static void main(String[] args) {
		// 점수 초기값을 입력한다
		int score = 70; 
		//결과 문자열을 초기화한다
		
		String result = "";
		//점수가 60점 이상인지 비교한다
		if(score >= 60){
			result = "합격";
			
		}
        
		System.out.println(result);
	}

}
