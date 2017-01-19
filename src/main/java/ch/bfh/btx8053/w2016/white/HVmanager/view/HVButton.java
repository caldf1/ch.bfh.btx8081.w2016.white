package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;

import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

/**
 * Task for a later Sprint. 
 * Target: create Buttons once inkl. addClickListener(), and reuse Buttons
 * 
 * @author caldf1
 * @version 1.0
 */
public class HVButton {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	

	//private static final long serialVersionUID = -705979512237758783L;
	private String navigateString = null;
	private Button button = null;
	//private boolean homescreen = false;
	

	final static String BUTTONWIDTH = "85";
	final static String BUTTONHEIGHT = "60";
	
	
	
/*==============================================
 *    Constructor
 *==============================================
 */
	
	/**
	 * 
	 * @param fontAwesome
	 * @param navigateType
	 */
	public HVButton(FontAwesome fontAwesome, NavigateType navigateType){
		setNavigate(navigateType);
		createButton(fontAwesome);	
	}
	
	/**
	 * 
	 * @param fontAwesome
	 * @param navigateType
	 * @param homescreen
	 */
	public HVButton(FontAwesome fontAwesome, NavigateType navigateType, boolean homescreen){
		setNavigate(navigateType);
		createButton(fontAwesome);
		
		if(homescreen == true){
			//this.homescreen = true;
			setButtonSizeHomescreen();
		}
	}
	
	/**
	 * 
	 * @param fontAwesome
	 * @param navigateType
	 * @param homescreen
	 */
	public HVButton(FontAwesome fontAwesome, NavigateType navigateType, boolean homescreen, MyUI myui){
		setNavigate(navigateType);
		createButton(fontAwesome);
		
		if(homescreen == true){
			//this.homescreen = true;
			setButtonSizeHomescreen();
		}
		
		button.addClickListener(e -> {
			myui.getNavigator().navigateTo(navigateString);	
			
		});
		
	}
	
	
/*==============================================
 *    Getter
 *==============================================
 */ 
	
	/**
	 * 
	 * @return
	 */
	public Button getHVButton(){
		return button;
	}
	
	public String getNavigateString(){
		return navigateString;
	}
	
	
	
/*==============================================
 *    Setter
 *==============================================
 */ 
	
	
	public void addButtonToClickListender(MyUI myui){
		
		button.addClickListener(e -> {
			myui.getNavigator().navigateTo(navigateString);	
			
		});
	}
	

	
/*==============================================
 *    Helper
 *==============================================
 */ 
	
	/**
	 * 
	 */
	private void setButtonSizeHomescreen(){
		this.button.setWidth(BUTTONWIDTH);
		this.button.setHeight(BUTTONHEIGHT);
	}
	
	
	/**
	 * 
	 * @param fontAwesome
	 * @return
	 */
	private void createButton(FontAwesome fontAwesome){
		this.button = new Button(fontAwesome);
		
	}
	
	
	/**
	 * 
	 * @param navigateType
	 * @return
	 */
	private String setNavigate(NavigateType navigateType){
		
		
		 if (navigateType.equals(NavigateType.ADDING_NEW_CLIENT)) {
			return "AddingNewClient";
		}if (navigateType.equals(NavigateType.BILLING)) {
			return "Billing";
		}if (navigateType.equals(NavigateType.CLIENT_DIRECTORY)) {
			return "ClientDirectory";
		}if (navigateType.equals(NavigateType.CLIENT_NETWORK)) {
			return "ClientNetwork";
		}if (navigateType.equals(NavigateType.HELP)) {
			return "Help";
		}if (navigateType.equals(NavigateType.HOMESCREEN)) {
			return "";
		}if (navigateType.equals(NavigateType.MY_APPOINTMENTS)) {
			return "MyAppointments";
		}if (navigateType.equals(NavigateType.SINGLE_CLIENT_OVERVIEW)) {
			return "SingleClientOverview";
		}if (navigateType.equals(NavigateType.STATISTICS)) {
			return "Statistics";
		}if (navigateType.equals(NavigateType.SUBSTITUTE)) {
			return "Substitute";
		}if (navigateType.equals(NavigateType.TEST_VIEW)) {
			return "TestView";
		}	else {
			return "";
		}
		
	}
	
}
