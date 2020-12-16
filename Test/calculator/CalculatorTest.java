package calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import exceptions.DivisionByZero;
import exceptions.NotSupportedOperationException;

class CalculatorTest {
	
	Calculator c1=new Calculator();
	Calculator c2=new Calculator(2.2);
	Calculator c3=new Calculator(2);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		c1.setCurrentValue(0);
		c2.setCurrentValue(2.2);
		c3.setCurrentValue(2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculator() {
		assertThat(c1.getCurrentValue(), is(0.0));
	}

	@Test
	void testCalculatorDouble() {
		assertThat(c2.getCurrentValue(), is(2.2));
	}

	@Test
	void testCalculatorInteger() {
		assertThat(c3.getCurrentValue(), is(2.0));
	}

	@ParameterizedTest
	@DisplayName("Test za metodu calculate")
	@MethodSource("parametri")
	void testCalculate(Double currentvalue,Double value,char op,Double rezultat) throws DivisionByZero, NotSupportedOperationException {
		c2.setCurrentValue(currentvalue);
		c2.calculate(value, op);
		assertThat(c2.getCurrentValue(), Matchers.is(rezultat));
	}
	
	private static Stream<Arguments> parametri()
	{
		return Stream.of(
				Arguments.of(2.3,1.6,"*".charAt(0),3.68),
				Arguments.of(16.23,3.2,"-".charAt(0),13.03),
				Arguments.of(-8.621,3.7,"/".charAt(0),-2.33),
				Arguments.of(4.2,1.16,"+".charAt(0),5.36)
				);
	}
	
	@Test
	@DisplayName("Test za DivisionByZero gresku")
	void errorDivisionByZero()
	{
		DivisionByZero exc=assertThrows(DivisionByZero.class, ()->{
			c2.calculate(0.0, "/".charAt(0));;
		});
		
		assertThat(exc.getMessage(),is("Dijeljenje sa 0 nije moguce."));
	}
	
	@ParameterizedTest
	@DisplayName("Test za NotSupportedOperationException gresku")
	@MethodSource("greske")
	void errorNotSupportedOperation(char op)
	{
		NotSupportedOperationException exc=assertThrows(NotSupportedOperationException.class, ()->{
			c2.calculate(12.2, op);
		});
		
		assertThat(exc.getMessage(),is("Nije podrzan operator "+op));
	}
	
	private static Stream<Arguments> greske()
	{
		return Stream.of(
				Arguments.of("?".charAt(0)),
				Arguments.of("M".charAt(0)),
				Arguments.of("3".charAt(0)),
				Arguments.of("<".charAt(0))
				);
	}
}
