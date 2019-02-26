import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
  public static void main(String[] args) {
    Scanner in;
    try {
      in = new Scanner(new File("Maze1.txt"));
      while (in.hasNextLine()) {
        System.out.println(in.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("file not found!");
      System.exit(1);
    }

  }
}
