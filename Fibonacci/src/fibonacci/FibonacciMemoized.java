package fibonacci;

import java.math.BigInteger;


public class FibonacciMemoized implements IFibonacci{

	private long[] memo;
	
	public FibonacciMemoized(int size){
		memo = new long[size];
		if (size > 1)
			memo[1] = 1;
	}
	
	public long get(int k){
		if (k >= memo.length)
			return get(k-1) + get(k-2);
		if (k < 2)
			return k;
		if (memo[k] == 0){
			memo[k] = get(k-1) + get(k-2);
		}
		return memo[k];
	}
	
	public BigInteger getBig(int k){
		return new BigInteger(String.valueOf(k));
	}
	
}
