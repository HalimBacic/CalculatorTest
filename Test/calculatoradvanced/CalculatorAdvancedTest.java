package calculatoradvanced;

import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.DivisionByZero;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

class CalculatorAdvancedTest {
	
	CalculatorAdvanced ca1=new CalculatorAdvanced();
	CalculatorAdvanced ca2=new CalculatorAdvanced(2.1);
	CalculatorAdvanced ca3=new CalculatorAdvanced(1);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ca1.setCurrentValue(0.0);
		ca2.setCurrentValue(2.1);
		ca3.setCurrentValue(1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculatorAdvanced() {
		assertThat(ca1.getCurrentValue(), is(0.0));
	}

	@Test
	void testCalculatorAdvancedDouble() {
		assertThat(ca2.getCurrentValue(), is(2.1));
	}

	@Test
	void testCalculatorAdvancedInteger() {
		assertThat(ca3.getCurrentValue(), is(1.0));
	}

	@ParameterizedTest
	@MethodSource("parametriCalculateAdvanced")
	void testCalculateAdvanced(Double value,char option,Double rezultat) throws NumberNotInAreaException {
		ca2.setCurrentValue(value);
		ca2.calculateAdvanced(option);
		assertThat(rezultat,is(ca2.getCurrentValue()));
	}

	private static Stream<Arguments> parametriCalculateAdvanced()
	{
		return Stream.of(
				Arguments.of(5.0,"!".charAt(0),120.0),
				Arguments.of(4.0,"!".charAt(0),24.0),
				Arguments.of(3.0,"3".charAt(0),27.0),
				Arguments.of(16.3,"2".charAt(0),265.69)
				);
	}
	
	@Test
	void testFactorial() throws NotSupportedOperationException, DivisionByZero {
		ca3.setCurrentValue(5);
		ca3.factorial();
		assertThat(120.0,is(ca3.getCurrentValue()));
		ca2.setCurrentValue(0);
		ca2.factorial();
		assertThat(1.0,is(ca2.getCurrentValue()));
	}
	
	@Test
	void testStepenovanje() throws NotSupportedOperationException, DivisionByZero {
		ca1.setCurrentValue(3.2);
		ca1.stepenovanje(3);
		assertThat(32.77, is(ca1.getCurrentValue()));
		ca2.setCurrentValue(6);
		ca2.stepenovanje(4);
		assertThat(1296.0, is(ca2.getCurrentValue()));
	}

	@Test
	void hasCharacteristicExc() {
			
			assertThrows(NumberNotInAreaException.class, ()->{
				ca1.hasCharacteristic("0".charAt(0));
			});
			
			
	}
	
	@ParameterizedTest
	@MethodSource("parametriCharacteristic")
	void testHasCharacteristic(boolean status, char c, Double number) throws NumberNotInAreaException {
		ca2.setCurrentValue(number);
		assertThat(status,is(ca2.hasCharacteristic(c)));
	}
	
	private static Stream<Arguments> parametriCharacteristic()
	{
		return Stream.of(
				Arguments.of(true,"P".charAt(0),496.0),
				Arguments.of(false,"P".charAt(0),495.0),
				Arguments.of(true,"A".charAt(0),153.0),
				Arguments.of(false,"A".charAt(0),154.0),
				Arguments.of(false,"K".charAt(0),23.1)
				);
	}
	

	@Test
	void testIsSavrsen() throws NumberNotInAreaException {
		ca2.setCurrentValue(8128);
		assertThat(false,not(ca2.hasCharacteristic("P".charAt(0))));
		assertThat(true,is(ca2.hasCharacteristic("P".charAt(0))));
	}

	@Test
	void testIsArmstrong() throws NumberNotInAreaException {
		ca2.setCurrentValue(371);
		boolean status=ca2.hasCharacteristic("A".charAt(0));
		assertThat(false,not(status));
		assertThat(true,is(status));
	}
}
