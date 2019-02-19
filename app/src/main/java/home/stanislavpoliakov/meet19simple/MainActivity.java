package home.stanislavpoliakov.meet19simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultView;
    private CalculateUtils calcUtils = new CalculateUtils();
    private String operator;
    private boolean isSecondOperand = false;
    private StringBuilder operand1 = new StringBuilder(), operand2 = new StringBuilder();
    private Button buttonEqual;

    private View.OnClickListener numeralListener = v -> {
        Button button = (Button) v;
        if (!isSecondOperand) {
            operand1.append(button.getText().toString());
            resultView.setText(operand1.toString());
        } else {
            operand2.append(button.getText().toString());
            resultView.setText(operand2.toString());
        }
        buttonEqual.setEnabled(!operand1.toString().isEmpty() && !operand2.toString().isEmpty());
    };

    private View.OnClickListener operatorListener = v -> {
        Button button = (Button) v;
        operator = button.getText().toString();
        isSecondOperand = true;
        //buttonEqual.setEnabled(true);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        resultView = findViewById(R.id.resultView);

        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(numeralListener);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(numeralListener);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(numeralListener);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(numeralListener);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(numeralListener);

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(numeralListener);

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(numeralListener);

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(numeralListener);

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(numeralListener);

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(numeralListener);

        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(v -> clearAll());

        Button buttonDot = findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(v -> addDot());

        buttonEqual = findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(v -> {
            //gotEqual();
            double result = gotEqual(Double.parseDouble(operand1.toString()),
                    Double.parseDouble(operand2.toString()));
            showResult(result);
        });

        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(operatorListener);

        Button buttonSub = findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(operatorListener);

        Button buttonMul = findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(operatorListener);

        Button buttonDiv = findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(operatorListener);
    }

    private void addDot() {
        if (!isSecondOperand) {
            if (!operand1.toString().contains(".")) operand1.append(".");
        } else {
            if (!operand2.toString().contains(".")) operand2.append(".");
        }
    }

    private void clearAll() {
        operand1.setLength(0);
        operand2.setLength(0);
        isSecondOperand = false;
        operator = "";
        resultView.setText("RESULT");
        buttonEqual.setEnabled(false);
    }

    private double gotEqual(double d1, double d2) {
        switch (operator) {
            case "+":
                return calcUtils.addition(d1, d2);
            case "-":
                return calcUtils.subtraction(d1, d2);
            case "*":
                return calcUtils.multiplication(d1, d2);
            case "/":
                return calcUtils.division(d1, d2);
            default:
                return Double.NaN;
        }
    }

    private void showResult(double result) {
        clearAll();
        operand1.append(String.valueOf(Double.isFinite(result) ? result : 0));
        resultView.setText(String.valueOf(result));
    }
}
