package TickTackToe;

import java.util.Scanner;

public class TickTackToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j<3; j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X' ;
        boolean isGameOver = false ;

        Scanner scanner = new Scanner(System.in);
        int row = 0 ;
        int col = 0 ;
        while(!isGameOver) {
            printBoard(board);
            System.out.println("Player " + player + " make your move (row[0-2] column[0-2]): ");
             row  = scanner.nextInt();
             col  = scanner.nextInt();

            if(board[row][col] == ' ') {
                board[row][col] = player;
                if(isGameOver ){
                    System.out.println("Player " + player + " has won!");
                }else{
                    if(isFull(board)){
                        break;
                    }
                    if(player == 'X'){
                        player = 'O';
                    }else{
                        player = 'X';
                    }
                    isGameOver = haveWon(board);
                }
            }else if(isFull(board)){
                System.out.println("Game over");
            }
            else {
                System.out.println("This spot is taken, please try again.");
                System.out.println("Try again");
            }
        }
        printBoard(board);
        System.out.println("Player " + board[row][col] + " Has won the game.");
    }
    public  static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for(int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for(int j = 0; j<3; j++) {
                if(j == 2) {
                    System.out.println(board[i][j]);
                } else {
                    System.out.print(board[i][j] + "|");
                }
            }
            if(i != 2) {
                System.out.println("  -----");
            }
        }
    }
    public static boolean haveWon(char[][] board){
        for(int i = 0; i < 3; i++) {
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return true;
            }
        }
        //Checking colums
        for(int i = 0; i < 3; i++) {
            if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return true;
            }
        }
        //Checking diagonals left to right
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return true;
        }

        return false;
    }
    public static boolean isFull(char[][] board){
        //Checking if the board is full or not
        for(int i = 0 ; i < 3 ; i++){
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
