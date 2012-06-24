package model.file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileManager {

	public static void readFile(String filePath){
			
		try{
		  FileInputStream fstream = new FileInputStream("textfile.txt");
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader    br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  while ((strLine = br.readLine()) != null)   {
			  System.out.println (strLine);
		  }
		
		  in.close();
		 }catch (Exception e){
			 System.err.println("Error: " + e.getMessage());
		 }
	}
}
