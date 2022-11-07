package com.example.tictac;

import java.util.Random;

public class Game {
    static final int size = 3;
    public char[][] field = new char[size][size];
    private Player player1;
    private Player player2;
    private Player current;
    public String nextInfo = "test";
    public char mark = ' ';
    public Game(){}
    public Game(String nameFirst, String nameSecond) {
        player1 = new Player(nameFirst, 'X');
        player2 = new Player(nameSecond, 'O');
        initField();
    }
    public Player start(){
        System.err.println("method start - ok");
        Random rdm = new Random();
        int i = rdm.nextInt(1000);
        if (i <= 499) {
            current = player1;
        }
        else {
            current = player2;
        }
        mark = current.mark;
        return current;
    }
    public void turn(int x, int y){
        System.err.println("method turn (Game class) - ok");
        current.turn(x, y);
        /*if (current.equals(player1)) {
            current = player2;
            nextInfo = current.getName();
        }
        else {
            current = player1;
            nextInfo = current.getName();
        }*/
    }
    public boolean check(){
        System.err.println("method check - ok");
        if (current.checkWin()){
            nextInfo = current.getName() + " победил.";
            return current.checkWin();
        }
        if (checkDraw()){
            nextInfo = "Ничья.";
            return checkDraw();
        }
        else {
            if (current.equals(player1)) {
                current = player2;
                mark = current.mark;
                nextInfo = "Ходит " + current.getName() + ": ";
            }
            else {
                current = player1;
                current.getSymbol();
                nextInfo = "Ходит " + current.getName() + ": ";
            }
            return false;
        }
    }

    public boolean checkDraw(){
        System.err.println("method checkDraw (Game class) - ok");
        boolean result = true;
        int position = 1;
        for (int i = 0;i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                if (field[i][j] != intToChar(position)){
                    result = false;
                    position++;
                }
            }
        }
        return result;
    }

    public boolean checkWin(char symbol){
        System.err.println("method checkWin (Game class) - ok");
        boolean result = false;
        //если в любой строке три одинаковых символа
        for(int i = 0; i < field.length; i++){
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][2] == symbol){
                result = true;
                break;
            }
        }
        //если в любом столбце три одинаковых символа
        for(int j = 0; j < field[0].length; j++){
            if(field[0][j] == field[1][j] && field[1][j] == field[2][j]&& field[2][j] == symbol){
                result = true;
                break;
            }
        }
        //если на главной диагонали три одинаковых символа
        if(field[0][0] == field[1][1] && field[1][1] == field[2][2]&& field[2][2] == symbol)
            result = true;
            //если на побочной диагонали три одинаковых символа
        else if(field[0][2] == field[1][1] && field[1][1] == field[2][0]&& field[2][0] == symbol)
            result = true;
        return  result;
    }

    public char intToChar(int var){
        System.err.println("method inToChar - ok");
        String position1 = ""+var;
        return position1.charAt(0);
    }
    public void initField(){
        System.err.println("method initField - ok");
        final char positionSymbol = ' ';
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                field[i][j] = positionSymbol;
            }
        }
    }

    public void showField(){
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                System.out.print(field[i][j]+' ');
            }
            System.out.println();
        }
    }

    /*public String getNextInfo(){
        return getNextInfo();
    }*/
    /*public static void main(String[] args) {
        while (true){
            int count = 0;
            //игровой цикл
            while (true) {
                //ход крестиков
                player1.turn();
                //вывести поле
                printField();
                //если победа крестиков - конец игры - прервать цикл
                if (player1.checkWin()) {
                    System.out.print(player1.getName() + " win!");
                    break;
                }
                //ничья - конец игры - прервать цикл
                if (checkDraw(field)) {
                    System.out.print("Draw!");
                    break;
                }
                //ход ноликов
                player2.turn();
                //вывести поле
                printField();
                //если победа ноликов - конец игры - прервать цикл
                if (player2.checkWin()) {
                    System.out.print(player2.getName() + " win!");
                    break;
                }
                //ничья - конец игры - прервать цикл
                if (checkDraw(field)) {
                    System.out.print("Draw!");
                    break;
                }
                count++;
            }
            System.out.print(" Quantity steps: "+count);
            break;
        }
    }*/
}