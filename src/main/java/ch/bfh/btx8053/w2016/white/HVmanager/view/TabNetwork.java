package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class TabNetwork extends VerticalLayout implements View {
	
	private AbsoluteLayout absolute;
	private VerticalLayout dynamicContent;
	private VerticalLayout cID;
	private VerticalLayout cName;
	private VerticalLayout cFirstName;
	private HorizontalLayout clientDetails;
	private Label clientId;
	private Label clientLastname;
	private Label clientFirstname;
	private Button socialInsuranceBtn;
	private Button doctorBtn;
	private Button healthInsBtn;
	private Button relativesBtn;
	private ThemeResource resource;
	private Image image;

	///////// VIEW SIZE /////////
	final static String WIDTH = "280";
	final static String HEIGHT = "570";
	/////////////////////////////////////

	/**
	 * 
	 */
	public void openNetwork() {
		new TabNetwork(null);
	}

	/**
	 * 
	 */
	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param patientOverview
	 */
	public TabNetwork(SingleClientOverview patientOverview) {

		this.removeAllComponents();

		this.absolute = new AbsoluteLayout();
		absolute.setWidth("581px");
		absolute.setHeight("560px");

		this.dynamicContent = new VerticalLayout();
		dynamicContent.setSizeFull();

		// Client header
		this.clientDetails = new HorizontalLayout();
		clientDetails.setSpacing(true);

		this.cID = new VerticalLayout();
		this.cName = new VerticalLayout();
		this.cFirstName = new VerticalLayout();

		this.clientId = new Label("cID: 10079");
		this.clientLastname = new Label("Muster");
		this.clientFirstname = new Label("Hans");

		cID.addComponent(clientId);
		cName.addComponent(clientLastname);
		cFirstName.addComponent(clientFirstname);

		clientDetails.addComponents(cID, cName, cFirstName);

		/// Network buttons ///
		this.socialInsuranceBtn = new Button(FontAwesome.INSTITUTION);
		this.doctorBtn = new Button(FontAwesome.USER_MD);
		this.healthInsBtn = new Button(FontAwesome.HOSPITAL_O);
		this.relativesBtn = new Button(FontAwesome.USERS);

		// Network image ///
		this.resource = new ThemeResource("NetzwerkNeu.png");
		this.image = new Image("", resource);

		absolute.addComponent(socialInsuranceBtn, "left: 107px; top: 18px; z-index: 2");
		absolute.addComponent(doctorBtn, "left: 18px; top: 110px; z-index: 2");
		absolute.addComponent(healthInsBtn, "left: 202px; top: 110px; z-index: 2");
		absolute.addComponent(relativesBtn, "left: 107px; top: 203px; z-index: 2");
		absolute.addComponent(image, "z-index: 1");

		socialInsuranceBtn.addClickListener(e -> {
			this.showDynamicContent(new SocialInsurance(this));
		});

		doctorBtn.addClickListener(e -> {
			this.showDynamicContent(new Doctor(this));
		});

		healthInsBtn.addClickListener(e -> {
			this.showDynamicContent(new HealthInsurance(this));
		});

		relativesBtn.addClickListener(e -> {
			this.showDynamicContent(new Relatives(this));
		});

		// adding all components into root
		this.addComponents(clientDetails, absolute);
		this.setSpacing(true);

	}

	/*
	 * 
	 */
	private void showDynamicContent(VerticalLayout view) {
		this.removeComponent(absolute);
		this.addComponent(dynamicContent);
		this.dynamicContent.removeAllComponents();
		this.dynamicContent.addComponent(view);
	}

	/**
	 * 
	 */
	public void displayStartScreen() {
		this.removeComponent(this.dynamicContent);
		this.addComponent(this.absolute);

		
	}
}