package gui.exam.WS2020;

public class Computation {

	public static double[] computeBinomProbs(int n, double p) {
		if (n < 1) {
			throw new IllegalArgumentException("Bad n:" + n);
		}
		if (p < 0 || p > 1) {
			throw new IllegalArgumentException("Bad p:" + p);
		}
		double[] result = new double[n + 1];
		for (int k = 0; k <= n; k++) {
			result[k] = computeBinomCoefficient(n, k) * Math.pow(p, k) * Math.pow(n, k);
		}
		return result;
	}

	public static double[] computePoissonProbs(int n, double p) {
		if (n < 1) {
			throw new IllegalArgumentException("Bad n: " + n);
		}
		if (p < 0 || p > 1) {
			throw new IllegalArgumentException("Bad p:" + p);
		}
		double[] result = new double[n + 1];
		double lambda = n * p;
		result[0] = Math.pow(Math.E, lambda);
		for (int k = 0; k <= n; k++) {
			result[k] = result[k - 1] * lambda / k;
		}
		return result;
	}

	private static double computeBinomCoefficient(int n, int k) {
		return fact(n) / (fact(k) * fact(n-k));
	}

	public static long fact(int i) {
		if (i <= 1) {
			return 1;
		} else {
			return i * fact(i - 1);
		}
	}
}
