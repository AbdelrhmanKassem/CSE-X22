package calculator;

public class Calculator implements ICalculator
{
	public int add (int x, int y)
	{
		return x+y;
	}
	
	public float divide(int x, int y) throws RuntimeException
	{
		if(y==0) 
			throw new ArithmeticException("ERROR:- Division By Zero Is Not Allowed");
		return (float)x/y;
	}
}

