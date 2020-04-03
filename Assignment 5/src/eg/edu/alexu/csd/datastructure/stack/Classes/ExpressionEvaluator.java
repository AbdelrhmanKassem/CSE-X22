package eg.edu.alexu.csd.datastructure.stack.Classes;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

import eg.edu.alexu.csd.datastructure.stack.Interfaces.IExpressionEvaluator;

/**
 * 
 * @author Abdelrhman Kassem
 * @version 1.0 
 * 
 */

public class ExpressionEvaluator implements IExpressionEvaluator {
    	
	/**
	 * Helping function to determine the precedence of the current and top of the stack operations 
	 * @param c operator
	 * @return a value indicating precedence 
	 */
	
    private int getPrecedence(char c){
        if(c=='+'|| c=='-') return 1;
        else if(c=='*' || c=='/') return 2;
        
        return 0;
    }
    
    /**
     * a function to "clean up" the expression and replace any negative numbers adding dummy zeros to them
     * for example -4 will be (0 - 4)
     * and -a will be (0 - a)
     * @param expression the expression being processed
     * @return the resultant expression after processing it
     */
	
	private static String addDummyZeros (String expression) {
		//Making Sure there are spaces around all parenthesis
		expression = expression.replaceAll("\\(", "\\( ");
		expression = expression.replaceAll("\\)", " \\)");

		//Splitting the string around whitespaces into a string array
		String[] a = expression.trim().split("\\s+");
		expression = "";

		//Replacing -x with (0-x) and joining the array into one string again 
		//deleting all whitespaces in the process 
		for(int i=0;i<a.length;i++) {
			if(a[i].charAt(0) == '-' && a[i].length() > 1) 
				a[i] = "( 0 - " + a[i].substring(1) + " )";
			expression+= a[i] + " ";
		}
		
		return expression;
	}
	
	/**
	 * function to return true if the character is a valid operator
	 * @param c character
	 * @return true if the character is " * or / or + or -"
	 */
    private static boolean isAnOperator(char c){
        return (c == '*' || c == '/' || c == '+' || c == '-');
    }
    
    /**
     * function that validates the input infix expression making sure no parenthesis are left open or if there
     * is in valid operators of two operators back to back
     * @param expression to be checked
     * @return true if the expression passes all tests
     */
    private static boolean isValidInfix(String expression){
		//make sure there are no two consecutive operands
    	String[] a = expression.trim().split("\\s+");
    	for (int i = 0; i < a.length-1; i++) {
    		char c1 = a[i].charAt(0);
    		char c2 = a[i+1].charAt(0);
    		if (!(isAnOperator(c1) || c1=='(' || c1==')')){
    			if (!(isAnOperator(c2) || c2=='(' || c2==')'))
    				return false;
    		}
    	}
		
    	
    	//remove unnecessary whitespace
        expression = expression.replaceAll("\\s+", "");
        //returns false if expression starts or ends with an operator
        if (isAnOperator(expression.charAt(0)) || isAnOperator(expression.charAt(expression.length()-1)))
            return false;

        //returns false if test has mismatching number of opening and closing parentheses

        int unclosedParenthesis = 0;

        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '('){
                unclosedParenthesis++; 

                //returns false if expression ends with '('
                if (i == expression.length()-1) return false;
            }
            
            if (expression.charAt(i) == ')'){
                unclosedParenthesis--;

                //returns false if expression starts with ')'
                if (i == 0) return false;

            }
            
            if (isAnOperator(expression.charAt(i))){

                //returns false if operator is preceded by an operator or opening parenthesis 
                //or followed by closing parenthesis
                if (expression.charAt(i-1) == '(' || expression.charAt(i+1) == ')' || isAnOperator(expression.charAt(i+1))){
                    return false; 
                }

            }

        }
        //Expression is valid if no parenthesis are left open
        return (unclosedParenthesis == 0);
    }
    
    /**
     * function to validate the input postfix expression making sure the expression passes 3 conditions
     * 1. Starting by 2 operands
     * 2. all operands are numbers
     * 3. the number of operands is 1 more than the number of operators
     * @param array of strings each string is either a number or an operation
     * @return true if the expression is a valid postfix expression
     */
	private static boolean isValidPostfix (String [] a) {
		int numsCount = 0,operatorsCount = 0;
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		
		//makes sure the expression starts by 2 operands and ends with an operator
		if(!pattern.matcher(a[0]).matches() || !pattern.matcher(a[1]).matches() 
				|| !isAnOperator(a[a.length-1].charAt(0)))
			return false;
		
		//loop to count the number of operators and numbers
		for(int i=0;i<a.length;i++) {
			if(pattern.matcher(a[i]).matches())
				numsCount++;
			else {
				if(a[i].length() > 1)
					return false;
				char c = a[i].charAt(0);
				if(!(c == '+' || c == '-' || c == '*' || c == '/'))
					return false;
				operatorsCount++;
			}
		}
		
		
		if(numsCount - 1 == operatorsCount)
			return true;
		return false;
	}
	
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	*
	* @param expression
	* infix expression
	* @return postfix expression
	*/
	@Override
	public String infixToPostfix(String expression) {
		expression = addDummyZeros(expression);
		if (!isValidInfix(expression)  || expression.length()<3)
			throw new InputMismatchException("Expression is invalid!!");
		Stack operations = new Stack();
		String result="";
		
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (c == '(') {
				operations.push(c);
			}
			else if (c == ')') {
				while ( !operations.isEmpty() && (char)operations.peek() != '(') {
					result +=operations.pop();
				}
				operations.pop();
			}
			
			else if(c=='+' || c=='-' || c=='*' || c=='/'){

				if(operations.isEmpty()){
                    operations.push(c);
                }
                else{
                    while(!operations.isEmpty() && getPrecedence((char)operations.peek())>=getPrecedence(c)){
            			result +=" " + operations.pop() + " ";
                    }
                    operations.push(c);
                }
			}
			else {
				result += c;
			}
		}
		while (!operations.isEmpty()) {
			result += operations.pop() + " ";
		}
		result = result.trim().replaceAll("\\s+", " ");
		return result;
	}
	
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	*
	* @param expression
	* postfix expression
	* @return the expression evaluated value
	*/
	@Override
	public int evaluate(String expression) {
		String[] a = expression.trim().split("\\s+");
		Stack operands = new Stack();
		if (!isValidPostfix(a))
			throw new InputMismatchException("Expression is invalid!!");
		
		for (int i = 0; i < a.length; i++ ) {
			char c = a[i].charAt(0);
			if (a[i].length() == 1 && isAnOperator(c)) {
				if (operands.size() < 2)
					throw new InputMismatchException("Expression is invalid!!");
				float operand2 = (float) operands.pop();
				float operand1 = (float) operands.pop();
				if(c == '/') {
					if(operand2==0)
						throw new ArithmeticException("Cannot Devide By Zero!!");
					operands.push(operand1 / operand2);
				}
				if(c == '*') operands.push(operand1 * operand2);
				if(c == '+') operands.push(operand1 + operand2);
				if(c == '-') operands.push(operand1 - operand2);

			}
			else 
				operands.push(Float.parseFloat(a[i]));
		}
		
		
		return Math.round((float) operands.pop());
	}
	
	

}
