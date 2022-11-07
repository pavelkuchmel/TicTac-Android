package com.example.tictac;

public class Reserv {
    private final String nameFirst;
    private final String nameSecond;
    private char[][] field;

    public Reserv(){
        this.nameFirst = "Player1";
        this.nameSecond = "Player2";
        this.field = new char [3][3];
        fillField();
    }

    public Reserv(String nameFirst, String nameSecond) {
        this.nameFirst = nameFirst;
        this.nameSecond = nameSecond;
        this.field = new char [3][3];
        fillField();
    }

    public char move(int x, int y){
        return 'x';
    }

    public void fillField(){
        for(int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; i++){
                field[i][j] = ' ';
            }
        }
    }

    public String start(){
        return nameFirst;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameSecond() {
        return nameSecond;
    }
}
