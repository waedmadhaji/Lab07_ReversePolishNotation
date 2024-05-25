package postfix;

import java.util.Stack;
import stack.Underflow;

public class Postfix {

	public double evaluate(String postfix) throws Underflow {
		if (postfix == null || postfix.isEmpty()) {
			throw new IllegalArgumentException("Postfix expression cannot be null or empty");
		}

		Stack<Double> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if (Character.isWhitespace(c)) {
				continue; // skip whitespace
			}

			if (Character.isDigit(c)) {
				StringBuilder number = new StringBuilder();
				while (i < postfix.length() && Character.isDigit(postfix.charAt(i))) {
					number.append(postfix.charAt(i));
					i++;
				}
				i--; // step back to process the character after the number
				stack.push(Double.parseDouble(number.toString()));
			} else if (isOperator(c)) {
				if (stack.size() < 2) {
					throw new IllegalArgumentException("Invalid postfix expression");
				}
				double b = stack.pop();
				double a = stack.pop();
				switch (c) {
					case '+':
						stack.push(a + b);
						break;
					case '-':
						stack.push(a - b);
						break;
					case '*':
						stack.push(a * b);
						break;
					case '/':
						if (b == 0) {
							throw new ArithmeticException("Division by zero");
						}
						stack.push(a / b);
						break;
					case '^':
						stack.push(Math.pow(a, b));
						break;
					default:
						throw new IllegalArgumentException("Invalid operator: " + c);
				}
			} else {
				throw new IllegalArgumentException("Invalid character in postfix expression: " + c);
			}
		}

		if (stack.size() != 1) {
			throw new IllegalArgumentException("Invalid postfix expression");
		}

		return stack.pop();
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
	}

	public static void main(String[] args) {
		Postfix postfixEvaluator = new Postfix();
		try {
			String postfixExpression = "35 104 * +"; // example postfix expression
			double result = postfixEvaluator.evaluate(postfixExpression);
			System.out.println("Postfix: " + postfixExpression);
			System.out.println("Result: " + result);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

