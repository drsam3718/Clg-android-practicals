package com.example.mycalculator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.EmptyStackException;
import java.util.Stack;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button clear, plus, minus, mul, div, eql;
    TextView input_text, answer_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_text = (TextView) findViewById(R.id.input_text_view);
        input_text.setText("0");

        answer_text = (TextView) findViewById(R.id.answer_text_view);
        answer_text.setText("0");

        linkWithId(one, R.id.one);
        linkWithId(two, R.id.two);
        linkWithId(three, R.id.three);
        linkWithId(four, R.id.four);
        linkWithId(five, R.id.five);
        linkWithId(six, R.id.six);
        linkWithId(seven, R.id.seven);
        linkWithId(eight, R.id.eight);
        linkWithId(nine, R.id.nine);
        linkWithId(zero, R.id.zero);

        linkWithId(plus, R.id.plus);
        linkWithId(minus, R.id.minus);
        linkWithId(mul, R.id.mul);
        linkWithId(div, R.id.div);

        linkWithId(clear, R.id.clear);
        linkWithId(eql, R.id.eql);

    }

    void linkWithId(Button xyz, int id){
        xyz =findViewById(id);
        xyz.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String text =button.getText().toString();
        String display = input_text.getText().toString();

        if(input_text.getText().equals("0")) {
            input_text.setText(text);
        } else if (input_text.getText().equals("+")) {
            display = display + text;
            input_text.setText(display);

        } else if (input_text.getText().equals("-")) {
            display = display + text;
            input_text.setText(display);
        } else if (input_text.getText().equals("*")) {
            display = display + text;
            input_text.setText(display);
        } else if (input_text.getText().equals("/")) {
            display = display + text;
            input_text.setText(display);
        } else if (button.getText().equals("C")) {
            if (input_text.getText().equals("")){

            }else {
                display = display.substring(0, display.length() - 1);
                input_text.setText(display);
                answer_text.setText(String.valueOf(evaluate(display)));
            }
        } else if (button.getText().equals("=")) {
            input_text.setText(String.valueOf(evaluate(display)));
            answer_text.setText(String.valueOf(evaluate(display)));
        } else {
            display = display + text;
            input_text.setText(display);
            answer_text.setText(String.valueOf(evaluate(display)));
        }

    }

    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();

        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                try{
                    values.push(parseInt(sbuf.toString()));
                } catch (NumberFormatException ignored) {}
                i--;
            } else if (tokens[i] == '(') ops.push(tokens[i]);

            else if (tokens[i] == ')') {
                try {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.pop();
                } catch (EmptyStackException | NumberFormatException ignored) {
                }
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                try {
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.push(tokens[i]);
                } catch (EmptyStackException | NumberFormatException ignored) {
                }
            }
        }

        try {
            while (!ops.empty()) values.push(applyOp(ops.pop(), values.pop(), values.pop()));
            return values.pop();
        } catch (EmptyStackException | NumberFormatException ignored) {}

        return 0;
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }


}