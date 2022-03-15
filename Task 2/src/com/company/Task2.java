package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Task2 {



    public static void main(String[] args) throws IOException {
        VaccinationCenter vcenter = new VaccinationCenter();
        Booth booth = new Booth();
        Booth.first();


        while(true){

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

            switch(input){
                case "VVB"  :
                case "100"  :
                    System.out.println("\n------- View all Vaccination Booths -------");
                    vcenter.vaccinationBooths();
                    break;
                case "101"  :
                case "VEB"  :
                    System.out.println("\n------- View all Empty Empty Booths -------");
                    vcenter.emptyBooths();
                    break;
                case "102"  :
                case "APB"  :
                    System.out.println("\n------- Add Patient to a Booth -------");
                    booth.addPatientBooth();
                    break;
                case "103"  :
                case "RPB"  :
                    System.out.println("\n------ Remove Patient from a Booth ------");
                    booth.removePatientBooth();
                    break;
                case "104"  :
                case "VPS"  :
                    vcenter.alphabeticalOrder();
                    break;
                case "105"  :
                case "SPD"  :
                    vcenter.storeData();
                    break;
                case "106"  :
                case "LPD"  :
                    vcenter.loadData();
                    break;
                case "107"  :
                case "VRV"  :
                    System.out.println("\n------ View Remaining Vaccinations ------");
                    vcenter.viewRemainingVaccine();
                    break;
                case "108"  :
                case "AVS"  :
                    System.out.println("\n------- Add Vaccinations to the Stock ------");
                    vcenter.addVaccine();

                    break;
                case "109"  :
                case "EXT"  :
                    break;
                default:
                    System.out.println("invalid input");
                    break;




            }

            System.out.println("");
        }
    }
}
