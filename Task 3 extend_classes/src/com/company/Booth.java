package com.company;

import java.util.Scanner;

public class Booth extends VaccinationCenter {


    public static String[] vaccinationCenter = new String[6];
    public static String[] patientNames = new String[6];

    public static void first() {

        for (int x = 0; x < 6; x++) vaccinationCenter[x] = "empty";
    }


    public static void removePatientBooth() { //remove patients from booth
        int boothNumber;
        while (true) {
            System.out.print("Enter booth number for remove patient (0-5) or 6 to stop : ");
            Scanner in = new Scanner(System.in);
            try {
                boothNumber = in.nextInt();
                if (boothNumber >= 0 && boothNumber <= 5) {
                    if (!vaccinationCenter[boothNumber].equals("empty")) {
                        System.out.println(vaccinationCenter[boothNumber] + " is removed from booth number" + " " + boothNumber);
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
            Patient.patientDetails();
            if (Patient.vNumber == 1)
            System.out.print("Enter booth number (0 or 1) enter 6 to stop : ");
            else if(Patient.vNumber == 2)
                System.out.print("Enter booth number (2 or 3) enter 6 to stop : ");
            else if(Patient.vNumber == 3)
                System.out.print("Enter booth number (4 or 5) enter 6 to stop : ");
            Scanner in = new Scanner(System.in);
            try {
                boothnumber = in.nextInt();
                if (boothnumber >= 0 && boothnumber <= 5) {
                    if (vaccinationCenter[boothnumber].equals("empty")) {
                        patientNames[boothnumber] = Patient.fName+" "+Patient.sName;
                        vaccinationCenter[boothnumber] = Patient.fName+" "+Patient.sName;
                        vaccination = vaccination - 1;
                        System.out.println(vaccination == 20 ? "-----------!!! There are only 20 vaccines now!!! ---------\n" : "");
                        for (int x = 0; x < 6; x++) {
                            System.out.println("\tBooth " + x + " occupied by " + vaccinationCenter[x]);
                        }
                        System.out.print("Enter 'y' to add nother patient or enter 's' to Stop : ");
                        String notherPatient = in.next();
                        if(notherPatient.equals("y"))
                            continue;
                        else if(notherPatient.equals("s"))
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


}