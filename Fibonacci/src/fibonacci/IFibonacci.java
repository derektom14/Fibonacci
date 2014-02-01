package fibonacci;

import java.math.BigInteger;

public interface IFibonacci {
	
	/*
	 * Returns the k-th Fibonacci number, where F(0) = 0, F(1) = 1, and
	 * for all other cases F(k) = F(k-1) + F(k-2)
	 */
	public long get(int k);
	
	public BigInteger getBig(int k);
}
