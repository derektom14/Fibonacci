package fibonacci;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Main {

	public static void main(String args[]) throws IOException{
		IFibonacci iter = new FibonacciIterative();
		FibonacciGolden gold = new FibonacciGolden(100);
		
		int goal = 500;
		
		while(!iter.getBig(goal).equals(gold.getBig(goal))){
			gold.incScale();
			System.out.println(gold.getScale());
		}
		
		ApplicationFrame frame = new ApplicationFrame("Fibonacci Speed Test");
		
		File output = new File("graph.png");
		
		XYSeries iterData = new XYSeries("Iterative");
		XYSeries goldData = new XYSeries("Golden");
		for (int k = 0; k < goal; k++){
			System.out.println(k);
			iterData.add(k, getTime(iter, k, 10));
			goldData.add(k, getTime(gold, k, 10));
		}
		XYSeriesCollection data = new XYSeriesCollection();
		data.addSeries(iterData);
		data.addSeries(goldData);
		final JFreeChart chart = ChartFactory.createXYLineChart(
	        "Fibonacci Speed Test",
	        "K", 
	        "Time", 
	        data,
	        PlotOrientation.VERTICAL,
	        true,
	        true,
	        false
	    );
		ChartUtilities.saveChartAsPNG(output, chart, 500, 270);
	    final ChartPanel chartPanel = new ChartPanel(chart);
	    chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	    frame.setContentPane(chartPanel);
	    frame.pack();
	    RefineryUtilities.centerFrameOnScreen(frame);
	    frame.setVisible(true);
	}
	
	public static long getTime(IFibonacci fib, int val, int runs){
		long time = System.nanoTime();
		for (int k = 0; k < runs; k++)
			fib.get(val);
		return System.nanoTime() - time;
		
	}
	
	public static void seeScales(){
		IFibonacci test = new FibonacciMemoized(1000);
		FibonacciGolden fg = new FibonacciGolden(0);
		for (int k = 0; k < 1000; k++){
			while(!test.getBig(k).equals(fg.getBig(k)))
				fg.incScale();
			System.out.println(k + ": " + fg.getScale());
		}
	}
	
	public static void testFibonacci(){
		int k = 0;
		IFibonacci test = new FibonacciIterative();
		FibonacciGolden fg = new FibonacciGolden(20);
		while(test.getBig(k).equals(fg.getBig(k))){
			k++;
			System.out.println(k);
		}
		System.out.println("Disagreed at " + k + ", " + test.getBig(k) + ", " + fg.getBig(k));
	}
	
}
