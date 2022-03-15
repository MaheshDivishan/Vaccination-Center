package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Booth extends VaccinationCenter {


    public static String[] vaccinationCenter = new String[6];
    public static String[] patientNames = new String[6];
    public static LinkedList <String> list = new LinkedList <String>();

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
                        if(list.isEmpty()){
                            break;

                        }else{
                            vaccinationCenter[boothNumber] = list.getFirst();
                            for (int x = 0; x < 6; x++) {
                                System.out.println("\tBooth " + x + " occupied by " + vaccinationCenter[x]);
                            }
                            list.remove();

                        }



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
        while (true) {
            if (!vaccinationCenter[0].equals("empty") && !vaccinationCenter[1].equals("empty") && !vaccinationCenter[3].equals("empty") && !vaccinationCenter[4].equals("empty") && !vaccinationCenter[5].equals("empty")) {
                System.out.println("Vaccination Center is full now");
                System.out.println("");
                System.out.println("-------------------Add to the waiting list------------------");
                System.out.println("");
                System.out.print("Enter Your First Name :");
                Scanner in = new Scanner(System.in);
                String waitingName = in.next();
                System.out.print("Enter Your Surname :");
                String wsName = in.next();
                list.add(waitingName+" "+wsName);
                System.out.print("");
                System.out.println(waitingName+" "+wsName + " " + "added to the waiting list");
                System.out.print("Enter 'y' to add another patient or enter 's' to Stop : ");
                String waitingPatient = in.next();
                if (waitingPatient.equals("y"))
                    continue;
                else if (waitingPatient.equals("s"))
                    break;
            } else {
                int boothnumber;

                Patient.patientDetails();
                if (Patient.vNumber == 1)
                    System.out.print("Enter booth number (0 or 1) enter 6 to stop : ");
                else if (Patient.vNumber == 2)
                    System.out.print("Enter booth number (2 or 3) enter 6 to stop : ");
                else if (Patient.vNumber == 3)
                    System.out.print("Enter booth number (4 or 5) enter 6 to stop : ");
                Scanner in = new Scanner(System.in);
                try {
                    boothnumber = in.nextInt();
                    if (boothnumber >= 0 && boothnumber <= 5) {
                        if (vaccinationCenter[boothnumber].equals("empty")) {
                            patientNames[boothnumber] = Patient.fName+" "+Patient.sName;
                            vaccinationCenter[boothnumber] = Patient.fName + " " + Patient.sName;
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


    }
}