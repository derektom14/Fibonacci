package fibonacci;

import java.math.BigInteger;

public class FibonacciIterative implements IFibonacci{
	
	public long get(int k){
		boolean useA = ((k & 1) == 0);
		long a = 0, b = 1;
		while (k > 0){
			if ((k & 1) == 0)
				a += b;
			else
				b += a;
			k--;
		}
		if (useA)
			return a;
		return b;
	}
	
	public BigInteger getBig(int k){
		boolean useA = ((k & 1) == 0);
		BigInteger a = BigInteger.ZERO, b = BigInteger.ONE;
		while (k > 0){
			if ((k & 1) == 0)
				a = a.add(b);
			else
				b = b.add(a);
			k--;
		}
		if (useA)
			return a;
		return b;
	}
	
}
