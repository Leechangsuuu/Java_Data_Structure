package chap_2장기본자료구조;

public class 실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후", data);
		
	}
	
	static void showData(String string, String[]data) {
		//확장된 for 문으로 출력 
		System.out.println(string);
		for(String s : data ) {
			System.out.println(s + " ");
		}
	}

	static void swap(String[] data, int idx1, int idx2) {
		//스트링의 맞교환 함수로 sortData()에서 호출됨
		String s = data[idx1];
		data[idx1] = data[idx2]; 
		data[idx2]= s; 
	}
	static void sortData(String[] data) {//올림차순으로 정렬
		for(int i = 0; i < data.length-1;i++ ) {
			for(int j = 0 ; j < data.length-1-i; j++) {
				if(data[j].compareTo(data[j + 1]) > 0) {
					swap(data,j,j+1);
				}
			}
		}
	}
	static String[] insertString(String[] data, String string){
		//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		for()
	}
}
