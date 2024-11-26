// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		//double payment = 10000;
		//System.out.println("pay left: " + endBalance(loan, rate, n, payment));

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		iterationCounter=0;
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	public static double endBalance(double loan, double rate, int n, double payment) {		
		double currentPay = loan;
		for (int i=0; i<n; i++) {
			currentPay = (currentPay - payment) * (1+rate/100.0);
			//System.out.println(currentPay);
		}
		return currentPay;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		
		double g = loan / n;
		while (endBalance(loan, rate, n, g)>epsilon) {
			g = g +epsilon;
			iterationCounter++;
			//System.out.println(endBalance(loan, rate, n, g));
		}
		return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double l= loan / n;
		double h = loan; 
		double g = (l + h)/2.0;
		while (h - l > epsilon) {
			if (Math.abs(endBalance(loan, rate, n, g)) < epsilon) {
				break;
			}
			if (endBalance(loan, rate, n, g) * endBalance(loan, rate, n, l) > 0) {
				l = g;
			}
			else {
				h = g;
			}
			g = (l + h)/2.0;
			iterationCounter++;
		}
		return g;
		
    }
}