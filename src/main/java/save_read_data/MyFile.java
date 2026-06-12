package save_read_data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class MyFile
{
    private static final Logger logger = LogManager.getLogger("save_read_data.MyFile");

    public void readDataFromFile(String filePath)
    {
        File myObj = new File(filePath);

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                logger.info(data);
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found in path: {}",filePath);

        }
    }
    public void saveDataToFile(String filePath){
        String dataToWrite = "Hello";
        File myObj = new File(filePath);

        try (FileWriter writer = new FileWriter(myObj)) {
            writer.write(dataToWrite);
        } catch (IOException e) {
            logger.error("error during opening file: {}",filePath);
            throw new RuntimeException(e);
        }
    }
}
