package com.company.controllers;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path fileDir;
    private String filesPath;
    private String fileString;
    private Path dirPath;
    private Path filePath;
    public boolean outOfRange = false;


    public FileManager()
    {
        fileDir = Paths.get("files");
        filesPath = fileDir.toFile().getAbsolutePath();
        fileString = "names.txt";

        dirPath = Paths.get(filesPath);
        filePath = Paths.get(filesPath, fileString);
    }

    public int fileCheck(){
        int errorCatch = -1;

        if(Files.notExists(dirPath)) {
            try{
                Files.createDirectories(dirPath);
            } catch (IOException e){
                e.printStackTrace();
                errorCatch = 1;
            }
        }

        if(Files.notExists(filePath)){
            try{
                errorCatch = 2;
                Files.createFile(filePath);
            } catch(IOException e){
                e.printStackTrace();
                errorCatch = 0;
            }
        }

        if(errorCatch == -1)
        {
            errorCatch = 3;
        }

        return errorCatch;
    }

    public String getName(int namePlace)
    {
        BufferedReader in;
        String[] allNames;
        String name = "";

        try{
            in = new BufferedReader(new FileReader(String.valueOf(filePath)));
            List<String> lines = new ArrayList<>();

            String line = null;


            try{
                line = in.readLine();
                while(line != null){
                    lines.add(line);
                    line = in.readLine();
                }

                if(namePlace >= lines.size()){
                    outOfRange = true;
                    return "";
                }

                in.close();

                allNames = lines.toArray(new String[lines.size()]);
                name = allNames[namePlace];

            } catch(FileNotFoundException e){
                e.printStackTrace();
            }



        } catch(IOException e) {
            e.printStackTrace();
        }
        return name;
    }



}
