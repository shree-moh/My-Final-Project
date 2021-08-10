package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
 public static List<String>getAllFiles(String folderpath)
 {
	 //creating file object
	 File fl=new File(folderpath);
	 
	 //getting all the files into file array
	 File[] listofFiles=fl.listFiles();
	 
	 //declaring list to store file name
	 List<String>fileNames=new ArrayList<String>();
	 
	 for(File f:listofFiles)
		 fileNames.add(f.getName());
		 
		 //return the list
		 return fileNames;
	 
	 
 }
 
 /**
  * this method creates or appends content into the file specified
  * @param folderpath
  * @param content
  * @return boolean
  */
 public static boolean createFiles(String folderpath,String fileName,List<String>content)
 {
	try
	{
	 File fl=new File(folderpath,fileName)	;
	 FileWriter fw=new FileWriter(fl);
	 for(String s:content)
	 {
		 fw.write(s+"\n");
	 }
	 
	 fw.close();
	 return true;
	}
	catch(Exception Ex)
	{
		return false;
	}
 }
 public static boolean deleteFile(String folderpath,String fileName)
 {
	 File file=new File(folderpath+"\\"+fileName);
 try
 {
	 if(file.delete())
		 return true;
	 else
		 return false;
 }
 catch(Exception Ex)
 {
	 return false;
 }
 }
 /**
  * this method search the file from the folder
  * @param folderpath
  * @param fileName
  * @return
  */
 public static boolean searchFile(String folderpath,String fileName)
 {
	 //adding folder path with file name and creating file object
	 File file=new File(folderpath+"\\"+fileName);
	 if(file.exists())
		 return true;
	 else
		 return false;
}
}
