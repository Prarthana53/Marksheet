/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marksheet;

import java.util.Scanner;

/**
 *
 * @author Pavilion G4
 */
public class Marksheet {

    public static void main(String args[]) {
        int i, j, studnum;
        int k = 0;
        String choice = "";

        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] subjects = {"Mathematics", "Science", "English", "Social", "Nepali", "EHP", "Optional Mathematics", "Account"};
            System.out.println("How many Students: ");
            studnum = sc.nextInt();

            String[] StudentName = new String[studnum];
            int[] roll = new int[studnum];
            float[][] studmarks = new float[StudentName.length][subjects.length];
            float[] sum = new float[StudentName.length];
            float[] avg = new float[StudentName.length];
            String[] passedstudent = new String[studnum];

            //    String exellent = "Exellent :";
            for (i = 0; i < StudentName.length; i++) {

                System.out.println("Enter the name of student: ");
                StudentName[i] = sc.next() + " " +sc.next();
                System.out.println("Enter Roll no: ");
                roll[i] = sc.nextInt();

                for (j = 0; j < subjects.length; j++) {
                    System.out.print("Enter marks for " + StudentName[i] + " in " + subjects[j] + " out of 100: ");
                    studmarks[i][j] = sc.nextFloat();
                    if (studmarks[i][j] > 100) {
                        System.out.println("\n" + "Marks cannot be more than 100. Please enter your marks again out of 100: ");
                        System.out.print("Enter marks for " + StudentName[i] + " in " + subjects[j] + " out of 100: ");
                        studmarks[i][j] = sc.nextFloat();
                    } else if (studmarks[i][j] < 32) {
                        choice = "failed";

                    }
                    sum[i] += studmarks[i][j];
                }

                if (choice.equals("failed")) {

                    System.out.println("Result: Failed ");

                } else {
                    passedstudent[k] = StudentName[i];
                    avg[k] = (sum[i] / 8);
                    System.out.println("Total Marks = " + sum[i]);
                    System.out.println("Percentage =" + avg[k] + "%");

                    if (avg[k] >= 80) {
                        System.out.println("Distinction ^_^");
                        //  exellent += "\n" + StudentName[i] + "\t" + avg[i] + "\n";
                        //System.out.println(exellent);

                        System.out.println("Congratulations, you got the scholarship!!");
                    } else if (avg[k] >= 60 && avg[k] < 80) {
                        System.out.println("First Division!!!");

                    } else if (avg[k] >= 50 && avg[k] < 60) {
                        System.out.println("Second Division!!");

                    } else {
                        System.out.println("Third Division!");

                    }
                    k++;
                }
                choice = "";

            }
            System.out.println("1. SEE THE RANK");
            System.out.println("2. EXIT");
            int select = sc.nextInt();
            switch (select) {
                case 1:

                    rank(avg, passedstudent, k);
                    break;
                case 2:
                    System.exit(0);
                    break;

            }
        
    
    

    
        System.out.println("Do you want to continue[Y/N]: ");
        String str = sc.next();
        if (str.equalsIgnoreCase("n")) {
            System.exit(0);
        }
    }
}
private static void rank(float[] arrayp, String[] arrayn, int length) {
        float temp = 0;
        String name = "";
        int count = 1;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arrayp[j - 1] < arrayp[j]) 
                    temp = arrayp[j - 1];
                
                arrayp[j - 1] = arrayp[j];
                arrayp[j] = temp;

                name = arrayn[j - 1];
                arrayn[j - 1] = arrayn[j];
                arrayn[j] = name;

            }
        }
        System.out.println("Name             %");
        for (int i = 0; i < length; i++) {
            System.out.println(count + ". " + arrayn[i] + " " + arrayp[i]+"%");
            count++;
        }
}
}
