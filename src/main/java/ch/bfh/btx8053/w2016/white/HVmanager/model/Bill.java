package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * This class creates a bill for a case
 * @author: umern11, caldf1, nallm1
 */
@Entity
public class Bill {
		
		
/*==============================================
 *    Attributes
 *==============================================
 */ 
		private static int id = 38784;
		
		private String billDate = null;
		@Id
		@GeneratedValue
		private int billID = 0;
		@OneToOne
		private int caseID = 0;
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="CaregiverID")
		private int caregiverID = 0;
		private String description = null;
		@OneToMany(mappedBy="bill")
		private List<BillPosition> billPositions = new ArrayList<>();
		private String billTotalValue = "0.0";
		

/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * for persistence
	 */
	public Bill() {

	}

	/**
	 * Creates a new bill with 
	 * 
	 * @param billDate as a string
	 * @param caseID as an int
	 * @param caregiverID as an int
	 * @param description as a string
	 */
	public Bill(String billDate, int caseID, int caregiverID, String description) {

		this.billDate = billDate;
		this.caseID = caseID;
		this.caregiverID = caregiverID;
		this.description = description;
		
		billID = id;
		id = id + 435;
	}
		
/*==============================================
 *    GETTER
 *==============================================
 */


	/**
	 * 
	 * @return the bill date
	 */
	public String getBillDate() {
		return billDate;
	}


	/**
	 * 
	 * @return the bill ID
	 */
	public int getBillID() {
		return billID;
	}


	/**
	 * 
	 * @return the case ID
	 */
	public int getCaseID() {
		return caseID;
	}


	/**
	 * 
	 * @return the caregiver ID
	 */
	public int getCaregiverID() {
		return caregiverID;
	}


	/**
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return the total bill value
	 */
	public String getBillTotalValue(){
		
		return  billTotalValue; 
	}
	
	
	/**
	 * 
	 * @return the bill position
	 */
	public ArrayList<BillPosition> getBillPositions(){
		return (ArrayList<BillPosition>) billPositions;
	}


	/**
	 * 
	 * example output:<br><br>
	 * Rechnung:<br> 
	 * Rechnungsdatum: 11.01.2017<br>
	 * Rechnungsnummer: 38784<br>
	 * Fallnummer: 100<br>
	 * Rechnungssteller: 12<br>
	 * Bemerkung: Gespräch 05.01.2017<br>
	 * Leistungen: [<br>
	 * Leistungsnummer: 1<br>
	 * Leistungsbeschreibung: Leistung 1<br>
	 * Preis: CHF 10.50,<br> 
	 * Leistungsnummer: 2<br>
	 * Leistungsbeschreibung: Leistung 2<br>
	 * Preis: CHF 9.50]<br>
	 * Rechnungstotal: 20.00<br>
	 * Total4: 10.50<br>
	 * 
	 */
	@Override
	public String toString() {
		return "\nRechnung: \nRechnungsdatum: " + billDate + "\nRechnungsnummer: " + billID + "\nFallnummer: " + caseID
				+ "\nRechnungssteller: " + caregiverID + "\nBemerkung: " + description + "\nLeistungen: "
				+ billPositions + "\nRechnungstotal: " + billTotalValue;
	}


/*==============================================
 *    SETTER
 *==============================================
 */
	
	 
	/**
	 * Sets the bill position from a bill
	 * 
	 * @param billPosition 
	 */
	public void addBillPosition(BillPosition billPosition){
		
		additionToBillTotalValue(billPosition.getPaymentValue());
		this.billPositions.add(billPosition);
		
	}
	
	/**
	 * Sets the payment ID after removing the bill position
	 * 
	 * @param paymentID 
	 */
	public void removeBillPosition(BillPosition billPosition) {

		subtractionFromBillTotalValue(billPosition.getPaymentValue());
		
		this.billPositions.remove(billPosition);

	}
	
	
	/*
	 * Addiert den Wert zum Rg-Total.
	 */
	private void additionToBillTotalValue(Double paymentValue){
		Double oldTotal = Double.parseDouble(this.billTotalValue);
		Double newTotal = oldTotal + paymentValue;
		
		this.billTotalValue = String.format("%.2f", newTotal);
	}
	
	/*
	 * Substrahiert den Wert vom Rg-Total
	 */
	private void subtractionFromBillTotalValue(Double paymentValue){
		
		Double oldTotal = Double.parseDouble(this.billTotalValue);
		Double newTotal = oldTotal - paymentValue;
		
		this.billTotalValue = String.format("%.2f", newTotal);
	}
	
	/**
	 * Sets the bill date for a bill
	 * 
	 * @param billDate as a string
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}


	/**
	 * Sets the case ID for a bill
	 * 
	 * @param caseID as an int
	 */
	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}


	/**
	 * Sets the caregiver ID for a bill
	 * 
	 * @param caregiverID as an int
	 */
	public void setCaregiverID(int caregiverID) {
		this.caregiverID = caregiverID;
	}


	/**
	 * Sets the despription for a bil
	 * 
	 * @param description as a string
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + billID;
		result = prime * result + ((billPositions == null) ? 0 : billPositions.hashCode());
		result = prime * result + ((billTotalValue == null) ? 0 : billTotalValue.hashCode());
		result = prime * result + caregiverID;
		result = prime * result + caseID;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Bill other = (Bill) obj;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (billID != other.billID)
			return false;
		if (billPositions == null) {
			if (other.billPositions != null)
				return false;
		} else if (!billPositions.equals(other.billPositions))
			return false;
		if (billTotalValue == null) {
			if (other.billTotalValue != null)
				return false;
		} else if (!billTotalValue.equals(other.billTotalValue))
			return false;
		if (caregiverID != other.caregiverID)
			return false;
		if (caseID != other.caseID)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

}



