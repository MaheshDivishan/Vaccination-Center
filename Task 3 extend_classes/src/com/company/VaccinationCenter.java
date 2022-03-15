package com.company;
import java.io.*;
import java.util.Scanner;

public class VaccinationCenter {


    public static int vaccination = 150;

    public static void addVaccine() {
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

    public static void viewRemainingVaccine() { // show remaining vaccines now

        System.out.println(vaccination);
    }

    public static void vaccinationBooths() { //view all vaccination booths
        int i;
        for (i = 0; i < 6; i++) {
            System.out.println("Vaccination Booth number "+i+" - "+Booth.vaccinationCenter[i]);
        }


    }

    public static void emptyBooths() { //show all empty booths
        for (int x = 0; x < 6; x++) {
            if (Booth.vaccinationCenter[x].equals("empty")) System.out.println("booth " + x + " is empty");

        }
    }

    public void storeData() throws IOException { //store data to the text file
        File f1 = new File("vaccination.txt");
        f1.createNewFile();

        FileOutputStream fout = new FileOutputStream(f1);
        ObjectOutputStream objout = new ObjectOutputStream(fout);

        Savedata s1 = new Savedata(Booth.vaccinationCenter[0], "0");
        Savedata s2 = new Savedata(Booth.vaccinationCenter[1], "1");
        Savedata s3 = new Savedata(Booth.vaccinationCenter[2], "2");
        Savedata s4 = new Savedata(Booth.vaccinationCenter[3], "3");
        Savedata s5 = new Savedata(Booth.vaccinationCenter[4], "4");
        Savedata s6 = new Savedata(Booth.vaccinationCenter[5], "5");


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

    public void loadData() throws IOException { // load data from saved text file
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

    public static void alphabeticalOrder() { // show patients names alphabetically
        for(int y=0;y<6;y++){
            if (Booth.patientNames[y] == null) {
                Booth. patientNames[y] = " ";
            }

        }

        boolean True = false;
        do {
            True = false;
            for (int i = 0; i < Booth.patientNames.length - 1; i++) {
                if (Booth.patientNames[i].compareTo(Booth.patientNames[i + 1]) > 0) {
                    String temp = Booth.patientNames[i + 1];
                    Booth.patientNames[i + 1] = Booth.patientNames[i];
                    Booth.patientNames[i] = temp;
                    True = true;
                }

            }


        } while ((True));
        System.out.println("----------Alphabetical Order-----------");
        for (int x = 0; x < Booth.patientNames.length; x++)
            System.out.println(Booth.patientNames[x]);


    }
}
