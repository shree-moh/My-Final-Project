package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockerProject 
{
    static final String folderpath="C:\\Users\\srima\\OneDrive\\Desktop\\learner\\Myproject(phase-1)\\Locker Files";
	public static void main(String[] args)
	{
		int proceed=1;
		do
		{
		//varriable declaration
		Scanner obj=new Scanner(System.in);
		int ch;
		//menu
		displayMenu();
		System.out.println("Enter your choice");
		ch=Integer.parseInt(obj.nextLine());
		switch(ch)
		{
		case 1:getAllFiles();
		break;
		case 2:createFiles();
		break;
		case 3:deleteFiles();
		break;
		case 4:searchFiles();
		break;
		case 5:System.exit(0);
		break;
		default:System.out.println("Invalid option");
		}
		}
		while(proceed>0);
		
		
	}
	public static void displayMenu()
	{
		System.out.println("========================================");
		System.out.println("\t\tLockedme.com");
		System.out.println("========================================");
		System.out.println("1.Display all files");
		System.out.println("2.Add new files");
		System.out.println("3.Delete all files");
		System.out.println("4.search all files");
		System.out.println("5.Exit");
		System.out.println("========================================");
		
	}
	public static void getAllFiles() 
	{
		//get file names
		List<String>fileNames=FileManager.getAllFiles(folderpath);
		if(fileNames.size()==0)
			System.out.println("no files in the directory");
		else
		{
		System.out.println("file list is bellow:\n");
		//for-each loop
		for(String f:fileNames)
		System.out.println(f);
		}
	}
	
	public static void createFiles()
	{
		//Variable declaration
		Scanner obj=new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String>content=new ArrayList<String>();
				
		//read file name from user
		System.out.println("Enter file name:");
		fileName=obj.nextLine();
				
		//read no.of lines
		System.out.println("Enter how many lines in the file:");
		linesCount=Integer.parseInt(obj.nextLine());
				
		//read lines from the user
		for(int i=1;i<=linesCount;i++)
		{
		System.out.println("Enter line"+i+":");
		content.add(obj.nextLine());
		}
		//save the content into the file
		boolean isSaved=FileManager.createFiles(folderpath,fileName,content);
		if(isSaved)
		System.out.println("file and data saved succesfully");
		else
		System.out.println("some errors occured.Please contact admin@care");
		
	}
	public static void deleteFiles()
	{
		//code for deleting a file
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the name of the file to be deleted:");
		fileName=obj.nextLine();
		boolean isDeleted=FileManager.deleteFile(folderpath, fileName);
		if(isDeleted)
			System.out.println("File deleted successfully.");
		else
		     System.out.println("file may not be there or some access issue.");
	}
	public static void searchFiles()
	{
		//code for searching a file
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the name of the file to be searched:");
		fileName=obj.nextLine();
		boolean isFound=FileManager.searchFile(folderpath, fileName);
		if(isFound)
		        System.out.println("File is there in the folder.");
		else
		        System.out.println("file is not present.");
	}
	

}
