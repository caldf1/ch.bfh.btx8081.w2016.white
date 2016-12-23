package ch.bfh.btx8053.w2016.white.HVmanager.view;

/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class ClientOverview {
	private String fName;
	private String lName;
	private String bday;
	private String place;
	private String[] dataList = new String[4];
	
	public ClientOverview(String fName, String lName, String bday, String place) {

		this.fName = fName;
		this.lName = lName;
		this.bday = bday;
		this.place = place;
		dataList[0] = fName;
		dataList[1] = lName;
		dataList[2] = bday;
		dataList[3] = place;
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
	
