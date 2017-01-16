package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * 
 * @author caf1
 *
 */
public class BillPosition {
	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	private static int id = 1;
	
	private int paymentID = 0;
	private String paymentName = null;
	private double paymentValue = 0;
	private int indexBillPosition = 0;
	
	
/*==============================================
 *    Constructor
 *==============================================
 */
	
	/**
	 *  for Persistence
	 */
	public BillPosition(){
		
	}
	
	/**
	 * 
	 * @param paymentName
	 * @param paymentValue
	 */
	public BillPosition(String paymentName, double paymentValue){
		
		this.paymentName = paymentName;
		this.paymentValue = paymentValue;	
		this.paymentID = id;
		id++;
	}
	
/*==============================================
 *    Getter
 *==============================================
 */
	
	/**
	 * 
	 * @return
	 */
	public int getPaymentID(){
		return paymentID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPaymentName(){
		return paymentName;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getPaymentValue(){
		return paymentValue;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "\nLeistungsnummer: " + paymentID + "\nLeistungsbeschreibung: " + paymentName
				+ "\nPreis: CHF " + String.format("%.2f", paymentValue);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIndex(){
		return indexBillPosition;
	}
	
	
/*==============================================
 *    Setter
 *==============================================
 */
	
	/**
	 * 
	 * @param newPaymentName
	 */
	public void setPaymentName(String newPaymentName){
		this.paymentName = newPaymentName;
	}
	
	/**
	 * 
	 * @param newPaymentValue
	 */
	public void setPaymentValue(double newPaymentValue){
		this.paymentValue = newPaymentValue;
	}
	
	
	/**
	 * 
	 * @param indexBillPosition
	 */
	public void setIndex(int indexBillPosition){
		this.indexBillPosition = indexBillPosition;
	}

	
/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + indexBillPosition;
		result = prime * result + paymentID;
		result = prime * result + ((paymentName == null) ? 0 : paymentName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(paymentValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BillPosition other = (BillPosition) obj;
		if (indexBillPosition != other.indexBillPosition)
			return false;
		if (paymentID != other.paymentID)
			return false;
		if (paymentName == null) {
			if (other.paymentName != null)
				return false;
		} else if (!paymentName.equals(other.paymentName))
			return false;
		if (Double.doubleToLongBits(paymentValue) != Double.doubleToLongBits(other.paymentValue))
			return false;
		return true;
	}

}
