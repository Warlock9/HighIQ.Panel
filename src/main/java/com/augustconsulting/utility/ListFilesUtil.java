package com.augustconsulting.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFilesUtil {
    /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName()+" "+file.getAbsolutePath());
        }
    }
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        List<String>li=new ArrayList<String>();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
                li.add(file.getName()+" "+file.getAbsolutePath());
            }
        }
        System.out.println(li);
    }
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getAbsolutePath());
            }
        }
    }
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }
    public static void main (String[] args){
        ListFilesUtil listFilesUtil = new ListFilesUtil();
       // final String directoryLinuxMac ="/Users/loiane/test";
        //Windows directory example
        final String directoryWindows ="D:\\HighIQ_Utility\\Happy\\PurchaseOrder\\input";
      listFilesUtil.listFiles(directoryWindows);
        //listFilesUtil.listFolders(directoryWindows);
    }
}