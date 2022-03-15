package com.company;

import java.util.Scanner;


public class Patient extends Booth {
    public static int vNumber;
    public static String fName;
    public static String sName;


    public static void patientDetails(){ // personal details of patient
        Scanner in = new Scanner(System.in);
        System.out.print("First Name : ");
        fName = in.next();
        System.out.print("Surname : ");
        sName = in.next();
        System.out.println("--------Select Vaccination-----------");
        System.out.println("");
        System.out.println("\t AstraZeneca (Enter number 1)");
        System.out.println("\t Sinopharm (Enter number 2)");
        System.out.println("\t Pfizer (Enter number 3)");
        System.out.println("");
        System.out.print("Enter Vaccination Number :");
        vNumber = in.nextInt();





    }
}
