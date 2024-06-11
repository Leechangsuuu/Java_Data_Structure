package Chap3;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class train_실습3_4정수배열이진탐색 {

	public static void main(String[] args) {
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련
		Random rnd = new Random();
		int key = new Random().nextInt();
		boolean resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linearsearch는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);
		/*
		 * 교재 109~113
		 */
		key = new Random().nextInt();
		resultIndex = binarySearch1(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndex);
		
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		key = new Random().nextInt();
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);
	
	}
	static void inputData(int []data) {
		Random rnd = new Random();
		for(int i = 0; i <data.length; i ++) {
			data[i] = rnd.nextInt(101);
		}
	}
	static void showList(String str,int []data) {
		System.out.println(str);
		for(int num : data) {
			System.out.println(num + " ");
		}
	}
	static boolean linearSearch(int []data, int key) {
		for(int num : data) {
			if(num == key) {
				return true;
			}
		}
		return false;
	}
	static boolean binarySearch1(int []data, int key) {
		int low = 0;
		int high = data.length - 1;
		while(low <= high) {
			int mid = (low + high) /2;
			if(data[mid] == key) {
				return true;
			}else if (data[mid] < key) {
				low = mid +1;
			}else {
				high = mid -1;
			}
		}
		return false;
	}
	static int binarySearch(int[] data, int key) {

		int min = 0; // 맨 왼쪽 Index
		int max = data.length - 1; // 맨 오른쪽 Index

		while (min <= max) {
		int mid = (min + max) / 2; // 중간 Index를 구하여 검색한다.
		if (data[mid] < key) { // 1. 찾는값이 더 큰 경우 우측에서 찾는다.
		min = mid + 1;
		} else if (data[mid] > key) { // 2. 찾는값이 더 작은 경우 좌측에서  찾는다.
		max = mid - 1;
		} else { // 3. 찾는값을 발견한 경우
		return mid;
			}
		}
	}


















}
