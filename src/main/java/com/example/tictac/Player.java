package com.example.tictac;

public class Player extends  Game{
        private final String name;
        private final char symbol;
        public Player (String name, char symbol){
            this.name = name;
            this.symbol = symbol;
        }
        public String getSymbolString(){
            return symbol+"";
        }
        public char getSymbol(){
            System.err.println("method getSymbol (Player class) - ok");
            return symbol;
        }
        public char getOppisiteSymbol(){
            if (getSymbol()=='X')return 'O';
            else return 'X';
        }
        public String getName(){
            System.err.println("method getName (Player class) - ok");
            return name;
        }
        public void turn(int x, int y){
            System.err.println("method turn (Player class) - ok");
            super.field[y][x] = symbol;
        }
        public boolean checkWin(){
            System.err.println("method checkWin (Player class) - ok");
            return super.checkWin(symbol);
        }
}
