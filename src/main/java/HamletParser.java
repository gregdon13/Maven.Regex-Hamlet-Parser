import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private FileWriter myWriter;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String newLine = line.replaceAll("(?i)\\bHamlet", "Leon").replaceAll("(?i)\\bHoratio\\b", "Tariq");
                result.append(newLine).append("\n");
            }
            myWriter = new FileWriter("replacedText.txt");
            myWriter.write(result.toString());
            myWriter.close();

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void setHamletData() {
        loadFile();
    }

}
