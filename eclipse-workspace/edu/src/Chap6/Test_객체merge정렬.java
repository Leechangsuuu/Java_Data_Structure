package Chap6;

/*
 * 6장 구현 실습과제1 
 */

class PhyscData4 implements Comparable<PhyscData4>{
    String name;              // 이름
    int height;            // 키
    double vision;            // 시력
    
    public PhyscData4(String name ,int height,double vision){
    	this.name = name;
    	this.height = height;
    	this.vision = vision;
    }
    public int compareTo(PhyscData4 p) {
    	int result = this.name.compareTo(p.name);
    	if(result == 0) {
    		result = Integer.compare(this.height, p.height);
    		if(result == 0) {
    			result = Double.compare(this.vision, p.vision);
    		}
    	}
    	return result;
    }
    public String toString() {
    	return name + "(키:" + height + ", 시력:" + vision;
    }
}

public class Test_객체merge정렬 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData4[] a, int lefta, int righta, int leftb, int rightb ) {
		int n = rightb - lefta + 1;
		PhyscData4 [] temp = new PhyscData4[n];
		int i = lefta;
		int j = leftb;
		int k = 0;
		
		while(i <= righta && j <= rightb) {
			if(a[i].compareTo(a[j]) <= 0) {
				temp[k++] = a[i++];
			}
		
			else {
				temp[k++] = a[j++];
			}
		}
		while (i <= righta) {
			temp[k++] = a[i++];
		}
		while(j <= rightb) {
			temp[k++] = a[j++];
		}
		for(k = 0; k < n; k++) {
			a[k+lefta] = temp[k];
			System.out.println(" " + a[lefta+k]);
		}
		System.out.println();
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(PhyscData4[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData4[] x = {
		         new PhyscData4("강민하", 162, 0.3),
		         new PhyscData4("김찬우", 173, 0.7),
		         new PhyscData4("박준서", 171, 2.0),
		         new PhyscData4("유서범", 171, 1.5),
		         new PhyscData4("이수연", 168, 0.4),
		         new PhyscData4("장경오", 171, 1.2),
		         new PhyscData4("황지안", 169, 0.8),
		     };
		int nx = x.length;

		   MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
			System.out.println("오름차순으로 정렬했습니다.");
		     System.out.println("■ 신체검사 리스트 ■");
		     System.out.println(" 이름     키  시력");
		     System.out.println("------------------");
		     for (int i = 0; i < x.length; i++)
		         System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
