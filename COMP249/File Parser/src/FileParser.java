import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * write a program that will accept any text file, as input, and creates a file parser
 * that processes all the words found in that input file based on the below mentioned rules
 */
public class FileParser {
    /**
     * main method
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in); //user input
        Scanner sc = null; //read file
        PrintWriter vowel = null; //write in vowel_verbiage
        PrintWriter obsessive = null; //write in obsessive_o
        PrintWriter distinct = null; //write in distinct_data

        System.out.println("\n\nWelcome to this program that analyzes and input file that you give us to create three new files." +
                "\n\t1. vowel_verbiage.txt that will contain all the words with more than 3 vowels." +
                "\n\t2. obsessive_o.txt that will contain all the words with a letter o" +
                "\n\t3. distinct_data.txt that will contain all the words once only.\n\n");
        System.out.println("Please enter the name of the file to open: ");
        String input = kb.next();

        //try to open file to read & creates files to write on
        try{
            sc= new Scanner(new FileInputStream(input));
            vowel = new PrintWriter(new FileOutputStream("vowel_verbiage.txt"));
            obsessive = new PrintWriter(new FileOutputStream("obsessive_o.txt"));
            distinct = new PrintWriter(new FileOutputStream("distinct_data.txt"));
        }catch(FileNotFoundException e){
            System.out.println("\nCould not open the file " + input + " for reading. " +
                    "\nPlease check if the file exists!" +
                    "\nProgram will terminate after closing any opened files.");
            System.exit(0);
        }

        //Create array list
        ArrayList<String> vowel_verbiage = new ArrayList<>();
        ArrayList<String> obsessive_o = new ArrayList<>();
        ArrayList<String> distinct_data = new ArrayList<>();

        int numVowel = 0;
        int numO = 0;
        int numDis = 0;

        while(sc.hasNext()){
            String nextWord = sc.next();
            nextWord = nextWord.replaceAll("[^a-zA-Z0-9]", "");

            //finds vowels

            /*if(!(vowel_verbiage.contains(nextWord)) && !(nextWord.equals(""))){
                if(3 <= count_Vowels(nextWord)){
                    numVowel++;
                    vowel_verbiage.add(nextWord);
                }
            }*/
            if(!(vowel_verbiage.contains(nextWord)) && !(nextWord.equals(""))) {
                int count = 0;
                for (int i = 0; i < nextWord.length(); i++) {
                    char ch = nextWord.charAt(i);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                        count++;
                    }
                }
                if (count > 3) {
                    numVowel++;
                    vowel_verbiage.add(nextWord);
                }
            }

            //finds obsessive_o
            if(!(obsessive_o.contains(nextWord)) && nextWord.contains("o") || nextWord.contains("O")){
                numO++;
                obsessive_o.add(nextWord);
            }

            //finds distinct
            if(!(distinct_data.contains(nextWord)) && !(nextWord.equals(""))){
                numDis++;
                distinct_data.add(nextWord);
            }
        }

        //write in vowel_verbiage
        vowel.write("Word count: " + numVowel + "\n");
        for (String currentV : vowel_verbiage) {
            vowel.write(currentV + "\n");
        }

        //write in obsessive_o
        obsessive.write("Word count: " + numO + "\n");
        for (String currentO : obsessive_o) {
            obsessive.write(currentO + "\n");
        }

        //write in distinct_data
        distinct.write("Word count: " + numDis + "\n");
        for (String currentD : distinct_data) {
            distinct.write(currentD + "\n");
        }

        kb.close();
        vowel.close();
        obsessive.close();
        distinct.close();

        System.out.println();
        System.out.println("There are " + numVowel + " number of words with more than 3 vowels.");
        System.out.println("There are " + numO + " number of words with the letter o.");
        System.out.println("There are " + numDis + " number of distinct words.");
        System.out.println("\nThe files have been created.\nThe program has terminated.");
    }

}

