package ch.bfh.btx8053.w2016.white.HVmanager.view;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

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
 * @author degeg1
 * @version 0.1
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class MyUI extends UI {

	private Navigator navigator;
	public static final String PATIENTDIRECTORY = "PATIENTDIRECTORY";
	public static final String ADDINGNEWCLIENT = "ADDINGNEWCLIENT";
	public static final String PATIENTOVERVIEW = "PATIENTOVERVIEW";
	public static final String HOMESCREEN = "";
	public static final String CLIENTNETWORK = "CLIENTNETWORK";
	public static final String HELP = "HELP";
	public static final String STATS = "STATS";
	public static final String FACTURING = "FACTURING";

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		navigator = new Navigator(this, this);

		navigator.addView("", new HomeScreen(this));
		navigator.addView(PATIENTDIRECTORY, new ClientDirectory(this));
		navigator.addView(ADDINGNEWCLIENT, new AddingNewClient(this));
		navigator.addView(PATIENTOVERVIEW, new SingleClientOverview(this));
		navigator.addView(CLIENTNETWORK, new ClientNetwork(this));
		navigator.addView(HELP, new Help(this));
		navigator.addView(STATS, new Statistics(this));
		navigator.addView(FACTURING, new Facturing(this));
		
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
}