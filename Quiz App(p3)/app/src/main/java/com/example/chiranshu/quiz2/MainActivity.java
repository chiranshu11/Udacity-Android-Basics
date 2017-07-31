package com.example.chiranshu.quiz2;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final CheckBox check1 = (CheckBox) findViewById(R.id.ck_q1_a);
         final CheckBox check2 = (CheckBox) findViewById(R.id.ck_q1_b);
         final CheckBox check3 = (CheckBox) findViewById(R.id.ck_q1_c);
         final CheckBox check4 = (CheckBox) findViewById(R.id.ck_q1_d);
         submit = (Button) findViewById(R.id.submit_button);
        final String answer="seven";


        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(check2.isChecked() && check1.isChecked() && !check3.isChecked() && !check4.isChecked()){count++;}
                EditText txt = (EditText) findViewById(R.id.txt_id);
                EditText txt1 = (EditText) findViewById(R.id.txt_id1);
                String Q_txt = txt1.getText().toString().trim().toLowerCase();
                if (Objects.equals(Q_txt, answer)){count++;}
                String N_txt = txt.getText().toString();
                check1.setChecked(false);
                check2.setChecked(false);
                check3.setChecked(false);
                check4.setChecked(false);
                 txt.setText(null);
                RadioGroup r_1=(RadioGroup)findViewById(R.id.r1);

                RadioGroup r_2=(RadioGroup)findViewById(R.id.r2);

                RadioGroup r_3=(RadioGroup)findViewById(R.id.r3);
                RadioGroup r_5=(RadioGroup)findViewById(R.id.r5);
                RadioGroup r_6=(RadioGroup)findViewById(R.id.r6);
                RadioGroup r_7=(RadioGroup)findViewById(R.id.r7);

                Toast.makeText(MainActivity.this, N_txt + "! Your " + count + " answers are correct", Toast.LENGTH_SHORT).show();
                count = 0;
            }
        });

    }
    public void q1a(View view) {
            RadioButton ans1 = (RadioButton) findViewById(R.id.q1_a);
            if (ans1.isChecked()) {
                count = count + 1;
            }
        }

        public void q2b(View view) {
            RadioButton ans1 = (RadioButton) findViewById(R.id.q2_b);
            if (ans1.isChecked()) {
                count = count + 1;
            }
        }

        public void q3c(View view) {
            RadioButton ans1 = (RadioButton) findViewById(R.id.q3_c);
            if (ans1.isChecked()) {
                count = count + 1;
            }
        }

        public void q4d(View view) {
            RadioButton ans1 = (RadioButton) findViewById(R.id.q4_d);
            if (ans1.isChecked()) {
                count = count + 1;
            }
        }

        public void q5a(View view) {
            RadioButton ans1 = (RadioButton) findViewById(R.id.q5_a);
            if (ans1.isChecked()) {
                count = count + 1;
            }
        }

        public void q6d(View view) {
            RadioButton ans1 = (RadioButton) findViewById(R.id.q6_d);
            if (ans1.isChecked()) {
                count = count + 1;
            }
        }

}