package Chap8;

//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link; //포인터

	public Node1(int element) {
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	public LinkedList1() {
		first = null;
	}

	public boolean Delete(int element) //전달된 element 값이 존재 하면 삭제하고 true로 리턴
	{
		Node1 q, current = first; //q랑 current를 첫번쨰 노드로 초기화
		q = current;
		
		if(first == null) {//첫번째 값이 없으면 false반환
			return false;
		}
		if(first.data == element) {//첫번쨰 값이 제거해야 할 값이면 first를 다음으로 넘김
			first = first.link; // 삭제했으니까 true반환
			return true;
		}
		while(q.link != null) {//순환하며 삭제할 값 찾음
			if(q.link.data == element) {//삭제할 값 찾으면
				q.link = q.link.link; // 노드 건너뛰고 연결
				return true;
			}
			q = q.link; //q를 다음 노드로 이동
		}
		return false;//값 못찾으면 false 반환
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first; // p를 초기화
		while(p != null) { //
			System.out.println(p.data + "-> ");
			p = p.link; // p를 다음 값으로 옮김
		}
		System.out.println("리스트 끝");
	}

	public void Add(int element) { // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
		Node1 newNode = new Node1(element);
		if (first == null) // insert into empty list
		{
			first = newNode;
			return;
		}
		//리스트 순회하며 삽입위치찾기
		Node1 p = first , q = null;//p라는 변수를 도입해서 각 노드를 따라간다
		//p는 현재노드 ,  q는 p의 이전노드
		while(p != null) {
			if(element <= p.data) {
				break;
			}
			q = p;//q가p를 따라다닌다
			
			p = p.link;
		}
			
		if(q==null) { //첫번째 노드보다 작은경우
			newNode.link = p;
			first = newNode;
			 //1번처리-첫번쨰 노드에 삽입
		}
		else {//중간 또는 끝에 삽입하는 경우
			q.link = newNode;//2번경우
			newNode.link = p;//q랑 p사이에 새로운 노드 넣음		
		}
	}

	public boolean Search(int data) { //전달된 data 값을 찾아 존재하면 true로 리턴, 없으면 false로 리턴
		Node1 ptr = first;//첫번째 노드로 포인터 초기화
		
		while(ptr != null){//리스트 끝까지 순회
			if(data == ptr.data) {//데이터가 일치하면
				return true;//true반환
			}
			ptr = ptr.link;//다음 노드로 이동
		}
		return false;//끝끼지 찾지못하면 false반환
	}
	void Merge(LinkedList1 b) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상
		 * a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
		
	}
}

public class 실습9_1정수연결리스트 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("합병"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}
		//"Add" 상수가 정의될 때 Menu("삽입") 생성자가 호출되어 message 필드가 "삽입"으로 초기화
		//생성자는 각 상수가 정의될 때 호출되며, 해당 상수의 message 필드를 초기화하는 역할
		//enum 상수가 언제 정의되는가를 찾아 보아야 한다 
		Menu(String string) { // 생성자(constructor)가 언제 호출되는지 파악하는 것이 필요하다 
			message = string;
			System.out.println("\nMenu 생성자 호출:: " + string);
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				//n%3은 3으로 나누어 나머지를 계산한다 
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())//메뉴 출력시에 다음행에 출력하라는 의미
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();//메뉴 선택 번호로 입력된 값이 key이다 
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());//입력된 key가 음수이거나 Exit에 대한 enum 숫자보다 크면 다시 입력받는다 
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴 참조 변수일 뿐이다 
		Random rand = new Random();
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int count = 0; //난수 생성 갯수
		int data = 0;
		do {
			switch (menu = SelectMenu()) {//Menu 생성자 호출 - menu 객체를 리턴한다 
			case Add: // 난수를 삽입하는데 올림차순으로 정렬되도록 구현
				for (int i =0; i < count; i++) {
					data = rand.nextInt(20);
					l.Add(data);
				}
				break;
			case Delete:
				System.out.println("삭제할 값을 입력: ");
				data = sc.nextInt();
				boolean tag = l.Delete(data);
				System.out.println("삭제 데이터 존재여부: " + tag);
				break;
			case Show: //리스트 전체를 출력
				l.Show();
				break;
			case Search: //입력 숫자 n을 검색한다.
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (!result)
					System.out.println("검색 값 = " + n + " 데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + " 데이터가 존재합니다.");
				break;
			case Merge://리스트 l과 l2를 합병하여 올림차순 정렬이 되게 구현한다 
				LinkedList1 l2 = new LinkedList1();
				for (int i =0; i < count; i++) {
					data = rand.nextInt(20);
					l2.Add(data);
				}
				l.Merge(l2);//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
