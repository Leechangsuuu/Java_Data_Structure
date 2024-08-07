package Chap6;

class Term implements Comparable<Term>{
    double coef;           // 계수
    int    exp;            // 지수
    
    public Term(double coef , int exp) {
    	this.coef = coef;
    	this.exp = exp;
    }
    public int compareTo(Term p) {
    	int result = Double.compare(this.coef, p.coef);
    	if(result == 0) {
    		result = Integer.compare(this.exp, p.exp);
    	}
    	return result;
    }
    public String toString() {
    	return coef + "x^" + exp;
    }

}
public class Test_다항식merge연산 {

	static void merge(Term[] a, int lefta, int righta, int leftb, int rightb ) {
		Term []temp = new Term [a.length];
		int p = lefta;
		int q = leftb;
		int ix = 0;
		while(p <= righta && q <= rightb) {
			if(a[p].compareTo(a[q])<=0) {
				temp[ix++] = a[p++];
			}
			else {
				temp[ix++] = a[q++];
			}
		}
		while(p <= righta) {
			temp[ix++] = a[p++];
		}
		while(q <= rightb) {
			temp[ix++] = a[q++];
		}
		for(int i = lefta; i < rightb;i++) {
			a[i] = temp[i];
			System.out.println(" " + a[lefta + i]);
		}
		System.out.println();
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Term[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	static void ShowPolynomial(Term[] p) {
		
		
	}
	static void AddPolynomial(Term[] PolynomialX,Term[]PolynomialY,Term[]PolynomialZ){
		int i = 0, j = 0, k = 0;
		while (i < PolynomialX.length &&  j < PolynomialY.length) {
			if(PolynomialX[i].exp == PolynomialY[j].exp) { //지수같을때
				PolynomialZ[k++] = new Term(PolynomialX[i].coef + PolynomialY[j].coef , PolynomialX[i].exp);
				i++;//다음 항으로
				j++;
			}
			else if(PolynomialX[i].exp > PolynomialY[j].exp) {//첫번쨰 다항식의 지수가 더 클떄 z에 두번쨰 다항식 추가하고 두번쨰 다항식의 다음 항으로 이동
				PolynomialZ[k++] = PolynomialY[j++];
			}
			else {//두번쨰 다항식의 지수가 더 클떄 z에 첫번쨰 다항식 추가하고 척번쨰 다항식의 다음 항으로 이동
				PolynomialZ[k++] = PolynomialY[j++];
				PolynomialZ[k++] = PolynomialX[i++];
			}
		}
		while(i < PolynomialX.length) {// 첫번쨰 다항식에 남아있는 항이 있으면 남아있는항을 모두 결과 다항식에 추가
			PolynomialZ[k++] = PolynomialX[i++];
		}
		while(j < PolynomialY.length) {// 두번쨰 다항식에 남아있는 항이 있으면 남아있는항을 모두 결과 다항식에 추가
			PolynomialZ[k++] = PolynomialY[j++];
		}
		
	}
	public static void main(String[] args) {
		Term[] PolynomialX = {
		         new Term(1.5, 3),
		         new Term(2.5, 7),
		         new Term(3.3, 2),
		         new Term(4.0, 1),
		         new Term(2.2, 0),
		         new Term(3.1, 4),
		         new Term(3.8, 5),
		     };
		Term[] PolynomialY = {
		         new Term(1.5, 1),
		         new Term(2.5, 2),
		         new Term(3.3, 3),
		         new Term(4.0, 0),
		         new Term(2.2, 4),
		         new Term(3.1, 5),
		         new Term(3.8, 6),
		     };
		int nx = PolynomialX.length;


		ShowPolynomial(PolynomialX);
		ShowPolynomial(PolynomialY);
		MergeSort(PolynomialX, 0, PolynomialX.length - 1); // 배열 x를 퀵정렬
		MergeSort(PolynomialY, 0, PolynomialY.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial(PolynomialX);
		ShowPolynomial(PolynomialY);
		Term[] PolynomialZ = new Term[20];
		AddPolynomial(PolynomialX,PolynomialY,PolynomialZ );//다항식 덧셈 z = x + y
		ShowPolynomial(z);
		ShowPolynomial(PolynomialY);
		MultiplyPolynomial(PolynomialX,PolynomialY,PolynomialZ );//다항식 곱셈 z = x * y
		ShowPolynomial(PolynomialY);
		int result = EvaluatePolynomial(PolynomialZ , 10);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println(" result = " + result );
	}
}
