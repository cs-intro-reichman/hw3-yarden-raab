// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    // System.out.println(plus(2,-3));   // 2 + 3
	    // System.out.println(minus(7,-2));  // 7 - 2
   		// System.out.println(minus(-2,7));  // 2 - 7
 		// System.out.println(times(3,-2));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		// System.out.println(pow(5,3));      // 5^3
   		// System.out.println(pow(3,5));      // 3^5
   		// System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(10, -5));    // 5 / 5  
   		// System.out.println(div(25,7));   // 25 / 7
   		// System.out.println(mod(25,7));   // 25 % 7
   		// System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2>0){
			for (int i=0; i<x2; i++) {
				x1++;
			}
		}
		else {
			for (int i=0; i<(-x2); i++) {
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2>0) {
			for (int i=0; i<x2; i++) {
				x1--;
			}
		}
		else {
			for (int i=0; i<(-x2); i++) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		if (x2>0) {
			for (int i=0; i<x2; i++) {
				sum = plus(x1, sum);
			}
		}
		else {
			for (int i=0; i<(-x2); i++) {
				sum = minus(sum, x1);			
			}
		}	
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = 1;
		for (int i=0; i<n; i++) {
			sum = times(x, sum);
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count = 0;
		int temp1 = 0;
		if (x1>=0) {
			temp1 = x1;
		}
		else {
			temp1 = -x1;
		}
		int temp2 = 0;
		if (x2>=0) {
			temp2 = x2;
		}
		else {
			temp2 = -x2;
		}
		while (temp1>=temp2) {
			temp1 = minus(temp1, temp2);
			count++;
		}
		if ((x1>=0 && x2<0) || (x2>=0 && x2<1)) {
			return -count;
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		while (x1>=x2) {
			x1 = minus(x1, x2);
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i=0;

		while (pow(i, 2)<=x) {
			if (pow(i, 2)==x) {
				return i;
			}
			i++;
		}
		i--;
		return i;
	}	  	  
}