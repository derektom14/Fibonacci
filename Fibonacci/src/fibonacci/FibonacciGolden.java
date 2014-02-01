package fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class FibonacciGolden implements IFibonacci{

	private static final double SQRT_5 = Math.sqrt(5);
	private static final double GOLDEN_RATIO = (1 + SQRT_5)/2;
	//private static final double GOLDEN_RATIO_HAT = 1 - GOLDEN_RATIO;
	
	private static BigDecimal SQRT_5_BIG = new BigDecimal("2.23606797749978969640917366873127623544061835961152572427089");
	private static BigDecimal GOLDEN_RATIO_BIG = new BigDecimal("1.61803398874989484820458683436563811772030917980576286213544862270526046281890");
	private static BigDecimal GOLDEN_RATIO_HAT_BIG = BigDecimal.ONE.subtract(GOLDEN_RATIO_BIG);
	
	public long get(int k){
		if (k < 71){
			double a = Math.pow(GOLDEN_RATIO, k);
			return Math.round((a) / SQRT_5);
		} else {
			BigDecimal a = GOLDEN_RATIO_BIG.pow(k);
			BigDecimal b = GOLDEN_RATIO_HAT_BIG.pow(k);
			return (a.subtract(b)).divide(SQRT_5_BIG, 20, BigDecimal.ROUND_HALF_EVEN).longValue();
		}
	}
	
	public BigInteger getBig(int k){
		BigDecimal a = GOLDEN_RATIO_BIG.pow(k);
		BigDecimal b = GOLDEN_RATIO_HAT_BIG.pow(k);
		return a.subtract(b).divide(SQRT_5_BIG, 20, BigDecimal.ROUND_HALF_EVEN).round(MathContext.UNLIMITED).toBigInteger();
	}
	
}
