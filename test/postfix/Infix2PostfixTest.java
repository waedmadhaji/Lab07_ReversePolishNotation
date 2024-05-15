package postfix;


import java.util.Collection;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import stack.Underflow;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Infix2PostfixTest {
	String comment, infix, postfix;
	double result;
	Postfix converter;



	public static Collection<Object[]> testInfixToPostfix() {
		Collection<Object[]> data = TestCases.generalTestCases();
		//data.addAll(TestCases.exponentialTestCases());
		//data.addAll(TestCases.multiDigitTestCases());
		return data;
	}

	@BeforeEach
	public void createConverter() {
		converter = new Postfix();
	}

	@ParameterizedTest
	@MethodSource
	public void testInfixToPostfix(String comment, String infix, String postfix,
								   double result) throws Underflow {
		assertEquals(comment + " (infix was: " + infix + ")", postfix,
				converter.infixToPostfix(infix));
	}




}
