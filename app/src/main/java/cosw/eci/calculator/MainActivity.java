package cosw.eci.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Operation current_operation = Operation.IDLE;
    private TextView mem, input, op;
    private boolean error, just_eval;
    private double memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mem = findViewById(R.id.mem_value);
        op = findViewById(R.id.operation);
        input = findViewById(R.id.input_value);
        memory = 0;
        error = false;
        just_eval = false;
        initTextFields();
    }

    private void initTextFields() {
        mem.setText("");
        op.setText("");
        input.setText("");
        current_operation = Operation.IDLE;
    }

    public void clickButtonZero(View v) {
        if (input.getText().length() > 0 && !error) {
            if (just_eval) {
                input.setText("");
                just_eval = false;
            }
            input.setText(input.getText() + "0");
        }
    }

    public void clickButtonOne(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "1");
        }
    }

    public void clickButtonTwo(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "2");
        }
    }

    public void clickButtonThree(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "3");
        }
    }

    public void clickButtonFour(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "4");
        }
    }

    public void clickButtonFive(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "5");
        }
    }

    public void clickButtonSix(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "6");
        }
    }

    public void clickButtonSeven(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "7");
        }
    }

    public void clickButtonEight(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "8");
        }
    }

    public void clickButtonNine(View v) {
        if (just_eval) {
            input.setText("");
            just_eval = false;
        }
        if (!error) {
            input.setText(input.getText() + "9");
        }
    }

    public void clickButtonPoint(View v) {
        if (!input.getText().toString().contains(".")) {
            if (just_eval) {
                input.setText("");
                just_eval = false;
            }
            if (!error) {
                input.setText(input.getText() + ".");
            }
        }
    }

    public void clickButtonAC(View v) {
        current_operation = Operation.IDLE;
        initTextFields();
        memory = 0;
        error = false;
    }

    public void clickButtonSignFlip(View v) {
        try {
            double inputNum = Double.parseDouble(input.getText().toString()) * -1;
            input.setText(String.valueOf(inputNum));
        } catch (Exception e) {
            input.setText("ERROR");
        }
    }

    public void clickAdd(View v) {
        current_operation = Operation.ADD;
        op.setText("+");
        if (input.getText().length() > 0) {
            mem.setText(input.getText());
            input.setText("");
        }
    }

    public void clickSubtract(View v) {
        current_operation = Operation.SUBTRACT;
        op.setText("-");
        if (input.getText().length() > 0) {
            mem.setText(input.getText());
            input.setText("");
        }
    }

    public void clickMultiply(View v) {
        current_operation = Operation.MULTIPLY;
        op.setText("*");
        if (input.getText().length() > 0) {
            mem.setText(input.getText());
            input.setText("");
        }
    }

    public void clickDivide(View v) {
        current_operation = Operation.DIVIDE;
        op.setText("/");
        if (input.getText().length() > 0) {
            mem.setText(input.getText());
            input.setText("");
        }
    }

    public void clickPow(View v) {
        current_operation = Operation.POW;
        op.setText("POW");
        if (input.getText().length() > 0) {
            mem.setText(input.getText());
            input.setText("");
        }
    }

    public void clickEval(View v) {
        if (current_operation == Operation.ADD) {
            try {
                double in1 = Double.parseDouble(mem.getText().toString());
                double in2 = input.getText().equals("") ? 0 : Double.parseDouble(input.getText().toString());
                initTextFields();
                double res = in1 + in2;
                if (res == (int) res) {
                    int temp = (int) res;
                    input.setText(String.valueOf(temp));
                } else {
                    input.setText(String.valueOf(res));
                }
            } catch (Exception e) {
                initTextFields();
                input.setText("ERROR");
                error = true;
            }
        } else if (current_operation == Operation.SUBTRACT) {
            try {
                double in1 = Double.parseDouble(mem.getText().toString());
                double in2 = input.getText().equals("") ? 0 : Double.parseDouble(input.getText().toString());
                initTextFields();
                double res = in1 - in2;
                if (res == (int) res) {
                    int temp = (int) res;
                    input.setText(String.valueOf(temp));
                } else {
                    input.setText(String.valueOf(res));
                }
            } catch (Exception e) {
                initTextFields();
                input.setText("ERROR");
                error = true;
            }
        } else if (current_operation == Operation.MULTIPLY) {
            try {
                double in1 = Double.parseDouble(mem.getText().toString());
                double in2 = input.getText().equals("") ? 1 : Double.parseDouble(input.getText().toString());
                initTextFields();
                double res = in1 * in2;
                if (res == (int) res) {
                    int temp = (int) res;
                    input.setText(String.valueOf(temp));
                } else {
                    input.setText(String.valueOf(res));
                }
            } catch (Exception e) {
                initTextFields();
                input.setText("ERROR");
                error = true;
            }
        } else if (current_operation == Operation.DIVIDE) {
            try {
                double in1 = Double.parseDouble(mem.getText().toString());
                double in2 = input.getText().equals("") ? 1 : Double.parseDouble(input.getText().toString());
                initTextFields();
                double res = in1 / in2;
                if (res == (int) res) {
                    int temp = (int) res;
                    input.setText(String.valueOf(temp));
                } else {
                    input.setText(String.valueOf(res));
                }
            } catch (Exception e) {
                initTextFields();
                input.setText("ERROR");
                error = true;
            }

        } else if (current_operation == Operation.POW) {
            try {
                double in1 = Double.parseDouble(mem.getText().toString());
                double in2 = input.getText().equals("") ? 1 : Double.parseDouble(input.getText().toString());
                initTextFields();
                double res = Math.pow(in1, in2);
                if (res == (int) res) {
                    int temp = (int) res;
                    input.setText(String.valueOf(temp));
                } else {
                    input.setText(String.valueOf(res));
                }
            } catch (Exception e) {
                initTextFields();
                input.setText("ERROR");
                error = true;
            }
        }
        just_eval = true;
        current_operation = Operation.IDLE;
    }

    public void clickSin(View v) {
        try {
            double in = Double.parseDouble(input.getText().toString());
            mem.setText(String.valueOf(in));
            op.setText("SIN");
            input.setText(String.valueOf(Math.sin(Math.toRadians(in))));
            current_operation = Operation.IDLE;
            just_eval = true;
        } catch (Exception e) {
            initTextFields();
            input.setText("ERROR");
            error = true;
        }
    }

    public void clickCos(View v) {
        try {
            double in = Double.parseDouble(input.getText().toString());
            mem.setText(String.valueOf(in));
            op.setText("COS");
            input.setText(String.valueOf(Math.cos(Math.toRadians(in))));
            current_operation = Operation.IDLE;
            just_eval = true;
        } catch (Exception e) {
            initTextFields();
            input.setText("ERROR");
            error = true;
        }
    }

    public void clickTan(View v) {
        try {
            double in = Double.parseDouble(input.getText().toString());
            mem.setText(String.valueOf(in));
            op.setText("TAN");
            input.setText(String.valueOf(Math.tan(Math.toRadians(in))));
            current_operation = Operation.IDLE;
            just_eval = true;
        } catch (Exception e) {
            initTextFields();
            input.setText("ERROR");
            error = true;
        }
    }

    public void clickAddMem(View v) {
        try {
            double in = Double.parseDouble(input.getText().toString());
            memory += in;
        } catch (Exception e) {
            initTextFields();
            input.setText("ERROR");
            error = true;
        }
    }

    public void clickGetMem(View v) {
        if (memory == (int) memory) {
            int temp = (int) memory;
            input.setText(String.valueOf(temp));
        } else {
            input.setText(String.valueOf(memory));
        }
    }
}