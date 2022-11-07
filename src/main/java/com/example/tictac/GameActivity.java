package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

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
        TextView t3 = findViewById(R.id.t3);
        t2.setText(game.start().getName());
        Button b11 = findViewById(R.id.b_1_1);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    game.turn(0, 0);
                    b11.setText(game.mark);
                    //System.err.println("onClick from b11 - game.turn - ok");
                    b11.setEnabled(false);
                    //System.err.println("onClick from b11 - b11.setEnabled - ok");
                    game.check();
                    //System.err.println("onClick from b11 - game.check - ok");
                    t2.setText(game.nextInfo);
                    //System.err.println("onClick from b11 - t2.setText - ok");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        Button b12 = findViewById(R.id.b_1_2);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(0, 1);
                b12.setEnabled(false);
                game.check();
                t2.setText(game.nextInfo);
            }
        });
        Button b13 = findViewById(R.id.b_1_3);
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(0, 2);
                b13.setEnabled(false);
                game.check();
                t2.setText(game.nextInfo);
            }
        });
        Button b21 = findViewById(R.id.b_2_1);
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(1, 0);
                b21.setEnabled(false);
                game.check();
                t2.setText(game.nextInfo);
            }
        });
        Button b22 = findViewById(R.id.b_2_2);
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(1, 1);
                b22.setEnabled(false);
                game.check();
                t2.setText(game.nextInfo);
            }
        });
        Button b23 = findViewById(R.id.b_2_3);
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(1, 2);
                b23.setEnabled(false);
                game.check();
                t2.setText(game.nextInfo);
            }
        });
        Button b31 = findViewById(R.id.b_3_1);
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(2, 0);
                b31.setEnabled(false);
                game.check();
                t2.setText(game.nextInfo);
            }
        });
        Button b32 = findViewById(R.id.b_3_2);
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(2, 1);
                b32.setEnabled(false);
                game.check();
                t2.setText(game.nextInfo);
            }
        });
        Button b33 = findViewById(R.id.b_3_3);
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.turn(2, 2);
                b33.setEnabled(false);
                game.check();
                t2.setText(game.nextInfo);
            }
        });



    }
}