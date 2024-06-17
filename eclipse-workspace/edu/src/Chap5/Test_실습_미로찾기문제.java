package Chap5;

import java.util.Stack;

/*
 * 미로 찾기 문제
 * 플라토의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 */

//23.2.16 수정
//23.2.24: 객체 배열 초기화, static 사용, 내부 클래스와 외부 클래스 사용 구분을 못하는 문제 => 선행 학습 필요
enum Directions {
	N, NE, E, SE, S, SW, W, NW
}

class Items {
	int x;
	int y;
	int dir;
	
	Items(int x , int y , int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

}

class Offsets {
	int a;
	int b;
	
	Offsets(int a , int b){
		this.a = a;
		this.b = b;
	}

}

public class Test_실습_미로찾기문제 {

	static Offsets[] moves = new Offsets[8];// static을 선언하는 이유를 알아야 한다
	int maze[][] = new int[14][17];
	int mark[][] = new int[14][17];

	public static void path(int maze[][], int mark[][], int m, int p)//m = 12, p = 15
	//출발점 (1,1), 이동 방향 dir = 2(2는 동쪽) 을 스택에 push
	{
		Stack<Items> stack = new Stack<>();
		stack.push(new Items(1,1,2));
		
		while(!stack.isEmpty()) {
			Items temp = stack.pop();
			int i = temp.x;
			int j = temp.y;
			int dir = temp.dir;
			mark[i][j] = 1;
			
			while(dir < 8) {
				int g = i + moves[dir].a;
				int h = j + moves[dir].b;
				
				if (g == m && h == p) {
					mark[g][h] = 1;
					System.out.println("path found");
					printPath(mark);
					return;
				}
				
				if (isLegalMove(maze , mark , g , h)) {
					mark[g][h] = 1;
					stack.push(new Items(i , j , dir + 1));
					i = g ;
					j = h ;
					dir = 0 ;
				}else {
					dir++;
				}
				
			}
		}
		System.out.println("No path found");
	}
	 private static boolean isLegalMove(int[][] maze, int[][] mark, int g, int h) {
	        return g >= 0 && g < maze.length && h >= 0 && h < maze[0].length && maze[g][h] == 0 && mark[g][h] == 0;
	    }
	 private static void printPath(int[][] mark) {
	        for (int i = 0; i < mark.length; i++) {
	            for (int j = 0; j < mark[0].length; j++) {
	                System.out.print(mark[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
			//8가지 방향중에서 남은 방향에 대하여
			
				//현재 위치 (i,j)에 대하여 이동 방향 계산
				
					//success;
	//	(i,j)와 (g,h)에 대하여 mark 표시
					
				 //legal move
						 //haven't been here before
						 //try next direction
	//	현재 위치 (i,j)에 대하여 mark[][]을 1로 설정
	//	   (i,j) 현위치에 대한 mark를 취소

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 } };
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);// 배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;
		moves[0].b = 0;

		moves[1].a = -1;
		moves[1].b = 1;

		moves[2].a = 0;
		moves[2].b = 1;

		moves[3].a = 1;
		moves[3].b = 1;

		moves[4].a = 1;
		moves[4].b = 0;

		moves[5].a = 1;
		moves[5].b = -1;

		moves[6].a = 0;
		moves[6].b = -1;

		moves[7].a = -1;
		moves[7].b = -1;
		// Directions d;
		// d = Directions.N;
		// d = d + 1;//java는 지원안됨
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				// input[][]을 maze[][]로 복사
				input[i][j] = maze[i+1][j+1];
			}
		}
		for(int i = 0; i<16;i++) {
			maze[i][0] = 1;
			maze[i][18] = 1;
		}
		for(int j = 0; j<19; j++) {
			maze[0][j] = 1;
			maze[15][j] = 1;
		}

//		show("maze[12,15]::", maze);
//		show("mark[12,15]::", mark);

		path(maze, mark, 12, 15);
//		show("maze[12,15]::", maze);
//		show("mark[12,15]::", mark);

	}
}
