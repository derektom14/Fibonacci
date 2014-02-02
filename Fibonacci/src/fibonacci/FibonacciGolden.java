package fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class FibonacciGolden implements IFibonacci{

	private static final double SQRT_5 = Math.sqrt(5);
	private static final double GOLDEN_RATIO = (1 + SQRT_5)/2;
	
//	private static BigDecimal SQRT_5_BIG = new BigDecimal("2.23606797749978969640917366873127623544061835961152572427089");
//	private static BigDecimal GOLDEN_RATIO_BIG = new BigDecimal("1.61803398874989484820458683436563811772030917980576286213544862270526046281890");
//	private static BigDecimal GOLDEN_RATIO_HAT_BIG = BigDecimal.ONE.subtract(GOLDEN_RATIO_BIG);
	
	private static final BigDecimal TWO = new BigDecimal(2);
	private int scale;
	private static BigDecimal FIVE = new BigDecimal(5);
	private BigDecimal SQRT_5_BIG, GOLDEN_RATIO_BIG, GOLDEN_RATIO_HAT_BIG;

	public FibonacciGolden(int scale){
		setScale(scale);
	}
	
	public void setScale(int s){
		scale = s;
		SQRT_5_BIG = sqrt(FIVE, scale);
		GOLDEN_RATIO_BIG = BigDecimal.ONE.add(SQRT_5_BIG).divide(TWO);
		GOLDEN_RATIO_HAT_BIG = BigDecimal.ONE.subtract(GOLDEN_RATIO_BIG);
	}
	
	public void incScale(){
		setScale(scale + 1);
	}
	
	public int getScale(){
		return scale;
	}
	
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
	
	private static BigDecimal sqrt(BigDecimal A, final int scale) {
	    BigDecimal x0 = new BigDecimal("0");
	    BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
	    while (!x0.equals(x1)) {
	        x0 = x1;
	        x1 = A.divide(x0, scale, BigDecimal.ROUND_HALF_UP);
	        x1 = x1.add(x0);
	        x1 = x1.divide(TWO, scale, BigDecimal.ROUND_HALF_UP);

	    }
	    return x1;
	}
}
