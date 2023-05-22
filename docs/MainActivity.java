
package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText Edit1, Edit2;
Button btnp, btnm, btnmul, btndiv;
TextView textResult;
String num1, num2;
Integer result;
Button[] numButtons = new Button[10];
Integer[] numBtnIDs = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
int i;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Edit1 = (EditText) findViewById(R.id.Edit1);
    Edit2 = (EditText) findViewById(R.id.Edit2);
    btnp = (Button) findViewById(R.id.btnp);
    btnm = (Button) findViewById(R.id.btnm);
    btnmul = (Button) findViewById(R.id.btnmul);
    btndiv = (Button) findViewById(R.id.btndiv);
    textResult = (TextView) findViewById(R.id.textResult);

    btnp.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            num1 = Edit1.getText().toString();
            num2 = Edit2.getText().toString();
            result = Integer.parseInt(num1) + Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result.toString());
            return false;
        }
    });

    btnm.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            num1 = Edit1.getText().toString();
            num2 = Edit2.getText().toString();
            result = Integer.parseInt(num1) - Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result.toString());
            return false;
        }
    });

    btnmul.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            num1 = Edit1.getText().toString();
            num2 = Edit2.getText().toString();
            result = Integer.parseInt(num1) * Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result.toString());
            return false;
        }
    });

    btndiv.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            num1 = Edit1.getText().toString();
            num2 = Edit2.getText().toString();
            result = Integer.parseInt(num1) / Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result.toString());
            return false;
        }
    });

    for (i = 0; i < numBtnIDs.length; i++) {
        numButtons[i] = (Button) findViewById(numBtnIDs[i]);
    }
    for (i = 0; i < numBtnIDs.length; i++) {

        final int index; // 주의! 꼭 필요함..
        index = i;

        numButtons[index].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 포커스가 되어 있는 에디트텍스트에 숫자 추가
                if (Edit1.isFocused() == true) {
                    num1 = Edit1.getText().toString()
                            + numButtons[index].getText().toString();
                    Edit1.setText(num1);
                } else if (Edit2.isFocused() == true) {
                    num2 = Edit2.getText().toString()
                            + numButtons[index].getText().toString();
                    Edit2.setText(num2);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "먼저 에디트텍스트를 선택하세요",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }




}
}
