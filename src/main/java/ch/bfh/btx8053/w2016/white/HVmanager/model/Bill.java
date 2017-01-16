package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;

/**
 * 
 * @author: umern11, caldf1
 */

public class Bill {
		
		
	/*==============================================
	 *    Attributes
	 *==============================================
	 */ 
		
		private String billDate = null;
		private int billID = 0; // via DB erzeugen
		private int caseID = 0;
		private int caregiverID = 0;
		private String description = null;
		private ArrayList<BillPosition> billPositions = new ArrayList<>();
		private String billTotalValue = "0.0";
		

	/*==============================================
	 *    Constructor
	 *==============================================
	 */

		/**
		 * 
		 */
		public Bill(){
			
		}

		
		/**
		 * 
		 * @param billDate
		 * @param caseID
		 * @param caregiverID
		 * @param description
		 */
		public Bill(String billDate, int caseID, int caregiverID, String description) {

			this.billDate = billDate;
			this.caseID = caseID;
			this.caregiverID = caregiverID;
		    this.description = description;
		}


		
		/*==============================================
		 *    GETTER
		 *==============================================
		 */


		/**
		 * 
		 * @return
		 */
		public String getBillDate() {
			return billDate;
		}


		/**
		 * 
		 * @return
		 */
		public int getBillID() {
			return billID;
		}


		/**
		 * Rechnungsempfänger: Client kann über Fallnummer gefunden werden, Rechnung pro Fall
		 * @return
		 */
		public int getCaseID() {
			return caseID;
		}


		/**
		 * Rechnungssteller
		 * @return
		 */
		public int getCaregiverID() {
			return caregiverID;
		}


		/**
		 * 
		 * @return
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * 
		 * @return
		 */
		public String getBillTotalValue(){
			
			return  billTotalValue; 
		}
		
		
		/**
		 * 
		 * @return
		 */
		public ArrayList<BillPosition> getBillPositions(){
			return billPositions;
		}


	/**
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
	 * 
	 * @param billPosition
	 */
	public void addBillPosition(BillPosition billPosition){
		
		additionToBillTotalValue(billPosition.getPaymentValue());
		this.billPositions.add(billPosition);
		
	}
	
	/**
	 * TODO
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
	 * 
	 * @param billDate
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}


	/**
	 * 
	 * @param caseID
	 */
	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}


	/**
	 * 
	 * @param caregiverID
	 */
	public void setCaregiverID(int caregiverID) {
		this.caregiverID = caregiverID;
	}


	/**
	 * 
	 * @param description
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



