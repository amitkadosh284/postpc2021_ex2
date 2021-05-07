package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    textViewCalculatorOutput.setText(calculator.output());
//    - set click listeners on all buttons to operate on the calculator and refresh main text-view
    textViewButton0.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 0));
    textViewButton1.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 1));
    textViewButton2.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 2));
    textViewButton3.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 3));
    textViewButton4.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 4));
    textViewButton5.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 5));
    textViewButton6.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 6));
    textViewButton7.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 7));
    textViewButton8.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 8));
    textViewButton9.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"digit", 9));

    textViewClear.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput,"clear", 0));
    textViewPlus.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput, "plus", 0));
    textViewMinus.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput, "minus", 0));
    textViewEquals.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput, "equal", 0));
    viewBackSpace.setOnClickListener(new OutputChangeOnClick(this.calculator, textViewCalculatorOutput, "delete", 0));
    //
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
  }
}