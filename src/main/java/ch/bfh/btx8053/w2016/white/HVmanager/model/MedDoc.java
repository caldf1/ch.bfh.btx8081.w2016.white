package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.awt.Desktop;
import java.io.File;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import ch.bfh.btx8053.w2016.white.HVmanager.util.HVmanagerException;
import ch.bfh.btx8053.w2016.white.HVmanager.util.Validater;

/**
 * Attach med. documents, saves the filename and the storage-location-pathname. 
 * It's a draft.
 * 
 * @author: umern1, caldf1, nedot1
 */
@Entity
public class MedDoc {

/*==============================================
 *    Attributes
 *==============================================
 */ 
	@Id
	@GeneratedValue
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
	 * for persistance
	 * 
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
	 *  for persistance
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
	 * Gets the DokuID
	 * 
	 * @return dokuID as int
	 */
	public int getDokuID() {
		return dokuID;
	}


	/**
	 * 
	 * Gets Date of creation
	 * 
	 * @return creationDate as Date
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	
	
	/**
	 * 
	 * Gets date of last change
	 * 
	 * @return dateLastChange as a Date
	 */
	public Date getDateLastChange(){
		return dateLastChange;
	}

	
	/**
	 * 
	 * Gets the Filename
	 * 
	 * @return filename as a String
	 */
	public String getFilename(){
		return filename;
	}
	
	
	/**
	 * 
	 * Gets the storage Location
	 * 
	 * @return pathname as a String
	 */
	public String getStorageLocation(){
		return pathname;
	}
	
	/**
	 * 
	 * Gets the MedDocFile
	 * 
	 * @return medDocFile as a File
	 */
	public File getMedDocFile(){
		return medDocFile;
	}

	
	/**
	 * 
	 * Creates and returns a String of all MedDoc elements except the file itself.
	 * 
	 * @param dokuID as int
	 * @param creationDate as Date
	 * @param dateLastChange as Date
	 * @param filename as a String
	 * @param pathname as a String
	 * 
	 * @return String
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
	 * Sets the Filename and updates dateLastChange
	 * 
	 * @param Filename as a String
	 */
	public void setFilename(String newFilename){
		this.filename = newFilename;
		this.dateLastChange = new Date();
	
	}

	/**
	 * 
	 * Sets a new Storage Location
	 * 
	 * @param newStorageLocationpath as a String
	 */
	public void setStorageLocation(String newStorageLocationpath) throws HVmanagerException{
			
			Validater.validateMedDocFile(newStorageLocationpath);
			this.pathname = newStorageLocationpath;
			this.medDocFile = new File(newStorageLocationpath);
			this.dateLastChange = new Date();
	}

	/** Task for sprint 4. TODO
	 * 
	 * Should open files on Desktop
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

