import java.util.Scanner;

public class TicTacToe {
    static Scanner in;
    static String[] board;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        board = new String[9];
        int spielzug = 0;

        for (int i = 0; i < board.length; i++) {
            board[i] = String.valueOf(i + 1);
        }

        System.out.println("Erster Mensch, wie lautet dein Name?");
        String player1 = in.next();
        System.out.println("Schön dich kennen zu lernen, " + player1 + "! Es wird nun von dir der erste Zug erwartet.");
        printBoard();
        turn("X");

        System.out.println("Zweiter Mensch, wie lautet dein Name?");
        String player2 = in.next();
        System.out.println("Nun, " + player2 + ", jetzt bist auch du am Zug.");
        printBoard();
        turn("O");

        while (!checkWin("X") & !checkWin("O")) {
            spielzug++;
            if (spielzug % 2 == 1) {
                System.out.println(player1 + " ist an der Reihe.");
                printBoard();
                turn("X");
            }
            else {
                System.out.println(player2 + " ist an der Reihe.");
                printBoard();
                turn("O");
            }
        }

        printBoard();
        System.out.println("Bravo, jemand hat gewonnen!");
        System.exit(0);

    }

    private static void printBoard() {
        System.out.println("/---|---|---\\");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("\\---|---|---/");
    }

    private static void turn(String xoro) {
        int field = in.nextInt();
        board[field - 1] = xoro;
        System.out.println(field - 1);
        /*
        if (!board[field - 1].equals(xoro)) {
            board[field - 1] = xoro;
        }
        else {
            System.out.println("Diese Position ist schon besetzt.");
        }
         */
    }

    private static boolean checkWin(String xoro) {

        if (board[0].equals(xoro) & board[1].equals(xoro) & board[2].equals(xoro)) {
            return true;
        }
        else if (board[3].equals(xoro) & board[4].equals(xoro) & board[5].equals(xoro)) {
            return true;
        }
        else if (board[6].equals(xoro) & board[7].equals(xoro) & board[8].equals(xoro)) {
            return true;
        }
        else if (board[0].equals(xoro) & board[3].equals(xoro) & board[6].equals(xoro)) {
            return true;
        }
        else if (board[1].equals(xoro) & board[4].equals(xoro) & board[7].equals(xoro)) {
            return true;
        }
        else if (board[2].equals(xoro) & board[5].equals(xoro) & board[8].equals(xoro)) {
            return true;
        }
        else if (board[0].equals(xoro) & board[4].equals(xoro) & board[8].equals(xoro)) {
            return true;
        }
        else if (board[2].equals(xoro) & board[4].equals(xoro) & board[6].equals(xoro)) {
            return true;
        }
        else return false;
    }

}