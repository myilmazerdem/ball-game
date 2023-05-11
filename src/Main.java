import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static String[] readFile(String path) {
        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++] = line;
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    static int score = 0;//defined an int named score as 0. It will be increase or decrease related to moves
    public static void left(ArrayList<ArrayList<String>> matrix, int row, int col) {//When this method is called, our ball will go left.
        int numCols = matrix.get(0).size();//determines the number of columns

        if (col == 0) {//situation that the ball is leftmost
            if (matrix.get(row).get(numCols-1).equals("R")) {//which colour is there the rotation that the user selected. This if block is used on all of rotation methods
                score+=10;
                matrix.get(row).set(numCols-1,"X");
                String temp = matrix.get(row).get(numCols-1);
                matrix.get(row).set(numCols-1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(numCols-1).equals("H")) {
                matrix.get(row).set(col," ");//it means our ball is disappeared. This will be used so as to print "Game Over"
            }
            if (matrix.get(row).get(numCols-1).equals("Y")) {
                score+=5;
                matrix.get(row).set(numCols-1,"X");
                String temp = matrix.get(row).get(numCols-1);
                matrix.get(row).set(numCols-1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(numCols-1).equals("B")) {
                score-=5;
                matrix.get(row).set(numCols-1,"X");
                String temp = matrix.get(row).get(numCols-1);
                matrix.get(row).set(numCols-1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(numCols-1).equals("W")) {//wall reverses the method
                right(matrix,row,col);
                }
            //the situations that do not cause the score
            if (    matrix.get(row).get(numCols-1).equals("O") || matrix.get(row).get(numCols-1).equals("D") ||
                    matrix.get(row).get(numCols-1).equals("X") || matrix.get(row).get(numCols-1).equals("L") ||
                    matrix.get(row).get(numCols-1).equals("F") || matrix.get(row).get(numCols-1).equals("N") ||
                    matrix.get(row).get(numCols-1).equals("G") || matrix.get(row).get(numCols-1).equals("P")) {
                String temp = matrix.get(row).get(numCols-1);
            matrix.get(row).set(numCols-1, matrix.get(row).get(col));
            matrix.get(row).set(col, temp);
            }
        }
        else {//there is no problem with going left
            if (matrix.get(row).get(col-1).equals("R")) {
                score+=10;
                matrix.get(row).set(col-1,"X");
                String temp = matrix.get(row).get(col-1);
                matrix.get(row).set(col-1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(col-1).equals("H")) {
                matrix.get(row).set(col," ");
            }
            if (matrix.get(row).get(col-1).equals("Y")) {
                score+=5;
                matrix.get(row).set(col-1,"X");
                String temp = matrix.get(row).get(col-1);
                matrix.get(row).set(col-1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(col-1).equals("B")) {
                score-=5;
                matrix.get(row).set(col-1,"X");
                String temp = matrix.get(row).get(col-1);
                matrix.get(row).set(col-1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(col-1).equals("W")) {
                right(matrix,row,col);
            }
            if (    matrix.get(row).get(col-1).equals("O") || matrix.get(row).get(col-1).equals("D") ||
                    matrix.get(row).get(col-1).equals("X") || matrix.get(row).get(col-1).equals("L") ||
                    matrix.get(row).get(col-1).equals("F") || matrix.get(row).get(col-1).equals("N") ||
                    matrix.get(row).get(col-1).equals("G") || matrix.get(row).get(col-1).equals("P")) {
                String temp = matrix.get(row).get(col-1);
            matrix.get(row).set(col-1, matrix.get(row).get(col));
            matrix.get(row).set(col, temp);
            }
        }
    }
    public static void right(ArrayList<ArrayList<String>> matrix, int row, int col) {//the integrated version of the method "left", like "up" and "down" methods.
        int numCols = matrix.get(0).size();

        if (col == numCols-1) {
            if (matrix.get(row).get(0).equals("R")) {
                score+=10;
                matrix.get(row).set(0,"X");
                String temp = matrix.get(row).get(0);
                matrix.get(row).set(0, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(0).equals("H")) {
                matrix.get(row).set(col," ");
            }
            if (matrix.get(row).get(0).equals("Y")) {
                score+=5;
                matrix.get(row).set(0,"X");
                String temp = matrix.get(row).get(0);
                matrix.get(row).set(0, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(0).equals("B")) {
                score-=5;
                matrix.get(row).set(0,"X");
                String temp = matrix.get(row).get(0);
                matrix.get(row).set(0, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(0).equals("W")) {
                left(matrix,row,col);
            }
            if (    matrix.get(row).get(0).equals("O") || matrix.get(row).get(0).equals("D") ||
                    matrix.get(row).get(0).equals("X") || matrix.get(row).get(0).equals("L") ||
                    matrix.get(row).get(0).equals("F") || matrix.get(row).get(0).equals("N") ||
                    matrix.get(row).get(0).equals("G") || matrix.get(row).get(0).equals("P")) {
                String temp = matrix.get(row).get(0);
            matrix.get(row).set(0, matrix.get(row).get(col));
            matrix.get(row).set(col, temp);
            }
        }
        else {
            if (matrix.get(row).get(col+1).equals("R")) {
                score+=10;
                matrix.get(row).set(col+1,"X");
                String temp = matrix.get(row).get(col+1);
                matrix.get(row).set(col+1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(col+1).equals("H")) {
                matrix.get(row).set(col," ");
            }
            if (matrix.get(row).get(col+1).equals("Y")) {
                score+=5;
                matrix.get(row).set(col+1,"X");
                String temp = matrix.get(row).get(col+1);
                matrix.get(row).set(col+1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row).get(col+1).equals("B")) {
                score-=5;
                String temp = matrix.get(row).get(col+1);
                matrix.get(row).set(col+1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
                matrix.get(row).set(col,"X");
            }
            if (matrix.get(row).get(col+1).equals("W")) {
                left(matrix,row,col);
            }
            if (    matrix.get(row).get(col+1).equals("O") || matrix.get(row).get(col+1).equals("D") ||
                    matrix.get(row).get(col+1).equals("X") || matrix.get(row).get(col+1).equals("L") ||
                    matrix.get(row).get(col+1).equals("F") || matrix.get(row).get(col+1).equals("N") ||
                    matrix.get(row).get(col+1).equals("G") || matrix.get(row).get(col+1).equals("P")) {
                String temp = matrix.get(row).get(col+1);
                matrix.get(row).set(col+1, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
        }
    }
    public static void up(ArrayList<ArrayList<String>> matrix, int row, int col){
        int numRows = matrix.size();

        if (row == 0) {
            if (matrix.get(numRows-1).get(col).equals("R")) {
                score+=10;
                matrix.get(numRows-1).set(col,"X");
                String temp = matrix.get(numRows-1).get(col);
                matrix.get(numRows-1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(numRows-1).get(col).equals("H")) {
                matrix.get(row).set(col," ");
            }
            if (matrix.get(numRows-1).get(col).equals("Y")) {
                score+=5;
                matrix.get(numRows-1).set(col,"X");
                String temp = matrix.get(numRows-1).get(col);
                matrix.get(numRows-1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(numRows-1).get(col).equals("B")) {
                score-=5;
                matrix.get(numRows-1).set(col,"X");
                String temp = matrix.get(numRows-1).get(col);
                matrix.get(numRows-1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(numRows-1).get(col).equals("W")) {
                down(matrix,row,col);
            }
            if (    matrix.get(numRows-1).get(col).equals("O") || matrix.get(numRows-1).get(col).equals("D") ||
                    matrix.get(numRows-1).get(col).equals("X") || matrix.get(numRows-1).get(col).equals("L") ||
                    matrix.get(numRows-1).get(col).equals("F") || matrix.get(numRows-1).get(col).equals("N") ||
                    matrix.get(numRows-1).get(col).equals("G") || matrix.get(numRows-1).get(col).equals("P")) {
                String temp = matrix.get(numRows-1).get(col);
                matrix.get(numRows-1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
        } else {
            if (matrix.get(row-1).get(col).equals("R")) {
                score+=10;
                matrix.get(row-1).set(col,"X");
                String temp = matrix.get(row-1).get(col);
                matrix.get(row-1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row-1).get(col).equals("H")) {
                matrix.get(row).set(col," ");
            }

            if (matrix.get(row-1).get(col).equals("Y")) {
                score+=5;
                matrix.get(row-1).set(col,"X");
                String temp = matrix.get(row-1).get(col);
                matrix.get(row-1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row-1).get(col).equals("B")) {
                score-=5;
                matrix.get(row-1).set(col,"X");
                String temp = matrix.get(row-1).get(col);
                matrix.get(row-1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row-1).get(col).equals("W")) {
                down(matrix,row,col);
            }
            if (    matrix.get(row-1).get(col).equals("O") || matrix.get(row-1).get(col).equals("D") ||
                    matrix.get(row-1).get(col).equals("X") || matrix.get(row-1).get(col).equals("L") ||
                    matrix.get(row-1).get(col).equals("F") || matrix.get(row-1).get(col).equals("N") ||
                    matrix.get(row-1).get(col).equals("G") || matrix.get(row-1).get(col).equals("P")) {
                String temp = matrix.get(row-1).get(col);
                matrix.get(row-1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
        }
    }
    public static void down(ArrayList<ArrayList<String>> matrix, int row, int col) {
        int numRows = matrix.size();

        if (row == numRows-1) {
            if (matrix.get(0).get(col).equals("R")) {
                score+=10;
                matrix.get(0).set(col,"X");
                String temp = matrix.get(0).get(col);
                matrix.get(0).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(0).get(col).equals("H")) {
                matrix.get(row).set(col," ");
            }
            if (matrix.get(0).get(col).equals("Y")) {
                score+=5;
                matrix.get(0).set(col,"X");
                String temp = matrix.get(0).get(col);
                matrix.get(0).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(0).get(col).equals("B")) {
                score-=5;
                matrix.get(0).set(col,"X");
                String temp = matrix.get(0).get(col);
                matrix.get(0).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }

            if (matrix.get(numRows-1).get(col).equals("W")) {
                up(matrix,row,col);
            }
            if (    matrix.get(0).get(col).equals("O") || matrix.get(0).get(col).equals("D") ||
                    matrix.get(0).get(col).equals("X") || matrix.get(0).get(col).equals("L") ||
                    matrix.get(0).get(col).equals("F") || matrix.get(0).get(col).equals("N") ||
                    matrix.get(0).get(col).equals("G") || matrix.get(0).get(col).equals("P")) {
                String temp = matrix.get(0).get(col);
                matrix.get(0).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
        }
        else {
            if (matrix.get(row+1).get(col).equals("R")) {
                score+=10;
                matrix.get(row+1).set(col,"X");
                String temp = matrix.get(row+1).get(col);
                matrix.get(row+1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
                System.out.println(matrix);
            }

            if (matrix.get(row+1).get(col).equals("H")) {
                matrix.get(row).set(col," ");
            }
            if (matrix.get(row+1).get(col).equals("Y")) {
                score+=5;
                matrix.get(row+1).set(col,"X");
                String temp = matrix.get(row+1).get(col);
                matrix.get(row+1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row+1).get(col).equals("B")) {
                score-=5;
                matrix.get(row+1).set(col,"X");
                String temp = matrix.get(row+1).get(col);
                matrix.get(row+1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
            if (matrix.get(row+1).get(col).equals("W")) {
                up(matrix,row,col);
            }
            if (            matrix.get(row+1).get(col).equals("O") || matrix.get(row+1).get(col).equals("D") ||
                            matrix.get(row+1).get(col).equals("X") || matrix.get(row+1).get(col).equals("L") ||
                            matrix.get(row+1).get(col).equals("F") || matrix.get(row+1).get(col).equals("N") ||
                            matrix.get(row+1).get(col).equals("G") || matrix.get(row+1).get(col).equals("P")) {
                String temp = matrix.get(row+1).get(col);
                matrix.get(row+1).set(col, matrix.get(row).get(col));
                matrix.get(row).set(col, temp);
            }
        }
    }
    public static ArrayList<ArrayList<String>> inputFiles(String[] lines){
        ArrayList<ArrayList<String>> board = new ArrayList<>();//an empty ArrayList is created
        for (String line: lines){
            String[] colours = line.split(" ");
            ArrayList<String> lst = new ArrayList<>(Arrays.asList(colours));
            board.add(lst);//the content of the input file is splitted and added to the ArrayList so as to create a 2d matrix
        }
        return board;
    }
    static ArrayList<ArrayList<String>> board = new ArrayList<>();
    public static void main (String[] args) {
        String[] firstLines = readFile(args[0]);//first argument
        assert firstLines != null;
        ArrayList<ArrayList<String>> firstBoard = inputFiles(firstLines);//the unrevised version of the board

        board = inputFiles(firstLines);

        String[] directions = readFile(args[1]);//second argument
        ArrayList<String> moves = new ArrayList<>(Arrays.asList(directions[0].split(" ")));

        int x = -1;
        int y = -1;

        for (int i = 0; i < board.size(); i++) {//finding our ball's coordinates
            for (int j = 0; j < board.get(0).size(); j++) {
                if (board.get(i).get(j).equals("*")) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        for(String move : moves) {//Game is getting played. The methods are getting called related the moves.
            if (board.get(x).get(y).equals(" ")) {//if ball is disappeard, game over.
                break;
            }
            if (move.equals("L")) {
                left(board,x,y);
            }
            if (move.equals("R")) {
                right(board,x,y);
            }
            if (move.equals("U")) {
                up(board,x,y);
            }
            if (move.equals("D")) {
                down(board,x,y);
            }
            for (int i = 0; i < board.size(); i++) {//the coordinates of the ball should be determined after the move.
                for (int j = 0; j < board.get(0).size(); j++) {
                    if (board.get(i).get(j).equals("*")) {
                        x = i;
                        y = j;
                        break;
                    }
                    if (board.get(i).get(j).equals(" ")) {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
        }
        try {
            PrintStream output = new PrintStream(new File("output.txt"));//setting output

            System.setOut(output);
            System.out.println("Game board:");
            for (ArrayList<String> i : firstBoard){
                String result = String.join(" ",i);
                System.out.println(result);
            }

            System.out.println("\nYour movement is:");
            String joinedMoves = String.join(" ",moves);
            System.out.println(joinedMoves);
            System.out.println("\nYour output is:");
            for (ArrayList<String> i : board){
                String result = String.join(" ",i);
                System.out.println(result);
            }
            for (ArrayList<String> strings : board) {
                for (int j = 0; j < board.get(0).size(); j++) {
                    if (strings.get(j).equals(" ")) {
                        System.out.print("\nGame Over!");
                    }
                }
            }
            System.out.println("\nScore: "+ score);

            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
}
}