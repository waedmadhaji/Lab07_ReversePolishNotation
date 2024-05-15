package postfix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostfixEvaluationTest {
	String comment, infix, postfix;
	double result;
	Postfix postfixEvaluator;

	public PostfixEvaluationTest(String comment, String infix, String postfix,
			double result) {
		this.comment = comment;
		this.infix = infix;
		this.postfix = postfix;
		this.result = result;
	}

	public static Collection<Object[]> data() {
		Collection<Object[]> data = TestCases.generalTestCases();
		//data.addAll(TestCases.exponentialTestCases());
		//data.addAll(TestCases.multiDigitTestCases());
		return data;
	}

	@BeforeEach
	public void createPostfix() {
		postfixEvaluator = new Postfix();
	}

	@Test
	public void testEvaluatePostfix() {
		//assertEquals(comment + " (postfix was: " + postfix+")", result,
		//		postfixEvaluator.evaluate(postfix), 0.0);

	}

}
