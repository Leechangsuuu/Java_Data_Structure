package Quiz;


abstract class Drinks{
	public void drink() {};
}

class Juice extends Drinks{
	public void drink() {	
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "주스";
	}
}
class Coffee extends Drinks{
	public void drink() {
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "커피";
	}
}
class Beer extends Drinks{
	public void drink() {
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "맥주";
	}
}
class Water extends Drinks{
	public void drink() {
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "물";
	}
}
class Tea extends Drinks{
	public void drink() {
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "차";
	}
}
public class Drinkss {
	public static void main(String[] args) {
		Drinks drinks[] = new Drinks[5];
		drinks[0] = new Juice();
		drinks[1] = new Coffee();
		drinks[2] = new Beer();
		drinks[3] = new Water();
		drinks[4] = new Tea();
		for(Drinks d : drinks) {
			System.out.println(d.toString()+"를 마십니다.");
		}
		
		
		
	}
}

	
