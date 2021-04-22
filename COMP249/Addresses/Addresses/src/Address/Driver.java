// -----------------------------------------------------
// Part: 1 & 2
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------
package Address;

import International_Address.GeneralDeliveryAddress;
import International_Address.GeographicAddress;
import International_Address.PostOfficeBoxAddress;
import Local_Address.EmailAddress;
import Local_Address.TelecomAddress;
import Local_Address.WebPageAddress;

/**
 * The driver class to enable the program to run
 */
public class Driver {

    /**
     * Method to search the array of Addresses and display all the addresses that are/were obsolete in comparison to the passed date
     * @param name String[] array representing the name of the address
     * @param address Address[] array representing the address
     * @param year Integer representing the year of the given date
     * @param month Integer representing the month of the given date
     * @param day Integer representing the day of the given date
     */
    private static void traceObsoleteAddresses(String[] name, Address[] address, int year, int month, int day) {

        String[] validFrom = new String[16];
        String[] validTo = new String[16];
        for (int i = 0; i < address.length; i++) {
            validFrom[i] = address[i].getValidFrom();
            validTo[i] = address[i].getValidTo();
        }

        int[] fromYear = new int[16];
        int[] toYear = new int[16];
        int[] fromMonth = new int[16];
        int[] toMonth = new int[16];
        int[] fromDay = new int[16];
        int[] toDay = new int[16];
        for (int i = 0; i < address.length; i++) {
            try {
                fromYear[i] = Integer.parseInt(validFrom[i].split("-")[0]);
                toYear[i] = Integer.parseInt(validTo[i].split("-")[0]);
                fromMonth[i] = Integer.parseInt(validFrom[i].split("-")[1]);
                toMonth[i] = Integer.parseInt(validTo[i].split("-")[1]);
                fromDay[i] = Integer.parseInt(validFrom[i].split("-")[2]);
                toDay[i] = Integer.parseInt(validTo[i].split("-")[2]);
            } catch (NumberFormatException e){
                System.err.println("Unable to convert string to int");
            }
        }

        for(int i = 0; i < address.length; i++) {
            if (fromYear[i] <= year && year < toYear[i]) {
            }else if (fromYear[i] <= year && year == toYear[i]) {
                if (fromMonth[i] <= month && month < toMonth[i]) {
                }else if (fromMonth[i] <= month && month == toMonth[i]) {
                    if(fromDay[i] <= day && day <= toDay[i]) {
                    }
                }
            }else{
                System.out.println((i+1) + ". "+ name[i] + "\n" + address[i] +
                        "\nThis address is obsolete.\nIndex of " + i + "\n");
            }
        }
    }

    /**
     * Method that copy the Addresses
     * @param address Address[] array representing the address
     * @return copyAddress
     */
    private static Address[] copyAddresses(Address[] address){
        Address[] copyAddress = new Address[address.length];
        for(int i = 0; i < address.length; i++){
            copyAddress[i] = address[i];
        }
        return copyAddress;
    }

    /**
     * The main method to run the program
     * @param args arguments
     */
    public static void main (String[]args){

        System.out.println("\nThe purpose of this assignment is to practice class inheritance, composition and\n" +
                "other Object Oriented Programming concepts. The first part is to practice on concepts \n" +
                "such as creating constructors, using the proper access rights and method overriding.\n" +
                "The second part is to understand how to copy an object without the clone method.");

        System.out.println("\n------------------------------PART 1------------------------------\n");
        Address[] address = new Address[16];
        String[] name = new String[16];

        Address home = new Address(); //default constructor
        address[0] = home;
        name[0] = "HOME ADDRESS";
        Address apartment = new Address("2018-02-10", "2020-06-10"); //parametrized constructor
        address[1] = apartment;
        name[1] = "APARTMENT ADDRESS";

        WebPageAddress google = new WebPageAddress(); //default constructor
        address[2] = google;
        name[2] = "GOOGLE ADDRESS";
        WebPageAddress facebook = new WebPageAddress("2020-04-10", "2021-04-10", "www.facebook.com"); //parametrized constructor
        address[3] = facebook;
        name[3] = "FACEBOOK ADDRESS";
        WebPageAddress facebookCopy = new WebPageAddress(facebook); //copy constructor
        address[4] = facebookCopy;
        name[4] = "FACEBOOK COPY ADDRESS";

        EmailAddress mother = new EmailAddress(); //default constructor
        address[5] = mother;
        name[5] = "MOTHER ADDRESS";
        EmailAddress father = new EmailAddress("2019-07-10", "2020-06-10", "father",
                "@", "hotmail", ".", "com"); //parametrized constructor
        address[6] = father;
        name[6] = "FATHER ADDRESS";

        TelecomAddress costco = new TelecomAddress(); //default constructor
        address[7] = costco;
        name[7] = "COSTCO ADDRESS";
        TelecomAddress ikea = new TelecomAddress("2020-05-10", "2021-10-10", "+1",
                "(0)", 866, 8664532, 235, "phone"); //parametrized constructor
        address[8] = ikea;
        name[8] = "IKEA ADDRESS";
        TelecomAddress copyIkea = new TelecomAddress(ikea); //copy constructor
        address[9] = copyIkea;
        name[9] = "IKEA COPY ADDRESS";

        GeographicAddress library = new GeographicAddress(); //default constructor
        address[10] = library;
        name[10] = "LIBRARY ADDRESS";
        GeographicAddress.Locale geoLocale = new GeographicAddress.Locale("CA", 124, "Canada");
        GeographicAddress museum = new GeographicAddress("2020-01-10", "2021-12-10",
                "859 Sherbrook St W", "Montreal", "Quebec", "53A 0C3", geoLocale); //parametrized constructor
        address[11] = museum;
        name[11] = "MUSEUM ADDRESS";

        PostOfficeBoxAddress canadaPost = new PostOfficeBoxAddress(); //default constructor
        address[12] = canadaPost;
        name[12] = "CANADA POST ADDRESS";
        GeographicAddress.Locale postLocale = new GeographicAddress.Locale("CA", 124, "Canada");
        PostOfficeBoxAddress DHL = new PostOfficeBoxAddress("2020-02-20", "2021-09-20",
                "1055 Rue Lucien-L'Allier", "Montreal", "Quebec", "H3G 3C4",
                postLocale, 6574); //parametrized constructor
        address[13] = DHL;
        name[13] = "DHL ADDRESS";

        GeneralDeliveryAddress mail = new GeneralDeliveryAddress(); //default constructor
        address[14] = mail;
        name[14] = "MAIL ADDRESS";
        TelecomAddress telecomForDelivery = new TelecomAddress("2019-02-20", "2020-02-20", "+1",
                "(0)", 888, 7447123, 345, "phone");
        GeneralDeliveryAddress purolator = new GeneralDeliveryAddress("2020-03-20", "2021-09-20",
                "1243 Boul Robert-Bourassa", "Montreal", "Quebec", "H3B 3A8", telecomForDelivery); //parametrized constructor
        address[15] = purolator;
        name[15] = "PUROLATOR ADDRESS";

        System.out.println("-----------------------DISPLAY THE ADDRESSES----------------------\n");
        for(int i = 0; i < address.length; i++){
            System.out.println((i+1) + ". " +name[i] + "\n" +address[i] + "\n");
        }
        System.out.println("--------------------FIND THE OBSOLETE ADDRESSES-------------------\n");
        System.out.println("The obsolete date is 2020-01-15.\n");
        traceObsoleteAddresses(name, address, 2020, 1, 15);

        System.out.println("---------------------TESTING THE EQUALS METHOD--------------------\n");
        System.out.println("Is FACEBOOK ADDRESS equals to FACEBOOK COPY ADDRESS? (The answer should be true) \n→ "
                + facebook.equals(facebookCopy));
        System.out.println("Is IKEA ADDRESS equals to IKEA COPY ADDRESS? (The answer should be true) \n→ "
                + ikea.equals(copyIkea));
        System.out.println("They are true copies of each another, that is why they will always be equal.\n");
        System.out.println("Is MOTHER ADDRESS equals to FATHER ADDRESS? (The answer should be false) \n→ "
                + mother.equals(father));
        System.out.println("Is CANADA POST ADDRESS equals to DHL ADDRESS? (The answer should be false) \n→ "
                + canadaPost.equals(DHL));
        System.out.println("They are from the same class but uses different constructors, that is why they are not equal.\n");
        System.out.println("Is LIBRARY ADDRESS equals to MAIL ADDRESS? (The answer should  be false) \n→ "
                + library.equals(mail));
        System.out.println("Is COSTCO ADDRESS equals to MUSEUM ADDRESS? (The answer should be false) \n→ "
                + costco.equals(museum));
        System.out.println("They are from different classes with different constructors, that is why they are not equal.\n");

        System.out.println("\n------------------------------PART 2------------------------------\n");
        for(int i = 0; i <address.length; i++){
            System.out.println((i+1) + ". COPY " + name[i] + "\n" +copyAddresses(address)[i] + "\n");
            System.out.println((i+1) + ". " +name[i] + "\n" +address[i] + "\n");
        }

        System.out.println("The program has ended");

    }
}

