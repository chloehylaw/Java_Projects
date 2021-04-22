// -----------------------------------------------------
// Part: 2D
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------
package Show;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * contains the main method
 */
public class ProcessWishlist {

    /**
     * allows to counter the amount of lines in a file
     * @param file string
     * @return counter
     * @throws FileNotFoundException if file doesn't exist
     */
    public static int showCounter (String file) throws FileNotFoundException{
        int counter = 0;
        Scanner sc = new Scanner(new FileInputStream(file));
        while(sc.hasNextLine()){
            counter++;
            sc.nextLine();
        }
        sc.close();
        return counter;
    }

    /**
     * showlist
     */
    public static ShowList sl1 = new ShowList();

    /**
     * main method
     * @param args arguments
     */
    public static void main(String[] args) {

        System.out.println("\n\n================ WELCOME TO MY PROGRAM =================\n");
        System.out.println("======================== PART 1 ========================\n");

        System.out.println("Opening TVGuide.txt for reading.");

        //open the TVGuide.txt file and input all information
        FileInputStream tvGuideIn = null;
        int showLines = 0;
        try{
            tvGuideIn = new FileInputStream("TVGuide.txt");
            showLines = showCounter("TVGuide.txt");
        }catch (FileNotFoundException e){
            System.out.println("We cannot find this file.\nProgram will terminate.");
            System.exit(0);
        }

        Scanner sc = new Scanner(tvGuideIn);
        String[] splitLine = null;
        String[] showInfo = new String[4];
        int lineCounter = 0;

        while(sc.hasNext()){
            String line = sc.nextLine().trim();
            splitLine = line.split("\\s+");

            switch (lineCounter) {
                case 0 -> {
                    showInfo[0] = splitLine[0];
                    showInfo[1] = splitLine[1];
                    lineCounter++;
                }
                case 1 -> {
                    showInfo[2] = splitLine[1];
                    lineCounter++;
                }
                case 2 -> {
                    showInfo[3] = splitLine[1];
                    lineCounter++;
                    TVShow tvShow = new TVShow(showInfo[0], showInfo[1], Double.parseDouble(showInfo[2]), Double.parseDouble(showInfo[3]));
                    if (!sl1.contains(showInfo[0])) {
                        sl1.addToStart(tvShow);
                    }else{
                        System.out.println("Duplicate with show ID: " + showInfo[0] + " will not be added.");
                    }
                }
                case 3 -> lineCounter = 0;
            }
        }

        System.out.println("Done reading TVGuide.txt. (10 iterations)");
        System.out.println("There are no duplicated shows with the same ID.");

        System.out.println("\n======================== PART 2 ========================\n");
        System.out.println("Please enter the name of the interest file you wish to process.");
        Scanner kb = new Scanner(System.in);
        String requestFile = kb.next();

        Scanner scanFile = null;

        ArrayList<String> watchList = new ArrayList<>();
        ArrayList<String> wishList = new ArrayList<>();

        try{
            scanFile = new Scanner(new FileInputStream(requestFile));

            String line = scanFile.nextLine().trim();
            String line2 = "";

            while(line.equals("Watching")){
                while(scanFile.hasNext()){
                    line2 = scanFile.nextLine().trim();
                    if(line2.equals("Wishlist")){
                        line = "Wishlist";
                        break;
                    }
                    watchList.add(line2);
                }
            }

            while(line.equals("Wishlist")){
                while(scanFile.hasNext()){
                    line2 = scanFile.nextLine().trim();
                    wishList.add(line2);
                }
                line = "";
            }

            System.out.println("Done reading Interest.txt.");
            System.out.println("Processing whether you can watch the shows in your wishlist.");

            for (String s : watchList) {
                for (int j = 0; j < wishList.size(); j++) {
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.print("\nFind watching show. ");
                    TVShow show1 = sl1.findShow(s);
                    System.out.println("TVShow Information");
                    System.out.println(show1);
                    System.out.print("Find wishlist show. ");
                    TVShow show2 = sl1.findShow(wishList.get(j));
                    System.out.println("TVShow Information");
                    System.out.println(show2);

                    if (show1.isOnSameTime((show2)).equalsIgnoreCase("Different time.")) {
                        System.out.println("User can watch show " + watchList.get(j) + ".");
                    } else {
                        System.out.println("User can't watch show " + wishList.get(j) + " because of an overlap.");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("""
                    Could not open file for reading.
                    Please check if file exists!
                    Program will terminate now.""");
            System.exit(0);
        }

        System.out.println("\n======================== PART 3 ========================\n");
        System.out.println("To find a show's information, please enter a few show IDs. " +
                "\nType \"end\" when you are done.");
        Scanner in = new Scanner(System.in);
        String ID = in.nextLine();
        ArrayList<String> showIDList = new ArrayList<>();

        //Adding user entered IDs into arraylist
        while(!ID.equalsIgnoreCase("end")){
            showIDList.add(ID);
            ID = in.nextLine();
        }
        System.out.println();
        //Checking to see if ID is in ShowList
        for (String s : showIDList) {
            System.out.print("Find show. ");
            TVShow temp = sl1.findShow(s);
            System.out.println("TVShow Information");
            if (temp == null)
                System.out.println("No show was found");
            else
                System.out.println(temp);
        }

        System.out.println("\n======================== PART 4 ========================\n");
        System.out.println("Time to test all the methods.");
        System.out.println("\n+++++++++++++++++++++ TVShow Class +++++++++++++++++++++");
        System.out.println("\n~~~~~~~~~~~~~~~~~~ Default constructor ~~~~~~~~~~~~~~~~~~");
        TVShow test = new TVShow("ID","Name",10.30,11.30);
        TVShow test2 = new TVShow("ID","Name",10.00,12.00);
        TVShow test3 = new TVShow("ID","Name",10.00,12.00);
        System.out.println("\nTVShow Information: test" + test
                + "\nTVShow Information: test2\n" + test2
                + "\nTVShow Information: test3\n" + test3);

        System.out.println("~~~~~~~~~~~~~~~~~~~~ Copy Constructor ~~~~~~~~~~~~~~~~~~~");
        TVShow copy = new TVShow(test, "ID1");
        System.out.println("\nCopy test and name it TD1\nTVShow Information\n" + copy);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ Clone Method ~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nTVShow Information\n" + test.clone(kb));

        System.out.println("~~~~~~~~~~~~~~~~~~~ Same Time Method ~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nIs test on the same time as test2?: " + test.isOnSameTime(test2));
        System.out.println("Is test on the same time as copy?: " + test.isOnSameTime(copy));

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~ Equals Method ~~~~~~~~~~~~~~~~~~~~ ");
        System.out.println("\nIs test equals to test2?: " + test.equals(test2));
        System.out.println("Is test2 equals to test3?: " + test.equals(test3));

        System.out.println("\n~~~~~~~~~~~~~~~~~~~ isOnSameTimeMethod ~~~~~~~~~~~~~~~~~~ ");
        System.out.println("\nIs Wonders_Of_Mexico same time as American_Housewives?");
        TVShow mexico = sl1.findShow("PBS21");
        TVShow american = sl1.findShow("ABC2130");
        System.out.println(mexico.isOnSameTime(american));
        System.out.println("\nDoes Big_Brother overlap with Modern_Family?");
        TVShow brother = sl1.findShow("CBS20");
        TVShow family = sl1.findShow("ABC21");
        System.out.println(brother.isOnSameTime(family));
        System.out.println("\nIs World_Of_Dance different time than Shark_Tank?");
        TVShow dance = sl1.findShow("NBC21");
        TVShow shark = sl1.findShow("ABC22");
        System.out.println(dance.isOnSameTime(shark));

        System.out.println("\n+++++++++++++++++++++ ShowList Class +++++++++++++++++++++");
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Copy Constructor ~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nCopy contents from Showlist 1 into Showlist 2.");
        System.out.println("Display contents of ShowList 2");
        ShowList sl2 = new ShowList(sl1);
        System.out.println(sl2);

        System.out.println("~~~~~~~~~~~~~~~~~~~~ Insert at Index ~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nInsert test at Index 1 of ShowList 1");
        sl1.insertAtIndex(test,1);
        /*System.out.println("Display contents of ShowList 1");
        System.out.println(sl1);*/
        System.out.println("The size of the list is " + sl1.getSize() + ".\n");

        System.out.println("~~~~~~~~~~~~~~~~~~~~ Delete at Index ~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nDelete at Index 3");
        sl1.deleteFromIndex(3);
        /*System.out.println("Display contents of ShowList 1");
        System.out.println(sl1);*/
        System.out.println("The size of the list is " + sl1.getSize() + ".\n");

        System.out.println("~~~~~~~~~~~~~~~~~~~~ Delete at Head ~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nDelete Head");
        sl1.deleteFromStart();
        /*System.out.println("Display contents of ShowList 1");
        System.out.println(sl1);*/
        System.out.println("The size of the list is " + sl1.getSize() + ".\n");

        System.out.println("~~~~~~~~~~~~~~~~~~~~ Replace at Index ~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nReplace at Index 6");
        sl1.replaceAtIndex(test,6);
       /* System.out.println("Display contents of ShowList 1");
        System.out.println(sl1);*/
        System.out.println("The size of the list is " + sl1.getSize() + ".\n");

        System.out.println("================== PROGRAM TERMINATED ===================");

    }
}
