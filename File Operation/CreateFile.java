import java.io.File;       // For creating the file
import java.io.FileWriter; // For writing to the file
import java.io.IOException;

public class CreateFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename2.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }

      // Write to the file
      FileWriter myWriter = new FileWriter("filename1.txt");
      myWriter.write("John, Doe,Jane Smith, Alice Johnson,Bob Brown\n");
      myWriter.write("You can add more lines like this.\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
