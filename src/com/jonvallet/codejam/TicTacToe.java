package com.jonvallet.codejam;

import junit.framework.Assert;
import org.junit.Test;

import java.io.*;

/**
 * Tic-Tac-Toe-Tomek is a game played on a 4 x 4 square board. The board starts empty, except that a single 'T' symbol
 * may appear in one of the 16 squares. There are two players: X and O. They take turns to make moves, with X starting.
 * In each move a player puts her symbol in one of the empty squares. Player X's symbol is 'X', and player O's symbol is 'O'.
 * <p/>
 * After a player's move, if there is a row, column or a diagonal containing 4 of that player's symbols, or containing 3
 * of her symbols and the 'T' symbol, she wins and the game ends. Otherwise the game continues with the other player's move. If all of the fields are filled with symbols and nobody won, the game ends in a draw. See the sample input for examples of various winning positions.
 * <p/>
 * Given a 4 x 4 board description containing 'X', 'O', 'T' and '.' characters (where '.' represents an empty square),
 * describing the current state of a game, determine the status of the Tic-Tac-Toe-Tomek game going on. The statuses to choose from are:
 * <p/>
 * "X won" (the game is over, and X won)
 * "O won" (the game is over, and O won)
 * "Draw" (the game is over, and it ended in a draw)
 * "Game has not completed" (the game is not over yet)
 * If there are empty cells, and the game is not over, you should output "Game has not completed", even if the outcome
 * of the game is inevitable.
 * Input
 * <p/>
 * The first line of the input gives the number of core cases, T. T core cases follow. Each core case consists of 4
 * lines with 4 characters each, with each character being 'X', 'O', '.' or 'T' (quotes for clarity only). Each core case is followed by an empty line.
 * <p/>
 * Output
 * <p/>
 * For each core case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is
 * one of the statuses given above. Make sure to get the statuses exactly right. When you run your code on the sample input, it should create the sample output exactly, including the "Case #1: ", the capital letter "O" rather than the number "0", and so on.
 * <p/>
 * Limits
 * <p/>
 * The game board provided will represent a valid state that was reached through play of the game
 * Tic-Tac-Toe-Tomek as described above.
 */
public class TicTacToe {


    public static final String GAME_HAS_NOT_COMPLETED = "Game has not completed";
    public static final String DRAW = "Draw";
    public static final String X_WON = "X won";
    public static final String O_WON = "O won";
    public static final int NUMBER_TO_WIN = 4;


    public static void main (String [] argsv) throws Exception{

        String fileNameIn = "com/jonvallet/codejam/A-small-practice.in";
        BufferedReader bufferedReader = getBufferedReader(fileNameIn);

        String fileNameOut = "A-small-practice.out";
        BufferedWriter writer = getBufferedWriter(fileNameOut);

        generateOutput(bufferedReader, writer);

        bufferedReader.close();
        writer.close();


        fileNameIn = "com/jonvallet/codejam/A-large-practice.in";
        bufferedReader = getBufferedReader(fileNameIn);

        fileNameOut = "A-large-practice.out";
        writer = getBufferedWriter(fileNameOut);

        generateOutput(bufferedReader, writer);

        bufferedReader.close();
        writer.close();

    }

    private static void generateOutput(BufferedReader bufferedReader, BufferedWriter writer) throws IOException {
        String line =  bufferedReader.readLine();

        int cases = Integer.valueOf(line);

        TicTacToe ticTacToe = new TicTacToe();

        for (int i = 0; i < cases; i++){
            String [] board = new String [4];
            board[0] = bufferedReader.readLine();
            board[1] = bufferedReader.readLine();
            board[2] = bufferedReader.readLine();
            board[3] = bufferedReader.readLine();
            bufferedReader.readLine();
            String state = ticTacToe.getGameState(board);
            int caseNumber = i+1;
            writer.write("Case #"+caseNumber+": "+state);
            writer.newLine();

        }
    }

    private static BufferedWriter getBufferedWriter(String fileNameOut) throws IOException {
        return new BufferedWriter(new FileWriter(fileNameOut));
    }

    private static BufferedReader getBufferedReader(String fileName) {
        InputStreamReader inputStreamReader = new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
        return new BufferedReader(inputStreamReader);
    }


    @Test
    public void testGameIsNotFinish(){

        String [] board = { "....",
                            "....",
                            "....",
                            "...."};

        String expected = GAME_HAS_NOT_COMPLETED;
        String actual = getGameState(board);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGameIsDraw(){

        String [] board = { "TOXX",
                            "OXOX",
                            "XOXO",
                            "OXOO"};

        String expected = DRAW;
        String actual = getGameState(board);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGameIsWonByXHorizontal(){

        String [] board = { "TXXX",
                            "OXOX",
                            "XOXO",
                            "OXOX"};

        String expected = X_WON;
        String actual = getGameState(board);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGameIsWonByOHorizontal(){

        String [] board = { "TOOO",
                            "OXOX",
                            "XOXO",
                            "OXO."};

        String expected = O_WON;
        String actual = getGameState(board);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGameIsWonByXVertical(){

        String [] board = { "TXXO",
                            "XXOX",
                            "XOXO",
                            "XXOX"};

        String expected = X_WON;
        String actual = getGameState(board);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGameIsWonByXCross(){

        String [] board = { "TXO.",
                            "XX.X",
                            "OXX.",
                            "X.OX"};

        String expected = X_WON;
        String actual = getGameState(board);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGameIsWonByXCrossInverse(){

        String [] board = { "TXOX",
                            "XXXO",
                            "OXX.",
                            "X.O."};

        String expected = X_WON;
        String actual = getGameState(board);

        Assert.assertEquals(expected, actual);
    }


    private String getGameState(String[] board) {


        if (gameIsXwon(board)){
            return X_WON;
        }

        if (gameIsOwon(board)){
            return O_WON;
        }

        if (gameIsDraw(board)){
            return DRAW;
        }

        return GAME_HAS_NOT_COMPLETED;
    }

    private boolean gameIsXwon(String[] board) {
        return gameIsWon(board, 'X');
    }

    private boolean gameIsOwon(String[] board) {
        return gameIsWon(board, 'O');
    }

    private boolean gameIsWon(String[] board, char player) {

        int horizontal = 0;
        int vertical = 0;
        int cross = 0;
        int inverseCross = 0;

        for (int i = 0; i < 4; i++){
            horizontal = 0;
            vertical = 0;

            for (int j = 0; j < 4; j++){

                char colChar = board[i].charAt(j);
                char rowChar = board[j].charAt(i);
                if (colChar == player || colChar == 'T'){
                    horizontal++;
                }
                if (rowChar == player || rowChar == 'T'){
                    vertical++;
                }

                if (i == j){
                    char crossChar = board[i].charAt(j);
                    if (crossChar == player || crossChar == 'T'){
                        cross++;
                    }
                }

                if (i + j == 3){
                    char crossChar = board[j].charAt(i);
                    if (crossChar == player || crossChar == 'T'){
                        inverseCross++;
                    }
                }

                if (horizontal == NUMBER_TO_WIN || vertical == NUMBER_TO_WIN || cross == NUMBER_TO_WIN || inverseCross == NUMBER_TO_WIN){
                    return true;
                }
            }

        }

        return false;
    }

    private boolean gameIsDraw(String[] board) {

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (board[i].charAt(j) == '.'){
                    return false;
                }
            }
        }

        return true;

    }


}
