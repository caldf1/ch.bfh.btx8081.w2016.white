package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.awt.Desktop;
import java.io.File;
import java.util.Date;

import ch.bfh.btx8053.w2016.white.HVmanager.util.HVmanagerException;
import ch.bfh.btx8053.w2016.white.HVmanager.util.Validater;

/**
 * 
 * @author: umern1, caldf1
 */
public class MedDoc {

/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	private int dokuID = 0; // immutable
	private Date creationDate = null;
	private Date dateLastChange = null;
	private File medDocFile = null;
	private String filename = null;
	private String pathname = null;
	

/*==============================================
 *    Constructor
 *==============================================
 */
	
	/**
	 *  for persistence
	 */
	public MedDoc(){
		
	}
	
	/**
	 * 
	 * @param dokuID
	 * @param date
	 * @param filename
	 * @param storageLocation
	 * @throws Exception
	 */
	public MedDoc(String filename, String storageLocationPathname) throws RuntimeException{

		Validater.validateMedDocFile(storageLocationPathname);
		
		this.creationDate = new Date();
		this.dateLastChange = this.creationDate;
		this.filename = filename;
		this.pathname = storageLocationPathname;
		medDocFile = new File(storageLocationPathname); 
		
		
	}
	
	
	/**
	 * 
	 * @param medDocFile
	 * @throws Exception
	 */
	public MedDoc(File medDocFile) throws Exception{
		
		Validater.validateMedDocFile(medDocFile);
		this.medDocFile = medDocFile;
	}

	
/*==============================================
 *    GETTER
 *==============================================
 */
	
	
	/**
	 * 
	 * @return
	 */
	public int getDokuID() {
		return dokuID;
	}


	/**
	 * 
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Date getDateLastChange(){
		return dateLastChange;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getFilename(){
		return filename;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getStorageLocation(){
		return pathname;
	}
	
	/**
	 * 
	 * @return
	 */
	public File getMedDocFile(){
		return medDocFile;
	}

	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "\nID Medizinisches Dokument: " + dokuID + "\nErfassungsdatum: " + creationDate + "\nLetzte Änderung: "
				+ dateLastChange + "\nDateiname: " + filename + "\nSpeicherort: " + pathname;
	}

	
/*==============================================
 *    SETTER
 *==============================================
 */
		
	
	/**
	 * 
	 * @param newFilename
	 * @param dateToday
	 * @throws Exception
	 */
	public void setFilename(String newFilename){
		this.filename = newFilename;
		this.dateLastChange = new Date();
	
	}

	/**
	 * 
	 * @param newStorageLocationpath
	 * @throws HVmanagerException
	 */
	public void setStorageLocation(String newStorageLocationpath) throws HVmanagerException{
			
			Validater.validateMedDocFile(newStorageLocationpath);
			this.pathname = newStorageLocationpath;
			this.medDocFile = new File(newStorageLocationpath);
			this.dateLastChange = new Date();
	}

	/** Task for sprint 4. TODO
	 * 
	 * @throws HVmanagerException
	 */
	public void open() throws HVmanagerException{
		
		try {
			Desktop desktop = Desktop.getDesktop();
		    if(this.medDocFile.exists()) desktop.open(this.medDocFile);
		} catch (Exception e) {
			throw new HVmanagerException("can not open");
		}		
	}

/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((dateLastChange == null) ? 0 : dateLastChange.hashCode());
		result = prime * result + dokuID;
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((medDocFile == null) ? 0 : medDocFile.hashCode());
		result = prime * result + ((pathname == null) ? 0 : pathname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedDoc other = (MedDoc) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (dateLastChange == null) {
			if (other.dateLastChange != null)
				return false;
		} else if (!dateLastChange.equals(other.dateLastChange))
			return false;
		if (dokuID != other.dokuID)
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (medDocFile == null) {
			if (other.medDocFile != null)
				return false;
		} else if (!medDocFile.equals(other.medDocFile))
			return false;
		if (pathname == null) {
			if (other.pathname != null)
				return false;
		} else if (!pathname.equals(other.pathname))
			return false;
		return true;
	}
	
}

