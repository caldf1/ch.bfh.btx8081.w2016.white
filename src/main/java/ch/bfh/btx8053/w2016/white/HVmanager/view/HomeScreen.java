package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class HomeScreen extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7098205660635338078L;
	private VerticalLayout vertical = new VerticalLayout();
	private HorizontalLayout logo = new HorizontalLayout();
	private ThemeResource resource;
	private Image image;
	private GridLayout gridLayout;
	private Button clientBtn;
	private Button helpBtn;
	private Button statsBtn;
	private Button billingBtn;
	private Button myAppointmentsBtn;
	private Button substituteBtn;

	///////// VIEW SIZE /////////
	final static String WIDTH= "280";
	final static String HEIGHT= "570";
	
	final static String BUTTONWIDTH = "85";
	final static String BUTTONHEIGHT = "60";
	///////////////////////////////////////////
	
	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param myui
	 */
	@SuppressWarnings("static-access")
	public HomeScreen(MyUI myui) {

		//this.logo = new HorizontalLayout();

		/// Loading HV Manager Logo ///
		this.resource = new ThemeResource("HVmanagerLogoNeu.png");
		this.image = new Image("", resource);

		//vertical.addComponent(image);
		//vertical.setComponentAlignment(image, Alignment.TOP_CENTER);;
		logo.addComponent(image);
		logo.setComponentAlignment(image, ALIGNMENT_DEFAULT);

		vertical.addComponent(logo);
		/// Creating Home Screen Grid Layout ///
				this.gridLayout = new GridLayout(2, 3);
				gridLayout.setSpacing(true);

				// Creating menu buttons
				this.clientBtn = new Button(FontAwesome.USERS);
				clientBtn.setWidth(BUTTONWIDTH);
				clientBtn.setHeight(BUTTONHEIGHT);

				this.helpBtn = new Button(FontAwesome.QUESTION);
				helpBtn.setWidth(BUTTONWIDTH);
				helpBtn.setHeight(BUTTONHEIGHT);

				this.statsBtn = new Button(FontAwesome.BAR_CHART);
				statsBtn.setWidth(BUTTONWIDTH);
				statsBtn.setHeight(BUTTONHEIGHT);

				this.billingBtn = new Button(FontAwesome.MONEY);
				billingBtn.setWidth(BUTTONWIDTH);
				billingBtn.setHeight(BUTTONHEIGHT);
				
				this.myAppointmentsBtn = new Button(FontAwesome.CALENDAR); 
				myAppointmentsBtn.setWidth(BUTTONWIDTH);
				myAppointmentsBtn.setHeight(BUTTONHEIGHT);
				
				this.substituteBtn = new Button(FontAwesome.LIST);
				substituteBtn.setWidth(BUTTONWIDTH);
				substituteBtn.setHeight(BUTTONHEIGHT);

				gridLayout.addComponents(clientBtn, billingBtn, statsBtn, helpBtn, myAppointmentsBtn, substituteBtn);

				clientBtn.addClickListener(e -> {
					myui.getNavigator().navigateTo(myui.CLIENT_DIRECTORY);
				});

				helpBtn.addClickListener(e -> {
					myui.getNavigator().navigateTo(myui.HELP);
				});

				statsBtn.addClickListener(e -> {
					myui.getNavigator().navigateTo(myui.STATISTICS);
				});

				billingBtn.addClickListener(e -> {
					myui.getNavigator().navigateTo(myui.BILLING);
				});
				
				myAppointmentsBtn.addClickListener(e -> {
					myui.getNavigator().navigateTo(myui.MY_APPOINTMENTS);
				});
				
				substituteBtn.addClickListener(e -> {
					myui.getNavigator().navigateTo(myui.SUBSTITUTE);
				});

				vertical.addComponent(gridLayout);
				///// Root /////
				this.addComponents(vertical);
				//this.addComponents(logo, gridLayout);
				this.setWidth(WIDTH);;;
				this.setHeight(HEIGHT);
				
				this.setMargin(true);
				this.setSpacing(true);
	}
}