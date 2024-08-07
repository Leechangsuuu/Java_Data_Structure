package Chap10;

import java.util.Scanner;
//체인법에 의한 해시
//--- 해시를 구성하는 노드 ---//

class Node {
    int key;                 // 키값
    Node next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)
    public Node(int key, Node next) {
    	this.key = key;
    	this.next = next;
    }
	
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
class SimpleChainHash {
 private int    size;              // 해시 테이블의 크기
 private Node[] table;        // 해시 테이블
 public SimpleChainHash(int capacity) {
	 try {
		 table = new Node[capacity];
		 this.size = capacity;
	 }catch(OutOfMemoryError e) {
		 this.size = 0;
	 }
	
 }
 public int hashValue(Object key) {
	 return key.hashCode() % size;
 }




//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
 public int search(int key) {
	 //주어진 key에 대한 해시값을 계산
	int hash = hashValue(key);
	Node p = table[hash];//계산된 해시값울 사용하여 해당위치의 연결리스트를 가리킴
	while(p != null) {//연결리스트 순회하면서 기값 검색
		if(p.key ==key)//키값이 일치하면 해당 키값에 대한 값 반환
			return p.getValue();
		p = p.next;//다음 노드로 이동
	}
	return 0;//키값 못찾으면 0반환
 }

 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
 public int add(int key) {
	 int hash = hashValue(key);//주어진 key에 대한 해시값 계산
	 Node p = table[hash];//계산된 해시 값을 사용하여 해당 위치의 연결리스트 가리킴
	 
	 //연결리스트 순회하면서 키값이 이미 존재하는지 확린
	 while(p!=null) {
		 if(p.key == key)//현재 노드의 키값이 주어진 키값과 일치하는지 확인
			 return 1;//키가 이미 존재하면 1반환
		 p = p.next;//다음 노드로 이동
	 }
	 //키가 존재하지 않으면 새노드를 생성하고 리스트의 맨앞에 추가
	 Node temp = new Node(key,table[hash]);
	 table[hash]=temp;//노드 삽입
	 
	 return 0;//새로운 키가 추가되었음을 나타내기 위해 0반환
 }

 //--- 키값이 key인 요소를 삭제 ---//
 public int delete(int key) {
	 int hash = hashValue(key);//주어진 키에 대한 해시값 계산
	 Node p = table[hash];//계산된 해시 값을 사용하여 해당 위치의 연결리스트 가리킴
	 Node pp = null;//바로 앞의 선택노드
	 
	 while(p != null) {
		 if(p.key == key) {//현재 노드의 키값이 주어진 키값과 일치하는지 확인
			 if(pp == null) {//바로 앞의 노드가 없으면(현재 노드가 첫번째 노드인 경우)
				 table[hash] = p.next;//현재 노드의 다음 노드를 해당 해시 위치에 저장
			 }
			 else//바로 앞의 노드가 있는 경우
				 pp.next = p.next;//앞 노드의 다음 노드를 현재 노드의 다음 노드호 설정
			 return 0;//키가 삭제되었음을 나타내기 위해 0반환
		 }
		 pp = p;//pp는 현재 노드를 가리키고
		 p = p.next;//p는 다음 노드로 이동
	 }
	 return 1;
 }

 //--- 해시 테이블을 덤프(dump) ---//
 public void dump() {
	 for(int i = 0; i <size; i++) {
		 Node p = table[i];
		 System.out.printf("%02d ",i);
		 while(p!=null) {
			 System.out.printf("-> %s (%s) ", p.getKey(), p.getValue());
			 p = p.next;
		 }
		 System.out.println();
	 }
 }


public int getSize() {
	return size;
}


public void setSize(int size) {
	this.size = size;
}


public Node[] getTable() {
	return table;
}


public void setTable(Node[] table) {
	this.table = table;
}
}

public class Test_실습10_1정수체인해시 {

	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), Show("출력"), Exit("종료");

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


//체인법에 의한 해시 사용 예
 public static void main(String[] args) {
	 	Menu menu;
		SimpleChainHash hash = new SimpleChainHash(11);
		Scanner stdIn = new Scanner(System.in);
		int select = 0, result = 0, val = 0;
		final int count = 15;
		do {
			switch (menu = SelectMenu()) {
			case Add:

				int[] input = new int[count];
				for (int ix = 0; ix < count; ix++) {
					double d = Math.random();
					input[ix] = (int) (d * 20);
					System.out.print(" " + input[ix]);
				}
				for (int i = 0; i < count; i++) {
					if ((hash.add(input[i])) == 0)
						System.out.println("Insert Duplicated data");
				}
				break;
			case Delete:
				// Delete
				System.out.println("Search Value:: ");
				val = stdIn.nextInt();
				result = hash.delete(val);
				if (result == 1)
					System.out.println(" 검색 데이터가 존재한다");
				else
					System.out.println(" 검색 데이터가 없음");
				System.out.println();
				break;
			case Search:
				System.out.println("Search Value:: ");
				val = stdIn.nextInt();
				result = hash.search(val);
				if (result == 1)
					System.out.println(" 검색 데이터가 존재한다");
				else
					System.out.println(" 검색 데이터가 없음");
				System.out.println();
				break;

			case Show:
				hash.dump();
			break;
		}
	} while (menu != Menu.Exit);

	}
}
