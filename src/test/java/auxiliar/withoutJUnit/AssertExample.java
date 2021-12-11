package auxiliar.withoutJUnit;

public class AssertExample {

	public static void main(String[] args){
		System.out.println(factorial(0));
		System.out.println(factorial(3));
		System.out.println(factorial(21));
	}

	private static int factorial(int data){
		assert 0 <= data && data <= 20;

		int result = 1;
		for (int i = 1; i < data; i++) {
			result *= i;
		}
		return result;
	}

}
