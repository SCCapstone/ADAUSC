package edu.sc.cse.adausc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Driver {

	public static void main(String[] args) {
		//open .html file in desktop
		oCodeSections = new ArrayList<StandardSection>();
		try{
			File oFile = new File("C:\\Users\\dohertsm\\Desktop\\2010ADAstandards.txt");
			System.out.println("File opened.");
			String line;
			FileReader oReader = new FileReader(oFile);
			BufferedReader oBuffer = new BufferedReader(oReader);
			while((line = oBuffer.readLine().trim()) != null){
				if(line.length() > 3){
					if(line.substring(0, 3).equals("<p>")){
						ExtractSection(line);
					}			
				}
			}
			oReader.close();
		}catch(Exception oEx){
			System.out.println("::::" + oEx.getMessage());
		}
		System.out.println("File closed.");
		
		try{
			File oFile = new File("C:\\Users\\dohertsm\\Desktop\\SerializedStandards\\Metadata.ada");
			oFile.createNewFile();
			//FileOutputStream fileOut =  new FileOutputStream(oFile);
			FileWriter oFileOut = new FileWriter(oFile);
			for (StandardSection oSec : oCodeSections) {
				oFileOut.write(oSec.getCode()+ " " + oSec.getTitle() + System.lineSeparator());
			}
			oFileOut.close();
			System.out.println("Complete!");
		} catch (Exception oEx){
			//System.out.println(oEx.getMessage());
		}
	}

	private static void ExtractSection(String oLine) {
		int oStartIndex = oLine.indexOf("<strong>") + 8;
		int oEndIndex = oLine.indexOf("</strong");
		if(oStartIndex > -1 && oEndIndex > oStartIndex){
			String oCheck = oLine.substring(oStartIndex, oEndIndex);
			try{			
			Integer oCode = Integer.parseInt(oCheck.substring(0, 3));			
			if(oCode > 100){
				String oSectionCode = oCheck.substring(0, oCheck.indexOf(' '));
				String oTitle = oCheck.substring(oCheck.indexOf(' ') + 1, oCheck.length()-1);
				String oContent = oLine.substring(oEndIndex + 9, oLine.indexOf("</p>")).trim();				
				StandardSection oStandard = new StandardSection(oSectionCode, oTitle, oContent);
				//oStandard.PrintValue();				
				File oFile = new File("C:\\Users\\dohertsm\\Desktop\\SerializedStandards\\s" + oSectionCode + ".ada");
				oFile.createNewFile();				
				FileOutputStream fileOut =  new FileOutputStream(oFile);//"C:\\Users\\dohertsm\\Desktop\\sections.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);				
				out.writeObject(oStandard);
				out.close();
				fileOut.close();
				oCodeSections.add(oStandard);
				System.out.println(oSectionCode);
			}
			} catch(Exception oEx){
				//System.out.println("::" + oEx.getMessage());
			}			
		}
	}
	
	public static ArrayList<StandardSection> oCodeSections;
	
	
}
