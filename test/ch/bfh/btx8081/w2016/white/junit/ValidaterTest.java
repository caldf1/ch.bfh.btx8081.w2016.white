package ch.bfh.btx8081.w2016.white.junit;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.MedDoc;
import ch.bfh.btx8053.w2016.white.HVmanager.util.HVmanagerException;
import ch.bfh.btx8053.w2016.white.HVmanager.util.Validater;

/**
 * Tests the Validater class.
 * 
 * @author caldf1
 *
 */
public class ValidaterTest {

	
	@Test // not really implemented
	public void validateDateTesttrue() throws HVmanagerException{
		//fail("Not yet implemented");
		Validater.validateDate("12.12.2012");
	}
	
	@Ignore //(expected = HVmanagerException.class)
	public void validateDateTestfalse1() throws HVmanagerException{
		//fail("Not yet implemented");
		Validater.validateDate("2012.12.12");
	}
	

	@Test
	public void validateSwissZipTesttrue() throws HVmanagerException {
		
		String zip1 = " 4321 ";
		String zip2 = "5555";		
		Validater.validateSwissZip(zip1);
		Validater.validateSwissZip(zip2);
	}
	
	
	@Test (expected = HVmanagerException.class)
	public void validateSwissZipTestfalse1() throws HVmanagerException {
		
		String zip = "";
		Validater.validateSwissZip(zip);	
	}
	
	
	@Test (expected = HVmanagerException.class)
	public void validateSwissZipTestfalse2() throws HVmanagerException {
		
		Validater.validateSwissZip("ZH-3525");
		
		String zip = "12";
		Validater.validateSwissZip(zip);
	}
	
	
	@Test (expected = HVmanagerException.class)
	public void validateSwissZipTestfalse3() throws HVmanagerException {
		
		String zip = "ZH-4356";
		Validater.validateSwissZip(zip);	
	}
	

	
	
	@Test // not really implemented
	public void validateMedDocFileTesttrue() throws HVmanagerException{
		//fail("Not yet implemented");
		
		Validater.validateMedDocFile(new File(""));		
		Validater.validateMedDocFile(new MedDoc());			
		Validater.validateMedDocFile("");
	}
	
	
	@Ignore //(expected = HVmanagerException.class)
	public void validateMedDocFileTestfalse1() throws HVmanagerException{
		//fail("Not yet implemented");		
		Validater.validateMedDocFile(new File(""));			
	}
	
	@Ignore //(expected = HVmanagerException.class)
	public void validateMedDocFileTestfalse2() throws HVmanagerException{
		//fail("Not yet implemented");	
		Validater.validateMedDocFile(new MedDoc());			
	}
	
	
	@Ignore //(expected = HVmanagerException.class)
	public void validateMedDocFileTestfalse3() throws HVmanagerException{
		//fail("Not yet implemented");		
		Validater.validateMedDocFile("");
	}
	

}

