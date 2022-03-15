package com.company;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.*;
import java.util.Scanner;


public class Task3 {
    public static int vaccination = 150;   // vaccinations in the store
    public static String patientName;
    public static String[] vaccinationCenter = new String[6];
    public static String[] patientNames = new String[6];
    public static int vNumber;
    public static String fName;
    public static String sName;


    public static String s1;
    public static String s2;
    public static String s3;
    public static String s4;
    public static String s5;
    public static String s6;

    public static void main(String[] args) throws IOException {
        for (int x = 0; x < 6; x++) vaccinationCenter[x] = "empty";
        while (true) {

            System.out.println("---------------- Welcome to Vaccination Center ---------------");
            System.out.println("100 or VVB: View all Vaccination Booths");
            System.out.println("101or VEB:View all Empty EmptyBooths");
            System.out.println("102or APB:Add Patient to a Booth");
            System.out.println("103or RPB:Remove Patient from a Booth");
            System.out.println("104or VPS:View Patients Sorted in alphabetical order ");
            System.out.println("105or SPD:Store Program Data into file");
            System.out.println("106or LPD:Load Program Data from file");
            System.out.println("107 or VRV:View Remaining Vaccinations");
            System.out.println("108 or AVS:Add Vaccinations to the Stock");
            System.out.println("999 or EXT:Exit the Program");

            System.out.print("Enter a number:");
            Scanner in = new Scanner(System.in);
            String input = in.next();

            switch (input) {
                case "VVB":
                case "100":
                    System.out.println("\n------- View all Vaccination Booths -------");
                    vaccinationBooths();
                    break;
                case "101":
                case "VEB":
                    System.out.println("\n------- View all Empty Empty Booths -------");
                    emptyBooths();
                    break;
                case "102":
                case "APB":
                    System.out.println("\n------- Add Patient to a Booth -------");
                    addPatientBooth();
                    break;
                case "103":
                case "RPB":
                    System.out.println("\n------ Remove Patient from a Booth ------");
                    removePatientBooth();
                    break;
                case "104":
                case "VPS":
                    alphabeticalOrder();
                    break;
                case "105":
                case "SPD":
                    storeData();
                    break;
                case "106":
                case "LPD":
                    loadData();
                    break;
                case "107":
                case "VRV":
                    System.out.println("\n------ View Remaining Vaccinations ------");
                    viewRemainingVaccine();
                    break;
                case "108":
                case "AVS":
                    System.out.println("\n------- Add Vaccinations to the Stock ------");
                    addVaccine();
                    break;
                case "109":
                case "EXT":
                    break;
                default:
                    System.out.println("invalid input");
                    break;


            }

            System.out.println("");
        }


    }


    public static void alphabeticalOrder() {// show patients names alphabetically
        for (int y = 0; y < 6; y++) {
            if (patientNames[y] == null) {
                patientNames[y] = " ";
            }

        }

        boolean True = false;
        do {
            True = false;
            for (int i = 0; i < patientNames.length - 1; i++) {
                if (patientNames[i].compareTo(patientNames[i + 1]) > 0) {
                    String temp = patientNames[i + 1];
                    patientNames[i + 1] = patientNames[i];
                    patientNames[i] = temp;
                    True = true;
                }

            }


        } while ((True));
        System.out.println("----------Alphabetical Order-----------");
        for (int x = 0; x < patientNames.length; x++)
            System.out.println(patientNames[x]);


    }

    private static void loadData() throws IOException {   // load data from saved text file
        FileInputStream fin = new FileInputStream("vaccination.txt");
        ObjectInputStream objin = new ObjectInputStream(fin);
        try {
            Savedata s1 = (Savedata) objin.readObject();
            Savedata s2 = (Savedata) objin.readObject();
            Savedata s3 = (Savedata) objin.readObject();
            Savedata s4 = (Savedata) objin.readObject();
            Savedata s5 = (Savedata) objin.readObject();
            Savedata s6 = (Savedata) objin.readObject();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
            System.out.println(s5);
            System.out.println(s6);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void storeData() throws IOException {  //store data to the text file
        File f1 = new File("vaccination.txt");
        f1.createNewFile();

        FileOutputStream fout = new FileOutputStream(f1);
        ObjectOutputStream objout = new ObjectOutputStream(fout);

        Savedata s1 = new Savedata(vaccinationCenter[0], "0");
        Savedata s2 = new Savedata(vaccinationCenter[1], "1");
        Savedata s3 = new Savedata(vaccinationCenter[2], "2");
        Savedata s4 = new Savedata(vaccinationCenter[3], "3");
        Savedata s5 = new Savedata(vaccinationCenter[4], "4");
        Savedata s6 = new Savedata(vaccinationCenter[5], "5");


        objout.writeObject((s1));
        objout.writeObject((s2));
        objout.writeObject((s3));
        objout.writeObject((s4));
        objout.writeObject((s5));
        objout.writeObject((s6));


        objout.close();
        fout.close();
        System.out.println("Data saved");

    }

    public static void addVaccine() {   // add vaccine to the store
        boolean VaccinesValidation;

        do {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("How many vaccines do you want add to the stock ? : ");
                int Vaccines = in.nextInt();
                if (Vaccines > 0) {
                    vaccination = (vaccination + Vaccines);
                    System.out.println("Stock have " + vaccination + " vaccines now");
                } else {
                    System.out.println("Input is wrong number Try nother one!");
                }

                VaccinesValidation = false;
            } catch (Exception e) {
                System.out.println("Please enter Integer input!");
                VaccinesValidation = true;
            }
        } while (VaccinesValidation);
    }

    public static void viewRemainingVaccine() {   // show remaining vaccines now

        System.out.println(vaccination);
    }

    public static void removePatientBooth() {   //remove patients from booth

        int boothNumber;
        while (true) {
            System.out.print("Enter booth number for remove patient (0-5) or 6 to stop : ");
            Scanner in = new Scanner(System.in);
            try {
                boothNumber = in.nextInt();
                if (boothNumber >= 0 && boothNumber <= 5) {
                    if (!vaccinationCenter[boothNumber].equals("empty")) {
                        System.out.println(vaccinationCenter[boothNumber] + " removed from booth number" + " " + boothNumber);
                        vaccinationCenter[boothNumber] = "empty";

                    } else {
                        System.out.println("This booth is Already Empty!");
                    }
                } else if (boothNumber == 6) {
                    break;
                } else {
                    System.out.println("Invalid Booth Number!");
                }
            } catch (Exception e) {
                System.out.println("Please Enter Integer Input!");
            }
        }
    }

    public static void addPatientBooth() { // add patient to the booth
        int boothnumber;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("First Name : ");
            fName = in.next();
            System.out.print("Surname : ");
            sName = in.next();
            System.out.print("Age : ");
            String age = in.next();
            System.out.print("City : ");
            String city = in.next();
            System.out.print("NIC or Passport Number : ");
            long nic = in.nextInt();
            System.out.println("--------Select Vaccination-----------");
            System.out.println("");
            System.out.println("\t AstraZeneca (Enter number 1)");
            System.out.println("\t Sinopharm (Enter number 2)");
            System.out.println("\t Pfizer (Enter number 3)");
            System.out.println("");
            System.out.print("Enter Vaccination Number :");
            vNumber = in.nextInt();
            if (vNumber == 1)
                System.out.print("Enter booth number (0 or 1) enter 6 to stop : ");
            else if (vNumber == 2)
                System.out.print("Enter booth number (2 or 3) enter 6 to stop : ");
            else if (vNumber == 3)
                System.out.print("Enter booth number (4 or 5) enter 6 to stop : ");

            try {
                boothnumber = in.nextInt();
                if (boothnumber >= 0 && boothnumber <= 5) {
                    if (vaccinationCenter[boothnumber].equals("empty")) {
                        patientNames[boothnumber] = fName + " " + sName;
                        vaccinationCenter[boothnumber] = fName + " " + sName;
                        vaccination = vaccination - 1;
                        System.out.println(vaccination == 20 ? "-----------!!! There are only 20 vaccines now!!! ---------\n" : "");
                        for (int x = 0; x < 6; x++) {
                            System.out.println("\tBooth " + x + " occupied by " + vaccinationCenter[x]);
                        }
                        System.out.print("Enter 'y' to add nother patient or enter 's' to Stop : ");
                        String notherPatient = in.next();
                        if (notherPatient.equals("y"))
                            continue;
                        else if (notherPatient.equals("s"))
                            break;
                    } else {
                        System.out.println("This booth Already has a patient!");
                    }
                } else if (boothnumber == 6) {
                    break;
                } else {
                    System.out.println("Invalid Booth Number!");
                }
            } catch (Exception e) {
                System.out.println("Please Enter Integer Input!");
            }
        }
    }




    public static void emptyBooths() {    //show all empty booths
        for (int x = 0; x < 6; x++ )
        if (vaccinationCenter[x].equals("empty"))System.out.println("booth " + x + " is empty");



    }

    private static void vaccinationBooths() {  //view all vaccination booths
        int i;
        for(i=0;i<6;i++){
            System.out.println("Vaccination Booth number "+i+" - "+vaccinationCenter[i]);
        }




    }

}
