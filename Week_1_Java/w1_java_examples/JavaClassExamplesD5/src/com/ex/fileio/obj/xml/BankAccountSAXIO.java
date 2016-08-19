package com.ex.fileio.obj.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/*
 * javax.xml
 * org.xml.sax
 * 
 * Must create a separate class that will define how we handle the events
 * The class must extend from DefaultHandler - org.xml.sax.helpers.DefaultHandler
 */
public class BankAccountSAXIO {
	public static void main(String[] args) {
		
		String filename = "src/com/ex/fileio/obj/xml/bankAccounts.xml";
		
		readBankAccounts(filename);
	}
	
	static void readBankAccounts(String filename){
		
		try {
			/*
			 * Obtain a new instance of a SAXParserFactory. 
			 * This static method creates a new factory instance
			 */
			SAXParserFactory factory = SAXParserFactory.newInstance();
			
			
			/*
			 * Creates a new instance of a SAXParser using the currently configured factory parameters.
			 */
			SAXParser saxParser = factory.newSAXParser();
			
			//Pass that SaxParser your file and Handler
			saxParser.parse(filename, new BankAccountHandler());
			
			
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
