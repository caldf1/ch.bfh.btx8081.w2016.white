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

}
