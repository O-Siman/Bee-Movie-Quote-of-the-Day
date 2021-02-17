import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Vars
        File inputFile = new File("input.txt");
        ArrayList<String> dialogueArray = new ArrayList<>();

        //File not found exception
        try {
            //Scanner variable
            Scanner scanner = new Scanner(inputFile);

            //While there are more lines in the input file
            while (scanner.hasNextLine()) {
                //Set string currentLine to scanner's next line
                String currentLine = scanner.nextLine();

                //Define our regex pattern
                Pattern pattern = Pattern.compile("-\\s(.*+)", Pattern.CASE_INSENSITIVE);
                //Match our regex pattern
                Matcher matcher = pattern.matcher(currentLine);

                //If we have a match
                if (matcher.matches()) {
                    //Add the current line's regex group one (only the text) to dialogueArray
                    dialogueArray.add(matcher.group(1));
                }
            }

            //Close scanner
            scanner.close();
        //Catch exception
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        //Mix up the dialogueArray
        Collections.shuffle(dialogueArray);

        System.out.println("Bee movie quote of the day:");
        //And pick the first quote from the shuffled list. Then print it.
        System.out.println(dialogueArray.get(0));
    }
}
