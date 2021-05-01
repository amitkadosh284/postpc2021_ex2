package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.SimpleCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class SimpleCalculatorImplTest {

  @Test
  public void when_noInputGiven_then_outputShouldBe0(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_inputIsPlus_then_outputShouldBe0Plus(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertPlus();
    assertEquals("0+", calculatorUnderTest.output());
  }


  @Test
  public void when_inputIsMinus_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertMinus();
    String expected = "0-"; // TODO: decide the expected output when having a single minus
    assertEquals(expected, calculatorUnderTest.output());

  }

  @Test
  public void when_callingInsertDigitWithIllegalNumber_then_exceptionShouldBeThrown(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    try {
      calculatorUnderTest.insertDigit(357);
      fail("should throw an exception and not reach this line");
    } catch (RuntimeException e) {
      // good :)
    }
  }


  @Test
  public void when_callingDeleteLast_then_lastOutputShouldBeDeleted(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    String excepted = "12";
    assertEquals(excepted, calculatorUnderTest.output());
  }

  @Test
  public void when_callingClear_then_outputShouldBeCleared(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.clear();
    String excepted = "0";
    assertEquals(excepted, calculatorUnderTest.output());
  }

  @Test
  public void when_savingState_should_loadThatStateCorrectly(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);

    // save current state
    Serializable savedState = calculatorUnderTest.saveState();
    assertNotNull(savedState);

    // call `clear` and make sure calculator cleared
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    // load the saved state and make sure state was loaded correctly
    calculatorUnderTest.loadState(savedState);
    assertEquals("5+7", calculatorUnderTest.output());
  }

  @Test
  public void when_savingStateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();
    // TODO: implement the test based on this method's name.
    //  you can get inspiration from the test method `when_savingState_should_loadThatStateCorrectly()`
    firstCalculator.insertDigit(5);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(7);

    // save current state
    Serializable savedState = firstCalculator.saveState();
    assertNotNull(savedState);

    // load the saved state and make sure state was loaded correctly
    secondCalculator.loadState(savedState);
    assertEquals("5+7", secondCalculator.output());
  }

  @Test
  public void when_insert_plus_after_plus(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();

    String expected = "5+7+";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_insert_minus_after_plus(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();

    String expected = "5+7+";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_insert_equal_with_no_operation(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    String expected = "48";
    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertEquals();
    assertEquals("57", calculatorUnderTest.output());
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(9);
    assertEquals("57-9", calculatorUnderTest.output());
    calculatorUnderTest.insertEquals();
    assertEquals(expected, calculatorUnderTest.output());
  }


  @Test
  public void delete_last_a_lot() {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());
  }


  @Test
  public void plus_after_equal() {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    // 1+7-3=+4=
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertEquals();
    assertEquals("9", calculatorUnderTest.output());
  }

  @Test
  public void overload_data_from_first_calculator_to_second(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();
    // TODO: implement the test based on this method's name.
    //  you can get inspiration from the test method `when_savingState_should_loadThatStateCorrectly()`
    ///5-7+111-92<delete_Last>9
    firstCalculator.insertDigit(5);
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(7);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(9);
    firstCalculator.insertDigit(2);
    firstCalculator.deleteLast();
    firstCalculator.insertDigit(9);
    // save current state
    Serializable savedState = firstCalculator.saveState();
    assertNotNull(savedState);

    //make operation in second
    secondCalculator.insertDigit(5);
    secondCalculator.insertDigit(6);
    secondCalculator.insertDigit(7);
    secondCalculator.insertDigit(8);
    secondCalculator.insertDigit(5);
    assertEquals("56785",secondCalculator.output());

    // load the saved state and make sure state was loaded correctly
    secondCalculator.loadState(savedState);
    assertEquals("5-7+111-99", secondCalculator.output());
  }

  @Test
  public void overload_data_from_first_calculator_to_second_and_insert_equal_on_second(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();
    // TODO: implement the test based on this method's name.
    //  you can get inspiration from the test method `when_savingState_should_loadThatStateCorrectly()`
    ///555-7777+11111-92<delete_Last><delete_Last><delete_Last><delete_Last><delete_Last>9= (-6103)
    firstCalculator.insertDigit(5);
    firstCalculator.insertDigit(5);
    firstCalculator.insertDigit(5);
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(7);
    firstCalculator.insertDigit(7);
    firstCalculator.insertDigit(7);
    firstCalculator.insertDigit(7);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(9);
    firstCalculator.insertDigit(2);
    firstCalculator.deleteLast();
    firstCalculator.deleteLast();
    firstCalculator.deleteLast();
    firstCalculator.deleteLast();
    firstCalculator.deleteLast();
    firstCalculator.insertDigit(9);

    // save current state
    Serializable savedState = firstCalculator.saveState();
    assertNotNull(savedState);

    firstCalculator.clear();

    //make operation in second
    secondCalculator.insertDigit(5);
    secondCalculator.insertDigit(6);
    secondCalculator.insertDigit(7);
    secondCalculator.insertDigit(8);
    secondCalculator.insertDigit(5);
    assertEquals("56785",secondCalculator.output());

    // load the saved state and make sure state was loaded correctly
    secondCalculator.loadState(savedState);
    secondCalculator.insertEquals();
    assertEquals("-6103", secondCalculator.output());
  }

  @Test
  public void minus_after_equal(){
    //0-1=-1<deleteLast><deleteLast><deleteLast>+3
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();

    firstCalculator.insertMinus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertEquals();
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(1);
    firstCalculator.deleteLast();
    firstCalculator.deleteLast();
    firstCalculator.deleteLast();
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(3);
    assertEquals("-3", firstCalculator.output());
  }

  @Test
  public void clear_and_load_long(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();

    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertPlus();


    Serializable savedState = firstCalculator.saveState();
    assertNotNull(savedState);

    secondCalculator.loadState(savedState);
    String expexted = "1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+" +
            "1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+1111+";
    assertEquals(expexted, firstCalculator.output());
  }

  @Test
  public void long_test() {
    // 1111<delete>+2222<delete>-3333<delete>+4444<delete>=-1234=
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();

    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(1);
    firstCalculator.deleteLast();
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(2);
    firstCalculator.insertDigit(2);
    firstCalculator.insertDigit(2);
    firstCalculator.insertDigit(2);
    firstCalculator.deleteLast();
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(3);
    firstCalculator.insertDigit(3);
    firstCalculator.insertDigit(3);
    firstCalculator.insertDigit(3);
    firstCalculator.deleteLast();
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(4);
    firstCalculator.insertDigit(4);
    firstCalculator.insertDigit(4);
    firstCalculator.insertDigit(4);
    firstCalculator.deleteLast();
    firstCalculator.insertEquals();
    firstCalculator.insertMinus();
    firstCalculator.insertDigit(1);
    firstCalculator.insertDigit(2);
    firstCalculator.insertDigit(3);
    firstCalculator.insertDigit(4);
    firstCalculator.insertEquals();

    assertEquals("-790", firstCalculator.output());
  }
  // TODO:
  //  the existing tests are not enough since they only test simple use-cases with small inputs.
  //  write at least 10 methods to test correct behavior with complicated inputs or use-cases.
  //  examples:
  //  - given input "5+7-13<DeleteLast>25", expected output is "5+17-125"
  //  - given input "9<Clear>12<Clear>8-7=", expected output is "1"
  //  - given input "8-7=+4=-1=", expected output is "4"
  //  - given input "999-888-222=-333", expected output is "-111-333"
  //  - with 2 calculators, give them different inputs, then save state on first calculator and load the state into second calculator, make sure state loaded well
  //  etc etc.
  //  feel free to be creative in your tests!
}