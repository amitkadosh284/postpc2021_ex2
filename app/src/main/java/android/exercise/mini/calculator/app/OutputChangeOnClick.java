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


    public OutputChangeOnClick(SimpleCalculator calculator,TextView outputView, String action, int digit){
        this.calculator = calculator;
        this.outputView = outputView;
        switch (action){
            case DIGIT:
                this.calculator.insertDigit(digit);
                break;
            case MINUS:
                this.calculator.insertMinus();
                break;
            case PLUS:
                this.calculator.insertPlus();
                break;
            case EQUAL:
                this.calculator.insertEquals();
                break;
            case CLEAR:
                this.calculator.clear();
                break;
            case DELETE:
                this.calculator.deleteLast();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        this.outputView.setText(this.calculator.output());
    }
}
