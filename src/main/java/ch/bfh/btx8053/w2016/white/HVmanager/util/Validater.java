package ch.bfh.btx8053.w2016.white.HVmanager.util;

import java.io.File;

import ch.bfh.btx8053.w2016.white.HVmanager.model.MedDoc;


/**
 * Validate User-Inputs.
 * Task for Sprint 4.
 * 
 * @author caldf1
 *
 */
public abstract class Validater {

	
	/** TODO
	 * 
	 * Validate if the String Date has the format: dd.mm.yyyy.
	 * And validate if the Characters are digits and points.
	 * 
	 * @param date
	 * @throws Exception
	 */
	public static void validateDate(String date) throws HVmanagerException{
		
		try {
			// Sprint 4
		} catch (Exception e) {
			throw new HVmanagerException("wrong date format, please enter the format like: dd.mm.yyyy");
		}
		
	}
	
	
	/** TODO
	 * 
	 * Validate if the String zip has exactly four digits.
	 * 
	 * @param zip
	 * @throws Exception
	 */
	public static void validateSwissZip(String zip) throws HVmanagerException {

		try {

			if (zip.trim().length() == 4) {
				Integer.parseInt(zip.trim());
			} else {
				throw new HVmanagerException(
						"\nValidated zip: " + zip + "\ninvalide format, please enter four digits like 1234");
			}

		} catch (Exception e) {
			throw new HVmanagerException(
					"\nValidated zip: " + zip + "\ninvalide format, please enter four digits like 1234");
		}
	}
	
	
	/** TODO
	 * 
	 * Validate the MedDocFile with the pathname as Input.
	 * 
	 * @param storageLocationPathname
	 * @throws Exception
	 */
	public static void validateMedDocFile(String storageLocationPathname) throws HVmanagerException{
		
		try {
			// Sprint 4
		} catch (Exception e) {
			throw new HVmanagerException("file not found, controlle filename");
		}
	}
	
	
	/** TODO
	 * 
	 * Validate the MedDocFile with the MedDoc-Object as Input.
	 * 
	 * @param medDocObject
	 * @throws Exception
	 */
	public static void validateMedDocFile(MedDoc medDocObject) throws HVmanagerException {

		try {
			// Sprint 4
		} catch (Exception e) {
			throw new HVmanagerException("file not found, controlle filename");
		}
	}
	
	
	/** TODO
	 * 
	 * Validate the MedDocFile with the File as Input.
	 * 
	 * @param medDocFile
	 * @throws Exception
	 */
	public static void validateMedDocFile(File medDocFile) throws HVmanagerException {

		try {
			// Sprint 4
		} catch (Exception e) {
			throw new HVmanagerException("file not found, controlle filename");
		}
	}
	

	
}
