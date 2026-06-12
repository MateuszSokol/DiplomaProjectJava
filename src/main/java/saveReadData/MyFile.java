package saveReadData;

import java.io.*;
import java.util.Scanner;

public class MyFile
{
    private String filePath;

    public void readDataFromFile(String filePath)
    {
        File myObj = new File(filePath);

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void saveDataToFile(){
        String dataToWrite = "Hello";
        File myObj = new File(filePath);

        try (FileWriter writer = new FileWriter(myObj)) {
            writer.write(dataToWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
