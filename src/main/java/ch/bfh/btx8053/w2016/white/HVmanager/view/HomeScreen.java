package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
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
	private HorizontalLayout logo;
	private ThemeResource resource;
	private Image image;
	private GridLayout gridLayout;
	private Button clientBtn;
	private Button helpBtn;
	private Button statsBtn;
	private Button facturingBtn;
	private Button settingsBtn;
	private Button appointmentsBtn;
	private Button subsituteBtn;

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
	public HomeScreen(MyUI myui) {

		this.logo = new HorizontalLayout();

		/// Loading HV Manager Logo ///
		this.resource = new ThemeResource("HVmanagerLogoNeu.png");
		this.image = new Image("", resource);

		logo.addComponent(image);
		logo.setComponentAlignment(image, ALIGNMENT_DEFAULT);

		/// Creating Home Screen Grid Layout ///
		this.gridLayout = new GridLayout(2, 4);
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

		this.facturingBtn = new Button(FontAwesome.MONEY);
		facturingBtn.setWidth(BUTTONWIDTH);
		facturingBtn.setHeight(BUTTONHEIGHT);
		
		this.appointmentsBtn = new Button(FontAwesome.CALENDAR);
		appointmentsBtn.setWidth(BUTTONWIDTH);
		appointmentsBtn.setHeight(BUTTONHEIGHT);
		
		this.subsituteBtn = new Button(FontAwesome.LIST);
		subsituteBtn.setWidth(BUTTONWIDTH);
		subsituteBtn.setHeight(BUTTONHEIGHT);

		gridLayout.addComponents(clientBtn, facturingBtn, statsBtn, helpBtn, settingsBtn, appointmentsBtn, subsituteBtn);

		clientBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.PATIENTDIRECTORY);
		});

		helpBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.HELP);
		});

		statsBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.STATS);
		});

		facturingBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.FACTURING);
		});

		// Adding components to root
		this.addComponents(logo, gridLayout);
		this.setWidth(WIDTH);;;
		this.setHeight(HEIGHT);
		//this.setSizeFull();
		this.setMargin(true);
		this.setSpacing(true);
	}
}