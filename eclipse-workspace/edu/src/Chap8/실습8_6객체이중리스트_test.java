package Chap8;
/*
 * 정수 리스트 > 객체 리스트 >
 * * 헤드 노드가 있는 원형 리스트, 헤드 노드가 없는 원형 리스트 구현
 * merge 구현: in-place 구현, 새로운 노드를 생성하여 합병 구현 
 * 원형 이중 리스트로 동일하게 적용
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject2 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?
	String no; // 회원번호
	String name; // 이름
	String expire;//  유효기간 필드를 추가

	public SimpleObject2(String sno, String sname, String expire) {
		this.no = sno;
		this.name = sname;
		this.expire = expire;
	}
	public SimpleObject2() {
		this.no = null;
		this.name = null;
	}
	// --- 문자열 표현을 반환 ---//
	@Override
	public String toString() {
		return "(" + no + ") " + name;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}
	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject2> {
		@Override
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : ((d1.no.compareTo(d2.no) < 0)) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject2> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject2> {
		@Override
		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
			return (d1.name.compareTo(d2.name) > 0) ? 1 : ((d1.name.compareTo(d2.name) < 0)) ? -1 : 0;
		}
	}
}

class Node4 {
	SimpleObject2 data; // 데이터
	Node4 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
	Node4 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)
	public Node4(SimpleObject2 data){
		this.data = data;//생성자
		llink = rlink = this;
	}
}

class DoubledLinkedList2 {
	private Node4 first; // 머리 포인터(참조하는 곳은 더미노드)

	// --- 생성자(constructor) ---//
	public DoubledLinkedList2() {
		first = new Node4(null); // dummy(first) 노드를 생성
		
	}

	// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return first.rlink == first;
	}

	// --- 노드를 검색 ---//
	public boolean search(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 p, current = first;//초기화
		p = current;
		p = first.rlink;//실제 노드는 첫번쨰 노드임
		while(p != first) {
			if(c.compare(obj, p.data) == 0) {
				current = p;
				return true;
			}
			p = p.rlink;//다음 노드로 이동
		}
		return false;
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node4 p = first.rlink;//실제 첫번쨰 노드
		if(p==first) {//비어있을때
			System.out.println("리스트가 비어 있습니다");
			return;
		}
		do {
			System.out.print(p.data + "->");
			p = p.rlink;
		}
		while(p != first);
		System.out.println("리스트 끝!");
	}

	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 newNode = new Node4(obj);
		Node4 p = first;
		if(p.rlink == p) {//비어있을때
			newNode.llink = p;//새로운 노드의 앞,뒤 모두 p가리킴
			newNode.rlink = p;
			p.rlink = newNode;//p도 새로운노드 가리킴
			p.llink = newNode;
			return;
		}
		//p의 다음 노드가 first가 아니면서 obj이 p의 다음 값보다 큰 동안 반복
		while(p.rlink != first && c.compare(obj , p.rlink.data) >0) {
			p = p.rlink;//다음 으호 이동
		}
		newNode.rlink = p.rlink;
		newNode.llink = p;
		p.rlink.llink = newNode;
		p.rlink = newNode;
		return;
		}


	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
		Node4 current = first.rlink;

		while(current != first) {//끝까지반복
			if(c.compare(current.data, obj) == 0) {//입력받은 값과 같으면
				current.llink.rlink = current.rlink;//값 삭재(currentd의 왼쪽이 current의 오른쪽에 있는 걸 가리킴 -> current 삭제된
				if(current.rlink != first) {
					current.rlink.llink = current.llink;
				}
				return;
			}
			current = current.rlink;
		}
	}
	public DoubledLinkedList2 merge_NewList(DoubledLinkedList2 lst2, Comparator<SimpleObject2> cc) {
		//l3 = l1.merge(l2); 실행하도록 리턴 값이 리스트임 
		//l.add(객체)를 사용하여 구현
		//기존 리스트의 노드를 변경하지 않고 새로운 리스트의 노드들을 생성하여 구현 
		DoubledLinkedList2 lst3 = new DoubledLinkedList2();
		Node4 ai = this.first.rlink, bi = lst2.first.rlink;



		return lst3;

	}
	void merge_InPlace(DoubledLinkedList2 b, Comparator<SimpleObject2> cc) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
		Node4 p = first.rlink, q = b.first.rlink;
		Node4 temp = null;


	}
}

public class 실습8_6객체이중리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge_NewList("병합-새리스트"), Merge_InPlace("병합-제자리"), Exit("종료");

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
		Scanner sc1 = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc1.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Scanner sc2 = new Scanner(System.in);
		DoubledLinkedList2 lst1 = new DoubledLinkedList2(),	lst2 = new DoubledLinkedList2();
		DoubledLinkedList2 lst3 = new DoubledLinkedList2(), lst4 = new DoubledLinkedList2();
		String sno1 = null, sname1 = null;
		SimpleObject2 so;
		boolean result = false;
		int count = 3;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 객체들의 올림차순으로 정렬되도록 구현
				so =  new SimpleObject2();
				so.scanData("입력", 3);
				lst1.add(so, SimpleObject2.NO_ORDER);
				SimpleObject2 [] simpleobjects = new SimpleObject2[10];
				makeSimpleObjects(simpleobjects);
				for (int i = 0; i < simpleobjects.length;i++)
					lst1.add(simpleobjects[i], SimpleObject2.NO_ORDER );
				break;
			case Delete: // 임의 객체를 삭제
				so =  new SimpleObject2();
				so.scanData("삭제", SimpleObject2.NO);
				lst1.delete(so, SimpleObject2.NO_ORDER);
				break;
			case Show: // 리스트 전체를 출력
				lst1.show();
				break;
			case Search: // 회원 번호 검색
				so =  new SimpleObject2();
				so.scanData("탐색", SimpleObject2.NO);
				result = lst1.search(so, SimpleObject2.NO_ORDER);
				if (!result)
					System.out.println("검색 값 = " + so + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + so + "데이터가 존재합니다.");
				break;
			case Merge_NewList://기존 2개의 리스트를 합병하여 새로운 리스트를 생성(새로운 노드를 생성하여 추가)
//				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
//					so = new SimpleObject2();
//					so.scanData("병합", 3);
//					lst2.add(so, SimpleObject2.NO_ORDER );				
//				}
				SimpleObject2 [] simpleobjects2 = new SimpleObject2[10];
				makeSimpleObjects2(simpleobjects2);
				for (int i = 0; i < simpleobjects2.length;i++)
					lst2.add(simpleobjects2[i], SimpleObject2.NO_ORDER );
				System.out.println("리스트 lst1::");
				lst1.show();
				System.out.println("리스트 lst2::");
				lst2.show();
				lst3= lst1.merge_NewList(lst2, SimpleObject2.NO_ORDER);
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 lst3::");
				lst3.show();	
				break;
			case Merge_InPlace:
//				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
//					so = new SimpleObject2();
//					so.scanData("병합", 3);
//					lst4.add(so, SimpleObject2.NO_ORDER );				
//				}
				SimpleObject2 [] simpleobjects3 = new SimpleObject2[10];
				makeSimpleObjects3(simpleobjects3);
				for (int i = 0; i < simpleobjects3.length;i++)
					lst4.add(simpleobjects3[i], SimpleObject2.NO_ORDER );
				System.out.println("리스트 lst2::");
				lst2.show();
				System.out.println("리스트 lst4::");
				lst4.show();
				lst4.merge_NewList(lst2, SimpleObject2.NO_ORDER);
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 lst4::");
				lst4.show();
			case Exit: // 
				break;
			}
		} while (menu != Menu.Exit);
	}
	static void makeSimpleObjects(SimpleObject2 []simpleobjects) {
        simpleobjects[0] = new SimpleObject2("s8", "hong", "240618");
        simpleobjects[1] = new SimpleObject2("s2", "kim", "240619");
        simpleobjects[2] = new SimpleObject2("s3", "lee", "240601");
        simpleobjects[3] = new SimpleObject2("s1", "park", "240621");
        simpleobjects[4] = new SimpleObject2("s4", "choi", "240622");
        simpleobjects[5] = new SimpleObject2("s6", "jung", "240611");
        simpleobjects[6] = new SimpleObject2("s7", "kang", "240624");
        simpleobjects[7] = new SimpleObject2("s5", "jo", "240615");
        simpleobjects[8] = new SimpleObject2("s19", "oh", "240606");
        simpleobjects[9] = new SimpleObject2("s10", "jang", "240607");
 
	}
	static void makeSimpleObjects2(SimpleObject2 []simpleobjects) {
        simpleobjects[0] = new SimpleObject2("s5", "song", "240608");
        simpleobjects[1] = new SimpleObject2("s2", "Lim", "240609");
        simpleobjects[2] = new SimpleObject2("s3", "kee", "240601");
        simpleobjects[3] = new SimpleObject2("s1", "park", "240611");
        simpleobjects[4] = new SimpleObject2("s8", "choo", "240612");
        simpleobjects[5] = new SimpleObject2("s9", "jong", "240618");
        simpleobjects[6] = new SimpleObject2("s4", "jang", "240614");
        simpleobjects[7] = new SimpleObject2("s7", "go", "240605");
        simpleobjects[8] = new SimpleObject2("s11", "na", "240616");
        simpleobjects[9] = new SimpleObject2("s10", "you", "240617");
 
	}
	static void makeSimpleObjects3(SimpleObject2 []simpleobjects) {
        simpleobjects[0] = new SimpleObject2("s5", "song", "240608");
        simpleobjects[1] = new SimpleObject2("s2", "Lim", "240609");
        simpleobjects[2] = new SimpleObject2("s3", "kee", "240601");
        simpleobjects[3] = new SimpleObject2("s1", "park", "240611");
        simpleobjects[4] = new SimpleObject2("s8", "choo", "240612");
        simpleobjects[5] = new SimpleObject2("s9", "jong", "240618");
        simpleobjects[6] = new SimpleObject2("s4", "jang", "240614");
        simpleobjects[7] = new SimpleObject2("s7", "go", "240605");
        simpleobjects[8] = new SimpleObject2("s11", "na", "240616");
        simpleobjects[9] = new SimpleObject2("s10", "you", "240617");
 
	}
}
