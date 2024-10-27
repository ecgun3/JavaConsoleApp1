package JavaConsoleApp1;

import java.util.Scanner;
import java.util.Arrays;


public class ArrayOps{
	
	static boolean arraySizeCheck(String str)
	{
		try 
		{
			int test = Integer.parseInt(str);
			if(test > 0 && test < Integer.MAX_VALUE)
				return true;
			return false;
		}
		catch(NumberFormatException e)
		{	
			System.out.println("Please enter an Integer value");
			return false;
		}
	}
	
	static boolean arrayElementCheck(String str)
	{
		try 
		{
			Double.parseDouble(str);
			return true;
		}
		catch(NumberFormatException e)
		{	
			System.out.println("Please enter a Double value");
			return false;
		}
	}
	
	static double Median(double[] Array) {
	    double median;
	    Arrays.sort(Array);
	    if(Array.length % 2 != 0)
	    	median = Array[Array.length/2];
	    else
	    	median = (Array[Array.length/2] + Array[Array.length/2 - 1]) / 2;
	    
	    return median;
	  }
	
	static double ArithmeticMean(double[] Array) {
		double total = 0;
		for(int i=0; i<Array.length; i++)
			total+= Array[i];
		
		return total/Array.length;
			
	  }
	
	static double GeometricMean(double[] Array) {
		double product = 1;
		for(int i=0; i<Array.length; i++)
			product *= Array[i];
		return Math.pow(product,(double)1/Array.length);
	}
	
	static double harmonicMean(int n, double[] Array) {
		if((n+1)==Array.length){
			return (1/Array[n]);
		}
		else{
			return ((1/Array[n++])+harmonicMean(n,Array));
		}
	}

	static void back(){
		Scanner ink = new Scanner(System.in);
		String last=ink.nextLine();
		if(last.equals("Y")||last.equals("y")){
			Welcome.clearConsole();}
		else{
			System.out.println("(If you want to main menu press Y)");
			back();
		}
	}

  public static void maine() {

    Scanner scan = new Scanner(System.in);
    
    String line;
    int ArrayLength;
    int n=0;
    
    //Taking Array size from user as string, then converting it to int.
    do
    	{
    	System.out.print("Enter the size of array: ");
    	line = scan.nextLine();
    	}
    while(!arraySizeCheck(line));
    
    ArrayLength = Integer.parseInt(line);
    double Array[] = new double[ArrayLength];
    
    //taking Array elements from user as string, then converting them to double 
    for(int i=0; i< ArrayLength; i++)
    	{
    		do {
    			System.out.printf("Enter the Array[%d]: ", i);
    			line = scan.nextLine();
    			}
    		while(!arrayElementCheck(line));
    		Array[i] = Double.parseDouble(line);
    	}
    
    //print the array as string
    System.out.println(" The Array : " + Arrays.toString(Array));
    System.out.printf(" %-20s : %,.4f%n ", "The Median", Median(Array));
    System.out.printf("%-20s : %,.4f%n ", "The Arithmetic Mean", ArithmeticMean(Array));
    System.out.printf("%-20s : %,.4f%n ", "The Geometric Mean", GeometricMean(Array));
    System.out.printf("%-20s : %,.4f%n ", "The Harmonic Mean", Array.length/harmonicMean(n,Array));
	System.out.printf("\n(If you want to main menu press Y): ");
	back();
  }
}
