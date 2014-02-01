package fibonacci;

public class Main {

	public static void main(String args[]){
		int k = 0;
		IFibonacci test = new FibonacciIterative();
		FibonacciGolden fg = new FibonacciGolden();
		while(test.getBig(k).equals(fg.getBig(k))){
			k++;
			System.out.println(k);
		}
		System.out.println("Disagreed at " + k + ", " + test.getBig(k) + ", " + fg.getBig(k));
	}
	
}
