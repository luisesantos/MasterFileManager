package model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import model.vo.ProductVO;

public class FileManager {

	public static ArrayList<ProductVO> readFileAddToMaster(String filePath, String code){
			
		try{
		  FileInputStream fstream = new FileInputStream(filePath);
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader    br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  ArrayList<ProductVO> result=new ArrayList<ProductVO>();
		  while ((strLine = br.readLine()) != null)   {
			  ProductVO item = new ProductVO();
			  item.setType(code);
			  item.setCode(strLine);
			  result.add(item);
		  }
		
		  in.close();
		  return result;
		 }catch (Exception e){
			 e.printStackTrace();
			 return null;
		 }
	}
	
	public static boolean writeMasterFile(String fileName, ArrayList<ProductVO> products){
		  
		try{
			  File file = new File(fileName);
			  boolean exist = file.createNewFile();
			  
			  if (!exist){
				  return false;
			  }else{
				  FileWriter fstream = new FileWriter(fileName);
				  BufferedWriter out = new BufferedWriter(fstream);
				  for (Iterator<ProductVO> i = products.iterator(); i.hasNext(); ){
					  ProductVO p = i.next();
					  out.write(p.getCode() + "," + p.getType() + "\n");
				  }
					    
				  out.close();
				  return true;
			  }
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
