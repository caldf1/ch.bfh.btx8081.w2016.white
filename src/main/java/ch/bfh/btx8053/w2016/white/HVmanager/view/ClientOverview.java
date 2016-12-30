package ch.bfh.btx8053.w2016.white.HVmanager.view;

/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class ClientOverview {
	private String cID;
	private String fName;
	private String lName;
	private String bday;
	private String place;
	private String[] dataList = new String[5];
	
	public ClientOverview(String cID, String fName, String lName, String bday, String place) {
		this.cID = cID;
		this.fName = fName;
		this.lName = lName;
		this.bday = bday;
		this.place = place;
		dataList[0] = cID;
		dataList[1] = fName;
		dataList[2] = lName;
		dataList[3] = bday;
		dataList[4] = place;
	}

	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
	}
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String[] getDataList(){
		return this.dataList;
	}
	
}
	
