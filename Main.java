package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = "         ";
        char[][] field = new char[3][3];
        char player = 'O';
        int counterX = 0;
        int counterO = 0;
        playerCount(field, input, counterX, counterO);
        printField(field);
        checkInput(field, counterX, counterO, player);
    }

    public static void playerCount(char[][] field, String input, int counterX, int counterO) {
        int l = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length && l < input.length(); j++, l++) {
                field[i][j] = input.charAt(l);
                if (field[i][j] == 'X') {
                    counterX++;
                } else if (field[i][j] == 'O') {
                    counterO++;
                }
            }
        }
    }
    public static void printField(char[][] field) {
        System.out.println("---------");
        System.out.println("| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |");
        System.out.println("---------");
    }

    public static boolean checkForWin(char[][] field, int counterX, int counterO) {
        boolean PlayerXWins = false;
        boolean PlayerOWins = false;

        if (field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X') {
            PlayerXWins = true;
        } else if (field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X') {
            PlayerXWins = true;
        } else if (field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X') {
            PlayerXWins = true;
        } else if (field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X') {
            PlayerXWins = true;
        } else if (field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X') {
            PlayerXWins = true;
        } else if (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') {
            PlayerXWins = true;
        } else if (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') {
            PlayerXWins = true;
        } else if (field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X') {
            PlayerXWins = true;
        }

        if (field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O') {
            PlayerOWins = true;
        } else if (field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O') {
            PlayerOWins = true;
        } else if (field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O') {
            PlayerOWins = true;
        } else if (field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O') {
            PlayerOWins = true;
        } else if (field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O') {
            PlayerOWins = true;
        } else if (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O') {
            PlayerOWins = true;
        } else if (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') {
            PlayerOWins = true;
        } else if (field[0][2] == 'O' && field[1][1] == 'O' && field[2][0] == 'O') {
            PlayerOWins = true;
        }

        for (char[] c : field) {
            for (char c_2 : c) {
                if (c_2 == 'X') {
                    counterX++;
                } else if (c_2 == 'O') {
                    counterO++;
                }
            }
        }

        if (PlayerXWins) {
            System.out.println("X wins");
        } else if (PlayerOWins) {
            System.out.println("O wins");
        } else if (counterX + counterO == 9) {
            System.out.println("Draw");
            return true;
        }
        return PlayerOWins || PlayerXWins;
    }

    public static void checkInput(char[][] field, int counterX, int counterO, char player) {
        Scanner scanner = new Scanner(System.in);
        boolean temp = true;
        while (temp) {

            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }

            try {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                if (n < 1 || n > 3 || m < 1 || m > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                    continue;
                } else if (field[n - 1][m - 1] == ' ' || field[n - 1][m - 1] == '_') {
                    field[n - 1][m - 1] = player;
                    printField(field);
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                    continue;
                }
                if (checkForWin(field, counterX,counterO)) {
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("You should enter numbers!");
                if (player == 'X') {
                    player = 'O';
                } else {
                    player = 'X';
                }
                temp = false;
                checkInput(field, counterX, counterO, player);
            }
        }
    }
}


