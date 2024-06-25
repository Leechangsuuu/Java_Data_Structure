package Chap8;

/*
 * 정수 리스트 > 객체 리스트> 객체 원형 리스트 
 * 헤드 노드가 있는 원형 리스트, 헤드 노드가 없는 원형 리스트 구현
 * merge 구현: in-place 구현, 새로운 노드를 생성하여 합병 구현 
 * 원형 이중 리스트로 동일하게 적용
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject7 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름
	String expire;//  유효기간 필드를 추가
	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject7(String no, String name) {
		this.no = no;
		this.name = name;
	}
	public SimpleObject7() {// head node를 만들 때 사용
		this.no = null;
		this.name = null;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);

		if ((sw & NO) == NO) { // & 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject7> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject7> {
		public int compare(SimpleObject7 d1, SimpleObject7 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject7> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject7> {
		public int compare(SimpleObject7 d1, SimpleObject7 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

class Node5 {
	SimpleObject7 data;
	Node5 link;

	public Node5(SimpleObject7 element) {
		data = element;
		link = null;
	}
}

class CircularList3 {
	Node5 first;

	public CircularList3() { //head node
		SimpleObject7 data = new SimpleObject7();
		first = new Node5(data);
		first.link = first;
		
	}
	
	
	/*
	 * static void sortData(Fruit []arr, Comparator<Fruit> cc) { for (int i = 0; i <
	 * arr.length; i++) { for (int j = i; j < arr.length; j++) if
	 * (cc.compare(arr[i], arr[j])> 0) swap(arr, i, j); } }
	 */
	public int Delete(SimpleObject7 element, Comparator<SimpleObject7> cc) // delete the element
	{
		Node5 q, current = first.link;
		q = current;
		Node5 prev = first; // 이전 노드를 가리키는 포인터

		while (current != first) {
			if (cc.compare(current.data, element) == 0) {
				prev.link = current.link; 
				return 1; // 삭제 성공
			}
			prev = current;
			current = current.link;
		}
		return -1; // 삭제할 대상이 없다.
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node5 p = first.link;
		SimpleObject7 so;
		while (p != first) {
			so = p.data;
			System.out.print(so + " ");
			p = p.link;
		}
		System.out.println();

	}

	public void Add(SimpleObject7 element, Comparator<SimpleObject7> cc) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node5 newNode = new Node5(element);
		if (first.link == first) {
			first.link = newNode;
			newNode.link = first;
			return;
		} else {
			Node5 current = first.link;
			Node5 prev = first;

			while (current != first && cc.compare(current.data, element) < 0) {
				prev = current;
				current = current.link;
			}
			//if(current == first) {
				newNode.link = current;
				prev.link = newNode;
			//}
//			else {
//				newNode.link = current;
//				prev
//			}
//			
//			prev.link = newNode;
//			newNode.link = current;
		}

	}

	public boolean Search(SimpleObject7 element, Comparator<SimpleObject7> cc) { // 전체 리스트를 순서대로 출력한다.
		Node5 q, current = first.link;

		return false;
	}
	void Merge(CircularList3 b, Comparator<SimpleObject7> cc) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
	}
}

public class 실습9_4객체원형리스트_1 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("합병"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
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
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		CircularList3 l = new CircularList3();
		CircularList3 l2 = new CircularList3();
		Scanner sc = new Scanner(System.in);
		SimpleObject7 data;
		int count = 3;//l2 객체의 숫자를 3개로 한다 

		do {
			switch (menu = SelectMenu()) {
			case Add: //
				data = new SimpleObject7();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject7.NO_ORDER);
				break;
			case Delete: // 
				data = new SimpleObject7();
				data.scanData("삭제", SimpleObject7.NO);
				int num = l.Delete(data, SimpleObject7.NO_ORDER);
				System.out.println("삭제된 데이터 성공은 " + num);
				break;
			case Show: 
				l.Show();
				break;
			case Search: // 회원 번호 검색
				data = new SimpleObject7();
				data.scanData("탐색", SimpleObject7.NO);
				boolean result = l.Search(data, SimpleObject7.NO_ORDER);
				if (result)
					System.out.println("검색 성공 = " + result);
				else
					System.out.println("검색 실패 = " + result);
				break;
			case Merge:
				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
					data = new SimpleObject7();
					data.scanData("병합", 3);
					l2.Add(data, SimpleObject7.NO_ORDER );				
				}
				System.out.println("리스트 l::");
				l.Show();
				System.out.println("리스트 l2::");
				l2.Show();
				l.Merge(l2, SimpleObject7.NO_ORDER);
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 l::");
				l.Show();
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}

