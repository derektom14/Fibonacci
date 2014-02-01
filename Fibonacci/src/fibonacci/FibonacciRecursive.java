package fibonacci;

import java.math.BigInteger;

public class FibonacciRecursive implements IFibonacci{

	public long get(int k){
		if (k < 2)
			return k;
		else
			return get(k-1) + get(k-2);
	}
	
	public BigInteger getBig(int k){
		if (k < 2)
			if (k == 1)
				return BigInteger.ONE;
			else
				return BigInteger.ZERO;
		else
			return getBig(k-1).add(getBig(k-2));
	}
	
}
