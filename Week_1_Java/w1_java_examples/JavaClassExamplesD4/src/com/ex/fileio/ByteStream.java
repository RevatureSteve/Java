package com.ex.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStream {
	public static void main(String[] args) {
		
		String filename = "src/com/ex/fileio/sampleByteFile.txt";
		
		writeByteStream(filename);
//		readByteStream(filename);
		
		readThisClassFile(); //Reads .class file - java  compiled into bytecode
	}
	
	static void readByteStream(String filename){
		
		try( InputStream is = new FileInputStream(filename) ){
			//Reads sampleByteFile.txt
			int i;
			while((i = is.read()) != -1){ //Reads until end of file which returns -1
				System.out.print(i + " ");;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writeByteStream(String filename){
		
		try(OutputStream os = new FileOutputStream(filename,true)){
			//write sampleByteFile.txt
			os.write(65);
			os.write(66);
			os.write(67);
			os.write(68);
			os.write(69);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void readThisClassFile(){
		//The bin folder is in the same location as your src folder
		String filename = "bin/com/ex/fileio/ByteStream.class";
		
		try(InputStream is = new FileInputStream(filename)){
			
			/*
			 * Reads some number of bytes from the input stream 
			 * and stores them into the buffer array.
			 * 
			 * Parameters: byte[] b the buffer into which the data is read.
			 */
			byte[] first4Bytes = new byte[4]; //byte array
			is.read(first4Bytes);
			
			for(byte b : first4Bytes){				
				System.out.print(Integer.toHexString(b).substring(6)); 
				//Converts b to a HexString starting from the 6 index
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
}
