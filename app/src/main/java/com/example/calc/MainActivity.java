package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {


    private TextView solution;
    private EditText expression;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solution = findViewById(R.id.solution);
        expression = findViewById(R.id.expression);


        expression.setShowSoftInputOnFocus(false);


    }

    private void updateText(String addstr){
       String currentStr = expression.getText().toString();

       int CurPos = expression.getSelectionStart();
        String leftStr = currentStr.substring(0, CurPos);
        String rightStr = currentStr.substring(CurPos);

       expression.setText(String.format("%s%s%s", leftStr, addstr, rightStr));
       expression.setSelection(CurPos + addstr.length());
    }


    public void zeroBTN(View view){
        updateText(getResources().getString(R.string.ZeroTxt));
    }

    public void oneBTN(View view){
        updateText(getResources().getString(R.string.OneTxt));
    }
    public void twoBTN(View view){
        updateText(getResources().getString(R.string.TwoTxt));
    }

    public void threeBTN(View view){
        updateText(getResources().getString(R.string.ThreeTxt));
    }

    public void fourBTN(View view){
        updateText(getResources().getString(R.string.FourTxt));
    }
    public void fiveBTN(View view){
        updateText(getResources().getString(R.string.FiveTxt));
    }
    public void sixBTN(View view){
        updateText(getResources().getString(R.string.SixTxt));
    }

    public void sevenBTN(View view){
        updateText(getResources().getString(R.string.SevenTxt));
    }

    public void eightBTN(View view){
        updateText(getResources().getString(R.string.EightTxt));
    }

    public void nineBTN(View view){
        updateText(getResources().getString(R.string.NineTxt));
    }

    public void addBTN(View view){
        updateText(getResources().getString(R.string.AddTxt));
    }

    public void subBTN(View view){
        updateText(getResources().getString(R.string.SubTxt));
    }

    public void mulBTN(View view){
        updateText(getResources().getString(R.string.MultiplyTxt).replace('×', '*'));
    }

    public void divBTN(View view){
        updateText("/");
    }

    public void modBTN(View view){
        updateText("%");
    }

    public void clearBTN(View view){
        expression.setText("");
        solution.setText("");
    }

    public void pointBTN(View view){
        updateText(".");
    }

    public void equalsBTN(View view){

        String userExpression = expression.getText().toString();

         Expression exp = new Expression(userExpression);
        String result = String.valueOf(exp.calculate());
        solution.setText(result);


    }

    public void backspaceBTN(View view){
        int curPos = expression.getSelectionStart();
        int textLen = expression.getText().length();

        if (curPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) expression.getText();
            selection.replace(curPos - 1, curPos, "");
            expression.setText(selection);
            expression.setSelection(curPos - 1);
            String userExpression = expression.getText().toString();

            Expression exp = new Expression(userExpression);
            String result = String.valueOf(exp.calculate());
            solution.setText(result);

        }

    }
}