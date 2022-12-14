package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    Button b11;
    Button b12;
    Button b13;
    Button b21;
    Button b22;
    Button b23;
    Button b31;
    Button b32;
    Button b33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getIntent().getExtras();
        Game finalGame = null;
        if (arguments != null){
            String firstName = arguments.getString("nameFirst");
            String secondName = arguments.getString("nameSecond");
            finalGame = new Game(firstName, secondName);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Game game = finalGame;
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        Button exit = findViewById(R.id.btn_exit);
        t2.setText(game.start().getName() + " ходит: ");
        b11 = findViewById(R.id.b_1_1);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    game.turn(0, 0);
                    b11.setText(game.mark);
                    b11.setEnabled(false);
                    //game.check();
                    if (game.check()) {
                        allButtonEnable();
                        exit.setVisibility(View.VISIBLE);
                    }
                    t2.setText(game.nextInfo);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        b12 = findViewById(R.id.b_1_2);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(0, 1);
                b12.setText(game.mark);
                b12.setEnabled(false);
                //game.check();
                if (game.check()) {
                    allButtonEnable();
                    exit.setVisibility(View.VISIBLE);
                }
                t2.setText(game.nextInfo);
            }
        });
        b13 = findViewById(R.id.b_1_3);
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(0, 2);
                b13.setText(game.mark);
                b13.setEnabled(false);
                //game.check();
                if (game.check()) {
                    allButtonEnable();
                    exit.setVisibility(View.VISIBLE);
                }
                t2.setText(game.nextInfo);
            }
        });
        b21 = findViewById(R.id.b_2_1);
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(1, 0);
                b21.setText(game.mark);
                b21.setEnabled(false);
                //game.check();
                if (game.check()) {
                    allButtonEnable();
                    exit.setVisibility(View.VISIBLE);
                }
                t2.setText(game.nextInfo);
            }
        });
        b22 = findViewById(R.id.b_2_2);
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(1, 1);
                b22.setText(game.mark);
                b22.setEnabled(false);
                //game.check();
                if (game.check()) {
                    allButtonEnable();
                    exit.setVisibility(View.VISIBLE);
                }
                t2.setText(game.nextInfo);
            }
        });
        b23 = findViewById(R.id.b_2_3);
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(1, 2);
                b23.setText(game.mark);
                b23.setEnabled(false);
                //game.check();
                if (game.check()) {
                    allButtonEnable();
                    exit.setVisibility(View.VISIBLE);
                }
                t2.setText(game.nextInfo);
            }
        });
        b31 = findViewById(R.id.b_3_1);
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(2, 0);
                b31.setText(game.mark);
                b31.setEnabled(false);
                //game.check();
                if (game.check()) {
                    allButtonEnable();
                    exit.setVisibility(View.VISIBLE);
                }
                t2.setText(game.nextInfo);
            }
        });
        b32 = findViewById(R.id.b_3_2);
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(2, 1);
                b32.setText(game.mark);
                b32.setEnabled(false);
                //game.check();
                if (game.check()) {
                    allButtonEnable();
                    exit.setVisibility(View.VISIBLE);
                }
                t2.setText(game.nextInfo);
            }
        });
        b33 = findViewById(R.id.b_3_3);
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(2, 2);
                b33.setText(game.mark);
                b33.setEnabled(false);
                //game.check();
                if (game.check()) {
                    allButtonEnable();
                    exit.setVisibility(View.VISIBLE);
                }
                t2.setText(game.nextInfo);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit.setTextSize(18);
                exit.setText("Нажмите второй раз для выхода");
                onDestroy();
            }
        });
    }
    public void allButtonEnable(){
        b11.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);
        b21.setEnabled(false);
        b22.setEnabled(false);
        b23.setEnabled(false);
        b31.setEnabled(false);
        b32.setEnabled(false);
        b33.setEnabled(false);
    }
}