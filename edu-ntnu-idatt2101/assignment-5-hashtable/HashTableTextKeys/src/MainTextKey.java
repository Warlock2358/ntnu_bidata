import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class MainTextKey {

  private static final URL fileUrl;

  static {
    try {
      fileUrl = new URL("https://www.idi.ntnu.no/emner/idatt2101/hash/navn.txt");
    }
    catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  private static String fileReader() {
    StringBuilder text = new StringBuilder();
    try {
      Scanner myReader = new Scanner(fileUrl.openStream());
      while (myReader.hasNextLine()) {
        text.append(myReader.nextLine()).append("\n");
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return text.toString();
  }

  public static void main(String[] args) {
    HashListTextKey hashList = new HashListTextKey();
    String[] names = fileReader().split("\n");
    int filledCapacity = 0;
    for (String name : names) {
      hashList.addElement(name);
      filledCapacity++;
    }

    System.out.println(" ");

    System.out.println("Collision count: " + hashList.collisionCount);
    System.out.println("Collision rate: " + (double) hashList.collisionCount / filledCapacity);

    System.out.println(" ");

    System.out.println("Filled capacity: " + filledCapacity);
    System.out.println("Total capacity: " + hashList.capacity);
    System.out.println("Load factor: " + (double) filledCapacity / hashList.capacity);

    System.out.println(" ");

    System.out.println("Check if student exists: " + hashList.checkIfStudentsExists("Sverre Frogner Haugen"));
    System.out.println("Check if student exists: " + hashList.checkIfStudentsExists("Olav Sie Rotvær"));
    System.out.println("Check if student exists: " + hashList.checkIfStudentsExists("Helle Vosmik Rosenlind"));
    System.out.println("Check if student exists: " + hashList.checkIfStudentsExists("Knut Hamsun"));
    System.out.println("Check if student exists: " + hashList.checkIfStudentsExists("Isak Kallestad Mandal"));
  }
}
