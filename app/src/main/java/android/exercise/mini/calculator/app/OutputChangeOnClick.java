package android.exercise.mini.calculator.app;

import android.view.View;
import android.widget.TextView;

public class OutputChangeOnClick implements View.OnClickListener {
    private static final String DIGIT = "digit";
    private static final String MINUS = "minus";
    private static final String PLUS = "plus";
    private static final String EQUAL = "equal";
    private static final String CLEAR = "clear";
    private static final String DELETE = "delete";
    private final SimpleCalculator calculator;
    private final TextView outputView;
    private final String action;
    private final int digit;


    public OutputChangeOnClick(SimpleCalculator calculator,TextView outputView, String action, int digit){
        this.action = action;
        this.calculator = calculator;
        this.digit = digit;
        this.outputView = outputView;
    }

    @Override
    public void onClick(View v) {
        switch (this.action){
            case DIGIT:
                this.calculator.insertDigit(this.digit);
            case MINUS:
                this.calculator.insertMinus();
            case PLUS:
                this.calculator.insertPlus();
            case EQUAL:
                this.calculator.insertEquals();
            case CLEAR:
                this.calculator.clear();
            case DELETE:
                this.calculator.deleteLast();
        }
        this.outputView.setText(this.calculator.output());
    }
}
