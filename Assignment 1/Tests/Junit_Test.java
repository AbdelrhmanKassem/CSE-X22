package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Junit_Test 
{
		
	Calculator Calc=new Calculator();

		@Test
		void test() 
		{
			int result=Calc.add(5,5);
			assertEquals(10,result);
		}
		
		@Test
		void test1() 
		{
			float result=Calc.divide(5,2);
			assertEquals(2.5,result);
			
		}
		
		@Test
		void test2() {
		assertThrows(ArithmeticException.class,()-> Calc.divide(10,0));
		}
		
		@Test
		void test3() 
		{
			float result=Calc.divide(0,2);
			assertEquals(0,result);
			
		}
		
		@Test
		void test4() 
		{
			int result=Calc.add(-3,2);
			assertEquals(-1,result);
			
		}
		
		@Test
		void test5() 
		{
			int result=Calc.add(5,-2);
			assertEquals(3,result);
			
		}
		
		@Test
		void test6() 
		{
			float result=Calc.divide(-3,2);
			assertEquals(-1.5,result);
			
		}
		
		@Test
		void test7() 
		{
			int result=Calc.add(-5,-2);
			assertEquals(-7,result);
			
		}
		
		@Test
		void test8() 
		{
			float result=Calc.divide(8,2);
			assertEquals(4,result);
			
		}

}
