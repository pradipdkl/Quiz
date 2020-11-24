package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    private RadioGroup rbtn;
    private int Score=0;

    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;

    private CheckBox chk1;
    private CheckBox chk2;
    private CheckBox chk3;
    private CheckBox chk4;

    private EditText txt1;

    private Button nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rbtn=findViewById(R.id.radioGroupOne);

        check1=findViewById(R.id.check1);
        check2=findViewById(R.id.check2);
        check3=findViewById(R.id.check3);
        check4=findViewById(R.id.check4);

        chk1=findViewById(R.id.chk1);
        chk2=findViewById(R.id.chk2);
        chk3=findViewById(R.id.chk3);
        chk4=findViewById(R.id.chk4);

        txt1=findViewById(R.id.text1);

        nextbtn=findViewById(R.id.nextBtn);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Score=0;

                if(rbtn.getCheckedRadioButtonId()==R.id.rbtn4){
                    Score=Score+1;
                }

                if(check4.isChecked() && !check1.isChecked() && !check2.isChecked()
                        && !check3.isChecked()){
                    Score=Score+1;
                }
                if(chk1.isChecked() && !chk2.isChecked() && !chk3.isChecked()
                        && !chk4.isChecked()){
                    Score=Score+1;
                }

                String userAnswer = txt1.getText().toString();
                if(userAnswer.equalsIgnoreCase("linux")){
                    Score += 1;
                }

                Intent intent=new Intent(QuizActivity.this,ScoreActivity.class);
                intent.putExtra("SCORE",Score+"/4");
                startActivity(intent);

            }
        });
    }
}