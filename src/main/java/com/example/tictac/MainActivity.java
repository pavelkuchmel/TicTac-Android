package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameFirst, nameSecond;
    Button start, test;
    Boolean edNameFirst = false;
    Boolean edNameSecond = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.btn_start);
        start.setEnabled(false);
        test = findViewById(R.id.btn_test);

        nameFirst = findViewById(R.id.et_fp_name);
        nameSecond = findViewById(R.id.et_sp_name);

        nameFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) edNameFirst = true;
                else edNameFirst = false;
                check();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        nameSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) edNameSecond = true;
                else edNameSecond = false;
                check();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    public void check(){
        if (edNameFirst && edNameSecond) start.setEnabled(true);
        else start.setEnabled(false);
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        nameFirst = findViewById(R.id.et_fp_name);
        nameSecond = findViewById(R.id.et_sp_name);
        String firstName = nameFirst.getText().toString();
        String secondName = nameSecond.getText().toString();
        intent.putExtra("nameFirst", firstName);
        intent.putExtra("nameSecond", secondName);
        startActivity(intent);
    }
    public void onClickTest(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        String firstName = "Player1";
        String secondName = "Player2";
        intent.putExtra("nameFirst", firstName);
        intent.putExtra("nameSecond", secondName);
        startActivity(intent);
    }
}