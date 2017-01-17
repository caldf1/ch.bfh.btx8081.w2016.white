package ch.bfh.btx8053.w2016.white.HVmanager.view;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;



/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */

/**
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class MyUI extends UI {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 	
	
	private Navigator navigator; //= new Navigator(this, this);
//	public static final String CLIENT_DIRECTORY = "PATIENTDIRECTORY";
//	public static final String ADDING_NEW_CLIENT = "ADDINGNEWCLIENT";
//	public static final String SINGLE_CLIENT_OVERVIEW = "PATIENTOVERVIEW";
//	public static final String HOMESCREEN = "";
//	public static final String CLIENT_NETWORK = "CLIENTNETWORK";
//	public static final String HELP = "HELP";
//	public static final String STATISTICS = "STATS";
//	public static final String BILLING = "BILLING";
//	public static final String MY_APPOINTMENTS = "MYAPPOINTMENTS";
//	public static final String SUBSTITUTE = "SUBSTITUTE";
//	public static final String TEST_VIEW = "TESTVIEW";

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		navigator = new Navigator(this, this);
		
		navigator.addView("", new HomeScreen(this));
		navigator.addView("ClientDirectory", new ClientDirectory(this));
		navigator.addView("AddingNewClient", new AddingNewClient(this));
		navigator.addView("SingleClientOverview", new SingleClientOverview(this));
		navigator.addView("ClientNetwork", new ClientNetwork(this));
		navigator.addView("Help", new Help(this));
		navigator.addView("Statistics", new Statistics(this));
		navigator.addView("Billing", new Billing(this));
		navigator.addView("MyAppointments", new MyAppointments(this));
		navigator.addView("Substitute", new Substitute(this));
		//navigator.addView("TestView", new TestView(this));
		
	}

	/**
	 * 
	 */
	public Navigator getNavigator() {
		return navigator;
	}

	/**
	 * 
	 */
	@Override
	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

	/**
	 * 
	 *
	 */
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

	}
	
	public MyUI getMyUI(){
		return this;
	}
	
	/**
	 * 
	 * @param navigateType
	 * @return
	 */
	public String setNavigaterString(NavigateType navigateType){
		
		
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