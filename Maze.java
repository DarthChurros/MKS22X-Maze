import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
  public static void main(String[] args) {
    Scanner in;
    int rows = 0;
    int cols = 0;
    try {
      in = new Scanner(new File("Maze1.txt"));
      while (in.hasNextLine()) {
        String line = in.nextLine();
        System.out.println(line);
        rows++;
        cols = line.length() - 1;
      }
    } catch (FileNotFoundException e) {
      System.out.println("file not found!");
      System.exit(1);
    }
    char[][] board = new char[rows][cols];
    try {
      in = new Scanner(new File("Maze1.txt"));
      int row = 0;
      while (in.hasNextLine()) {
        String line = in.nextLine();
        for (int i = 0; i < cols; i++) {
          board[row][i] = line.charAt(i);
        }
        row++;
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
      System.exit(1);
    }

    System.out.println("PRINTING FROM ARRAY\n\n");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j]);
      }
      System.out.print('\n');
    }
  }
}
