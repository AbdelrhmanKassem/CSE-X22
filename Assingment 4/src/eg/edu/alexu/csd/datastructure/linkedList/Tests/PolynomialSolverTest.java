package eg.edu.alexu.csd.datastructure.linkedList.Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import eg.edu.alexu.csd.datastructure.linkedList.Classes.PolynomialSolver;

class PolynomialSolverTest {

	@Test
	void test() {
		PolynomialSolver test=new PolynomialSolver();
		 int[][]terms = {{3, 7}, {45, 5}, {176, 3}, {128, 1} };
		 test.setPolynomial('C', terms);
         int[][]terms2 = {{-120, 5}, {-1, 3}, {27, 2}, {1, 1},{-1, 0} };
         test.setPolynomial('B', terms2);
         int[][] result1 = test.add('B', 'C');
         int[][] expected = new int[][] {
                        {3, 7}, {-75, 5}, {175, 3},
                        {27, 2}, {129, 1}, {-1, 0}
                };
                assertArrayEquals(expected, result1);
	}
	 //test set A,B,C.
	@Test
	void test1() {
		PolynomialSolver test=new PolynomialSolver();
		int[][]terms = {{-3, 0}, {1, 3}, {5, -2}};
		test.setPolynomial('C', terms);
		float result = test.evaluatePolynomial('C', 2);
		String s = Float.toString(result);
		String r = "6.25";
		assertEquals(r, s);
	}
	 //TEST ADD.
	@Test
	void test2() {
		PolynomialSolver test=new PolynomialSolver();
		int[][]terms = {{-3, 0}, {1, 1}, {5, 2}};
		int[][]terms2 = {{-3, 3}, {9, 4}, {5, 5}, {7, 8}};
		test.setPolynomial('C', terms);
		test.setPolynomial('A', terms2);
		int[][]result = {
				{7, 8}, {5, 5}, {9, 4}, {-3, 3},
				{5, 2}, {1, 1}, {-3, 0}
				};
		int[][]actual = test.add('C', 'A');
		assertArrayEquals(result, actual);
	}
	 //TEST ADD.
		@Test
		void test3() {
			PolynomialSolver test=new PolynomialSolver();
			int[][]terms = {{1, 3}, {-1, 2}, {-1, 1},{-1,0}};
			int[][]terms2 = {{2, 2}, {3, 1}, {-1, 0}};
			test.setPolynomial('C', terms);
			test.setPolynomial('A', terms2);
			int[][]result = {
					{1, 3}, {1, 2}, {2, 1}, {-2, 0}
					};
			int[][]actual = test.add('C', 'A');
			assertArrayEquals(result, actual);
		}
	 //TEST SUBTRACT.
	@Test
	void test4() {
		PolynomialSolver test=new PolynomialSolver();
		int[][]terms = {{-3, 0}, {1, 1}, {5, 2}};
		int[][]terms2 = {{-3, 3}, {9, 2}, {5, 5}, {7, 8}};
		test.setPolynomial('A', terms);
		test.setPolynomial('B', terms2);
		int[][]result = {
				{7, 8}, {5, 5}, {-3, 3}, {4, 2}, {-1, 1}, {3, 0}
				};
		int[][]actual = test.subtract('B', 'A');
		assertArrayEquals(result, actual);
		
	}
	 //TEST SUBTRACT.
	@Test
	void test5() {
		PolynomialSolver test=new PolynomialSolver();
		int[][]terms = {{1, 3}, {-1, 2}, {-1, 1},{-1,0}};
		int[][]terms2 = {{2, 2}, {3, 1}, {-1, 0}};
		test.setPolynomial('C', terms);
		test.setPolynomial('A', terms2);
		int[][]result = {
				{1, 3}, {-3, 2}, {-4, 1}
				};
		int[][]actual = test.subtract('C', 'A');
		assertArrayEquals(result, actual);
	}
	 //TEST print.
	@Test
	void test6() {
		PolynomialSolver test=new PolynomialSolver();
		int[][]terms = {{-3, 0}, {1, 3}, {5, -2}};
		test.setPolynomial('A', terms);
		float result = test.evaluatePolynomial('A', 2);
		String s = Float.toString(result);
		String r = "6.25";
		assertEquals(r, s);
		String p = test.print('A');
		String r1 = "x^3-3+5x^-2";
		assertEquals(r1, p);
	}
	 //TEST print.
		@Test
		void test7() {
			PolynomialSolver test=new PolynomialSolver();
			int[][]terms = {{1, 3}, {-1, 2}, {-1, 1},{-1,0}};
			int[][]terms2 = {{2, 2}, {3, 1}, {-1, 0}};
			test.setPolynomial('C', terms);
			test.setPolynomial('A', terms2);
			String p = test.print('C');
			String r1 = "x^3-x^2-x-1";
			assertEquals(r1, p);
			String p1 = test.print('A');
			String r2 = "2x^2+3x-1";
			assertEquals(r2, p1);
		}
	//TEST MULTIPLY.
	@Test
	void test8() {
		PolynomialSolver test=new PolynomialSolver();
		int[][]terms = {{-3, 0}, {1, 1}, {5, 2}};
		int[][]terms2 = {{-3, 0}, {1, 4}, {5, 2}};
		test.setPolynomial('C', terms);
		test.setPolynomial('A', terms2);
		int[][]actual = test.multiply('C', 'A');
		test.setPolynomial('R', actual);
		String p = test.print('R');
		String r1 = "5x^6+x^5+22x^4+5x^3-30x^2-3x+9";
		assertEquals(r1, p);
	}
	//TEST MULTIPLY.
	@Test
	void test9() {
		PolynomialSolver test=new PolynomialSolver();
		int[][]terms = {{1, 3}, {-1, 2}, {-1, 1},{-1,0}};
		int[][]terms2 = {{2, 2}, {3, 1}, {-1, 0}};
		test.setPolynomial('C', terms);
		test.setPolynomial('A', terms2);
		int[][]result = {
				{2, 5}, {1, 4}, {-6, 3},{-4, 2}, {-2, 1}, {1, 0}
				};
		int[][]actual = test.multiply('C', 'A');
		assertArrayEquals(result, actual);
	}
}

