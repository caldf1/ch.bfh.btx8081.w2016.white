package ch.bfh.btx8053.w2016.white.HVmanager.view;

/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class Client {
	private String cID;
	private String name;
	private String lName;
	private String address;
	private String bday;
	private int ZIP;
	private String city;
	private String phone1;
	private String phone2;
	private String[] dataList = new String[9];

	/**
	 * @param cID
	 * @param name
	 * @param lName
	 * @param address
	 * @param bday
	 * @param zIP
	 * @param city
	 * @param phone1
	 * @param phone2
	 */
	public Client(String cID, String name, String lName, String address, String bday, int zIP, String city,
			String phone1, String phone2) {
		this.cID = cID;
		this.name = name;
		this.lName = lName;
		this.address = address;
		this.bday = bday;
		ZIP = zIP;
		this.city = city;
		this.phone1 = phone1;
		this.phone2 = phone2;
		dataList[0] = cID;
		dataList[1] = name;
		dataList[2] = lName;
		dataList[3] = address;
		dataList[4] = ZIP + "";
		dataList[5] = bday;
		dataList[6] = city;
		dataList[7] = phone1;
		dataList[8] = phone2;

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public int getZIP() {
		return ZIP;
	}

	public void setZIP(int zIP) {
		ZIP = zIP;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String[] getDataList() {
		return this.dataList;
	}

}
