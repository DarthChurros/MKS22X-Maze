import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

  private char[][] maze;
  private boolean animate;

  public Maze(String filename) throws FileNotFoundException{
    int rows = 0;
    int cols = 0;
    int countE = 0;
    int countS = 0;
    Scanner in = new Scanner(new File(filename));
    while (in.hasNextLine()) {
      String line = in.nextLine();
      rows++;
      cols = line.length();
      for (int i = 0; i < line.length(); i++) {
        if (line.charAt(i) == 'E') countE++;
        if (line.charAt(i) == 'S') countS++;
      }
      if (countE > 1 || countS > 1) throw new IllegalStateException ("only one start or end allowed");
    }
    maze = new char[rows][cols];
    in = new Scanner(new File(filename));
    int row = 0;
    while (in.hasNextLine()) {
      String line = in.nextLine();
      for (int i = 0; i < cols; i++) {
        maze[row][i] = line.charAt(i);
      }
      row++;
    }

    animate = false;
  }

  private void wait(int millis) {
    try {
       Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b) {
    animate = b;
  }

  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }

  public String toString() {
    String ans = "";
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        ans += maze[i][j];
      }
      ans += '\n';
    }
    return ans;
  }

  public static void main(String[] args) {
    Maze test;
    try {
      test = new Maze("Maze1.txt");
      System.out.println(test);
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
      System.exit(1);
    }
  }
}
