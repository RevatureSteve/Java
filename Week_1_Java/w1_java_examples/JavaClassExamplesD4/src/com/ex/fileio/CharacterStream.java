package com.ex.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharacterStream {
	public static void main(String[] args) {
		
		String filename = "src/com/ex/fileio/charExample.txt";
		
		readCharacterStream(filename);
		
		writeCharacterStream(filename);
		
	}
	
	static void readCharacterStream(String filename){
		
		try(
				FileReader reader = new FileReader(filename);
		
				){ //Throws FileNotFoundException
			
			int i;
			/*
			 * Reads a single character.
			 */
			while ( (i = reader.read() ) != -1) {
				System.out.print((char) i);
			}
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void writeCharacterStream(String filename){
		/*
		 * 	FileWriter(String fileName, boolean append)
		 */
		try (FileWriter writer = new FileWriter(filename,false);) {
			/*
			 * Writes a single character in ASCII
			 */
			for(int i = 65; i < 72; i++){
				writer.write(i);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
