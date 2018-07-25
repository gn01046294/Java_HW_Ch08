package Ch08;

public class Q08_01 {
	
	static void subroutine(String[] ar) {
		String[] a = { "1.02", "8.55", "12.55", "Æg","5","5" };
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			try {
				sum += Integer.parseInt(a[i]);
			} catch (NumberFormatException e) {
				// e.printStackTrace();
			} 
		}

		System.out.println("sum=" + sum);
	}

	public static void main(String[] args) {

		subroutine(args);
	}
}
