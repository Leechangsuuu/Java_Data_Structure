package Quiz;

public class Class {
	
	static int r = 4;
	static int h = 3;
	
	static double getVolume() {
		return Math.PI * r * r * h;
	}
	static double getArea() {
		return Math.PI * r * r * 2 + (2 * Math.PI * r) * h;	
	}
	
public static void main(String[] args) {
	System.out.println("Volume:" + getVolume());
	System.out.println("Area:" + getArea());
}
}
