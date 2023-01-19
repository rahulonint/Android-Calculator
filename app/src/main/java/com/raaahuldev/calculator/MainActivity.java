package com.raaahuldev.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

//to use that rhino library(Gradle build script), which is used to calculate data
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    TextView equation, result, c, brackets, mod, del, seven, eight, nine, div, four, five, six, mul, one, two, three, sub, zero, period, equals, plus;

    public String str = "";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equation = findViewById(R.id.equation);
        result = findViewById(R.id.result);
//        first row
        c = findViewById(R.id.c);
        brackets = findViewById(R.id.brackets);
        mod = findViewById(R.id.mod);
        del = findViewById(R.id.del);
//        second row
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        div = findViewById(R.id.div);
//        third row
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        mul = findViewById(R.id.mul);
//        fourth row
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        sub = findViewById(R.id.sub);
//        fifth row
        zero = findViewById(R.id.zero);
        period = findViewById(R.id.period);
        equals = findViewById(R.id.equals);
        plus = findViewById(R.id.plus);

//        ************************************** setting text result ***************************************
//        first row
        c.setOnClickListener(view -> {
            str = "";
            equation.setText(str);
            result.setText(str);
        });
        brackets.setOnClickListener(view -> {
            count++;
//            for open parenthesis
            if (count % 2 != 0) {
                if (str.equals("") || str.endsWith("+") || str.endsWith("-") || str.endsWith("/") || str.endsWith("*") || str.endsWith("%")) {
                    str += "(";
                    equation.setText(str);
                } else {
                    str += "*" + "(";
                    equation.setText(str);
                }
            }
//            for close parenthesis
            else if (str.contains("(")) {
                str += ")";
                equation.setText(str);
            }
        });
        mod.setOnClickListener(view -> {
            if (str.endsWith("+")) {
                str = str.substring(0, str.length() - 1) + "%";
                equation.setText(str);
            } else if (str.endsWith("-")) {
                str = str.substring(0, str.length() - 1) + "%";
                equation.setText(str);
            } else if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1) + "%";
                equation.setText(str);
            } else if (str.endsWith("*")) {
                str = str.substring(0, str.length() - 1) + "%";
                equation.setText(str);
            } else if (!str.endsWith(mod.getText().toString())) {
                str += mod.getText().toString();
                equation.setText(str);
            }
        });
        del.setOnClickListener(view -> {
            if (str.equals("")) {
                equation.setText("");
            } else {
                str = str.substring(0, str.length() - 1);
                equation.setText(str);
            }
        });
//      second row
        seven.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += seven.getText().toString();
            }
            equation.setText(str);
        });
        eight.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += eight.getText().toString();
            }
            equation.setText(str);
        });
        nine.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += nine.getText().toString();
            }
            equation.setText(str);
        });
        div.setOnClickListener(view -> {
            if (str.endsWith("+")) {
                str = str.substring(0, str.length() - 1) + "/";
                equation.setText(str);
            } else if (str.endsWith("-")) {
                str = str.substring(0, str.length() - 1) + "/";
                equation.setText(str);
            } else if (str.endsWith("%")) {
                str = str.substring(0, str.length() - 1) + "/";
                equation.setText(str);
            } else if (str.endsWith("*")) {
                str = str.substring(0, str.length() - 1) + "/";
                equation.setText(str);
            } else if (!str.endsWith(div.getText().toString())) {
                str += div.getText().toString();
                equation.setText(str);
            }
        });
//        third row
        four.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += four.getText().toString();
            }
            equation.setText(str);
        });
        five.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += five.getText().toString();
            }
            equation.setText(str);
        });
        six.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += six.getText().toString();
            }
            equation.setText(str);
        });
        mul.setOnClickListener(view -> {
            if (str.endsWith("+")) {
                str = str.substring(0, str.length() - 1) + "*";
                equation.setText(str);
            } else if (str.endsWith("-")) {
                str = str.substring(0, str.length() - 1) + "*";
                equation.setText(str);
            } else if (str.endsWith("%")) {
                str = str.substring(0, str.length() - 1) + "*";
                equation.setText(str);
            } else if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1) + "*";
                equation.setText(str);
            } else if (!str.endsWith("*")) {
                str += "*";
                equation.setText(str);
            }
        });
//        fourth row
        one.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += one.getText().toString();
            }
            equation.setText(str);
        });
        two.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += two.getText().toString();
            }
            equation.setText(str);
        });
        three.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += three.getText().toString();
            }
            equation.setText(str);
        });
        sub.setOnClickListener(view -> {
            if (str.endsWith("+")) {
                str = str.substring(0, str.length() - 1) + "-";
                equation.setText(str);
            } else if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1) + "-";
                equation.setText(str);
            } else if (str.endsWith("%")) {
                str = str.substring(0, str.length() - 1) + "-";
                equation.setText(str);
            } else if (str.endsWith("*")) {
                str = str.substring(0, str.length() - 1) + "-";
                equation.setText(str);
            } else if (!str.endsWith(sub.getText().toString())) {
                str += sub.getText().toString();
                equation.setText(str);
            }
        });
//        fifth row
        zero.setOnClickListener(view -> {
            if (str.endsWith(")")) {
                str += "*" + seven.getText().toString();
            } else {
                str += zero.getText().toString();
            }
            equation.setText(str);
        });
        period.setOnClickListener(view -> {
            if (!str.endsWith(period.getText().toString())) {
                str += period.getText().toString();
                equation.setText(str);
            }
        });
        equals.setOnClickListener(view -> {
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
                equation.setText(str);
                String finalResult = getResult(str);
                if (!finalResult.equals("err")) {
                    result.setText(finalResult);
                }
            } else if (!(str.contains("/") || str.contains("*") || str.contains("-") || str.contains("+") || str.contains("%"))) {
                result.setText(str);
            } else {
                String finalResult = getResult(str);
                if (!finalResult.equals("err")) {
                    result.setText(finalResult);
                }
            }
        });
        plus.setOnClickListener(view -> {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1) + "+";
                equation.setText(str);
            } else if (str.endsWith("-")) {
                str = str.substring(0, str.length() - 1) + "+";
                equation.setText(str);
            } else if (str.endsWith("%")) {
                str = str.substring(0, str.length() - 1) + "+";
                equation.setText(str);
            } else if (str.endsWith("*")) {
                str = str.substring(0, str.length() - 1) + "+";
                equation.setText(str);
            } else if (!str.endsWith(plus.getText().toString())) {
                str += plus.getText().toString();
                equation.setText(str);
            }
        });
    }

    //using the rhino library along with above import packages to calculate the value
    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e) {
            return "err";
        }
    }
}