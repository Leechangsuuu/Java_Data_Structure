package Quiz;

public class PrimeNumber3 {

	public static boolean PrimeNumber(int number) {
		for(int i=2; i<number; ++i)
		{
	    	// 나누어서 떨어진다면 약수
			if (number% i == 0)
				return false;
		}
		return true;
	}

}
