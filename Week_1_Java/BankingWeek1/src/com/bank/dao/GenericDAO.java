package com.bank.dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bank.model.BankObject;
/*
 * DAO - Data Access Object
 * 
 * Created a GenericDAO so we can persist multiple data objects
 * 
 * In this example we are only persisting 1 type of object - BANK 
 * but what if we had multiple Objects we wanted to persist like Customer information ie name, phone# address etc
 * Would you want to rewrite multiple Save and Get Methods or just pass the Object and File you're trying to store?
 */
public class GenericDAO<T extends BankObject> {
	
	public boolean save(String filename, T obj) {

		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(obj, new File(filename));
			return true;
		} catch (JAXBException e) {
			return false;
		}
		
	}
	
	public T get(String filename, T obj){
		
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			T returnObj = (T)unmarshaller.unmarshal(new File(filename));
			return returnObj;
		} catch (JAXBException e) {
			return null;
		}catch(NullPointerException e){	//Remember Catch blocks go Narrow to Broad, try switching Catch Exception and JAXBException
			return null;
		}catch(Exception e){
			return null;
		}
		
	}
	

}
