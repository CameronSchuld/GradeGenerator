package com.company.controllers;

import com.company.controllers.FileManager;
import com.company.view.Output;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String errorPrint[] = new String[5];
        int fileError = -1;
        String currentName = "";
        char grade = '0';
        Output output = new Output();

        errorPrint[0] = "File does not exist... \nUnable to create one.\n";
        errorPrint[1] = "Folder does not exist... \nUnable to create one.\n";
        errorPrint[2] = "File Created, but contains nothing. Please fill in the file and restart.\n";
        errorPrint[3] = "File opened successfully.\n";

        fileError = fileManager.fileCheck();
        System.out.print(errorPrint[fileError]);

        if (fileError < 3){
            return;
        }



        System.out.println(currentName);

        int run = -1;
        while(!fileManager.outOfRange){
            run++;
            int percent = new Random().nextInt(99) + 1;
            currentName = fileManager.getName(run);

            if(percent > 89)
            {
                grade = 'A';
            }
            else if(percent > 79)
            {
                grade = 'B';
            }
            else if(percent > 69)
            {
                grade = 'C';
            }
            else if(percent > 59)
            {
                grade = 'D';
            }
            else{
                grade = 'F';
            }

            if(currentName != "")
            {
                output.printInfoLine(currentName, percent, grade);
            }
        }

        return;
    }
}
