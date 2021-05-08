package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }


//    TODO:
//    - find all views
    TextView textViewCalculatorOutput = findViewById(R.id.textViewCalculatorOutput);
    TextView textViewEquals = findViewById(R.id.buttonEquals);
    View viewBackSpace = findViewById(R.id.buttonBackSpace);
    TextView textViewMinus = findViewById(R.id.buttonMinus);
    TextView textViewPlus = findViewById(R.id.buttonPlus);
    TextView textViewClear = findViewById(R.id.buttonClear);
    TextView textViewButton0 = findViewById(R.id.button0);
    TextView textViewButton1 = findViewById(R.id.button1);
    TextView textViewButton2 = findViewById(R.id.button2);
    TextView textViewButton3 = findViewById(R.id.button3);
    TextView textViewButton4 = findViewById(R.id.button4);
    TextView textViewButton5 = findViewById(R.id.button5);
    TextView textViewButton6 = findViewById(R.id.button6);
    TextView textViewButton7 = findViewById(R.id.button7);
    TextView textViewButton8 = findViewById(R.id.button8);
    TextView textViewButton9 = findViewById(R.id.button9);

//    - initial update main text-view based on calculator's output
    textViewCalculatorOutput.setText(this.calculator.output());
//    - set click listeners on all buttons to operate on the calculator and refresh main text-view
    textViewButton0.setOnClickListener(this);
    textViewButton1.setOnClickListener(this);
    textViewButton2.setOnClickListener(this);
    textViewButton3.setOnClickListener(this);
    textViewButton4.setOnClickListener(this);
    textViewButton5.setOnClickListener(this);
    textViewButton6.setOnClickListener(this);
    textViewButton7.setOnClickListener(this);
    textViewButton8.setOnClickListener(this);
    textViewButton9.setOnClickListener(this);
    textViewClear.setOnClickListener(this);
    textViewPlus.setOnClickListener(this);
    textViewMinus.setOnClickListener(this);
    textViewEquals.setOnClickListener(this);
    viewBackSpace.setOnClickListener(this);
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
    outState.putSerializable("calculator", this.calculator.saveState());
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
    this.calculator.loadState(savedInstanceState.getSerializable("calculator"));
    TextView textViewCalculatorOutput = findViewById(R.id.textViewCalculatorOutput);
    textViewCalculatorOutput.setText(this.calculator.output());
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.button0:
        this.calculator.insertDigit(0);
        break;
      case R.id.button1:
        this.calculator.insertDigit(1);
        break;
      case R.id.button2:
        this.calculator.insertDigit(2);
        break;
      case R.id.button3:
        this.calculator.insertDigit(3);
        break;
      case R.id.button4:
        this.calculator.insertDigit(4);
        break;
      case R.id.button5:
        this.calculator.insertDigit(5);
        break;
      case R.id.button6:
        this.calculator.insertDigit(6);
        break;
      case R.id.button7:
        this.calculator.insertDigit(7);
        break;
      case R.id.button8:
        this.calculator.insertDigit(8);
        break;
      case R.id.button9:
        this.calculator.insertDigit(9);
        break;
      case R.id.buttonClear:
        this.calculator.clear();
        break;
      case R.id.buttonBackSpace:
        this.calculator.deleteLast();
        break;
      case R.id.buttonPlus:
        this.calculator.insertPlus();
        break;
      case R.id.buttonMinus:
        this.calculator.insertMinus();
        break;
      case R.id.buttonEquals:
        this.calculator.insertEquals();
        break;
    }
    TextView textViewCalculatorOutput = findViewById(R.id.textViewCalculatorOutput);
    textViewCalculatorOutput.setText(this.calculator.output());
  }
}