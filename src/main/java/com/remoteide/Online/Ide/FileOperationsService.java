package com.remoteide.Online.Ide;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileOperationsService {

    private boolean deleteFileIfExist(String path){
        File myObj = new File(path);
        if (!myObj.exists()) {
            return true;
        }
        if (myObj.delete()) {
            return true;
        } else {
           return false;
        }
    }
    public boolean createFile(String filePath){
        if(!deleteFileIfExist(filePath)){
            return false;
        }
        boolean isFileCreated = false;

        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                isFileCreated = true;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    return isFileCreated;
    }

    public boolean writeToFile(String path, String content){
        boolean isWriteToSuccess = false;

        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(content);
            myWriter.close();
           isWriteToSuccess = true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    return isWriteToSuccess;
    }

}
