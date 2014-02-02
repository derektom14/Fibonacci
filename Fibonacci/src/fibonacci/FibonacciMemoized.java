package fibonacci;

import java.math.BigInteger;


public class FibonacciMemoized implements IFibonacci{

	private long[] memo;
	private BigInteger[] memoBig;
	
	public FibonacciMemoized(int size){
		memo = new long[size];
		memoBig = new BigInteger[size];
		memoBig[0] = BigInteger.ZERO;
		if (size > 1){
			memo[1] = 1;
			memoBig[1] = BigInteger.ONE;
		}
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
		if (k >= memo.length)
			return getBig(k-1).add(getBig(k-2));
		if (memoBig[k] == null)
			memoBig[k] = getBig(k-1).add(getBig(k-2));
		return memoBig[k];
	}
	
}
