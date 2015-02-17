package dataDriven;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedExampleTest {

	private Integer inputNumber;
	private boolean expectedResult;
	private ParametrizedExample pe;

	@Before
	public void initialize() {
		pe = new ParametrizedExample();
	}

	// each number should beplaced as as an argument here
	// every time the runner trigers, it will pass the arguments
	// from parameters we defined in primeNumbers example method

	public ParametrizedExampleTest(Integer inputNumber, Boolean expectedResult) {
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] { { 2, true }, { 6, false }, { 19, true }, { 22, false }, { 23, true } });

	}

	// This test will run 4 times since we have 5 parameters defined
	@Test
	public void testParametrizedExample() {
		// fail("Not yet implemented");
		System.out.println("Parameterized Number is : " + inputNumber);
		assertEquals(expectedResult, ParametrizedExample.validate(inputNumber));
	}

}
