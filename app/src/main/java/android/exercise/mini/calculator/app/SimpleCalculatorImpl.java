package android.exercise.mini.calculator.app;

import android.widget.Switch;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class SimpleCalculatorImpl implements SimpleCalculator {
  // todo: add fields as needed
  private String output  = "0";
  private final List<String> order = Arrays.asList("+", "-");

  @Override
  public String output() {
    // todo: return output based on the current state
    return this.output;
  }

  @Override
  public void insertDigit(int digit) {
    // todo: insert a digit
    if (0 <= digit & digit <= 9){
      if (this.output.equals("0")){
        this.output = Integer.toString(digit);
      }
      else {
        this.output = this.output + digit;
      }
    }
    else{
      throw new IllegalArgumentException();
    }
  }
  @Override
  public void insertPlus() {
    // todo: insert a plus
    if (this.output.length() > 0){
      String last_char = Character.toString(this.output.charAt(this.output.length()-1));
      boolean last_char_is_order = this.order.contains(last_char);
      if (!last_char_is_order){
        this.output = this.output + "+";
      }
    }
  }

  @Override
  public void insertMinus() {
    // todo: insert a minus
    if (this.output.length() > 0){
      String last_char = Character.toString(this.output.charAt(this.output.length()-1));
      boolean last_char_is_order = this.order.contains(last_char);
      if (!last_char_is_order){
        this.output = this.output + "-";
      }
    }
  }

  @Override
  public void insertEquals() {
    // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
    //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
    int result = 0;
    boolean has_operation = false;
    String operation = "";
    int last_index = 0;
    for (int i=0; i<=this.output.length(); i++){
      String current = "";
      if (i != this.output.length()){
        current = Character.toString(this.output.charAt(i));
      }
      if (i == this.output.length() || this.order.contains(current)){
        if(this.order.contains(current)){
          has_operation = true;
        }
        if (operation.isEmpty()){
          result = Integer.parseInt(this.output.substring(last_index,i));
        }
        else if (operation.equals("+")){
          result = result + Integer.parseInt(this.output.substring(last_index,i));
        }
        else if (operation.equals("-")){
          result = result - Integer.parseInt(this.output.substring(last_index,i));
        }
        operation = current;
        last_index = i + 1;
      }
    }
    if (has_operation){
      this.output = Integer.toString(result);
    }
  }

  @Override
  public void deleteLast() {
    // todo: delete the last input (digit, plus or minus)
    //  e.g.
    //  if input was "12+3" and called `deleteLast()`, then delete the "3"
    //  if input was "12+" and called `deleteLast()`, then delete the "+"
    //  if no input was given, then there is nothing to do here
    if (this.output.length() == 1){
      this.output = "0";
    }
    else if (this.output.length() > 1 ){
      this.output = this.output.substring(0, this.output.length() - 1);
    }
  }

  @Override
  public void clear() {
    // todo: clear everything (same as no-input was never given)
    this.output = "0";
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState(this.output);
    // todo: insert all data to the state, so in the future we can load from this state
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    this.output = casted.getOutput();
    // todo: use the CalculatorState to load
  }

  private static class CalculatorState implements Serializable {
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
    public String output;

    public CalculatorState(String output){
      this.output = output;
    }

    public String getOutput(){
      return this.output;
    }
  }
}
