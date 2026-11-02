import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        int[] board = new int[9];
        for(int i = 0; i < 9; i++) {
            board[i] = 0;
        }
        // for reference 0 = empty, 1 = x, 2 = o
        Scanner scanner = new Scanner(System.in);
        boolean gameFinished = false;
        boolean isXPlayer = true;
        System.out.println("Game Start: Play by entering a number 1-9 for what spot you want to mark. the numbers go from left to right and top to bottom. Player 1 goes first with X");
        while(!gameFinished) {
            for(int i = 0; i < 9; i++) {
                if(board[i] == 0) {
                    System.out.print("_ ");
                }else if(board[i] == 1) {
                    System.out.print("X ");
                }else {
                    System.out.print("O ");
                }
                if((i+1)%3 == 0) {
                    System.out.println();
                }
            }
            int answer = Integer.parseInt(scanner.nextLine());
            if(isXPlayer) {
                board[answer-1] = 1;
            }else {
                board[answer-1] = 2;
            }
            int player = 0;
            if(isXPlayer) {
                player = 1;
            }else {
                player = 2;
            }

            if(board[0] == player && board[1] == player && board[2] == player) {
                gameFinished = true;
            }
            if(board[3] == player && board[4] == player && board[5] == player) {
                gameFinished = true;
            }
            if(board[6] == player && board[7] == player && board[8] == player) {
                gameFinished = true;
            }
            if(board[0] == player && board[3] == player && board[6] == player) {
                gameFinished = true;
            }
            if(board[1] == player && board[4] == player && board[7] == player) {
                gameFinished = true;
            }
            if(board[2] == player && board[5] == player && board[8] == player) {
                gameFinished = true;
            }
            if(board[0] == player && board[4] == player && board[8] == player) {
                gameFinished = true;
            }
            if(board[2] == player && board[4] == player && board[6] == player) {
                gameFinished = true;
            }
            if(gameFinished) {
                System.out.println("Player " + player + " won!");
            }else {
                int count = 9;
                for(int i = 0; i < 9; i++) {
                    if(board[i] == 0) {
                        count--;
                    }
                }
                if(count == 9) {
                    gameFinished = true;
                    System.out.println("Game ended in Draw");
                }
            }
            isXPlayer = !isXPlayer;
        }

        for(int i = 0; i < 9; i++) {
            if(board[i] == 0) {
                System.out.print("_");
            }else if(board[i] == 1) {
                System.out.print("X");
            }else {
                System.out.print("O");
            }
            if((i+1)%3 == 0) {
                System.out.println();
            }
        }

    }
}
