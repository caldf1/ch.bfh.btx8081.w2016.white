package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

//import SingleClient.SingleClientOverview;
//import SingleClientNetwork.Ahv;
//import SingleClientNetwork.Doctor;
//import SingleClientNetwork.Insurance;
//import SingleClientNetwork.Relatives;

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
	private Button ahvBtn;   
	private Button doctorBtn;
	private Button healthInsBtn;
	private Button relativesBtn;
	private ThemeResource resource;
	private Image image;

	
	/**
	 * 
	 */
	public void openNetwork(){
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
		this.ahvBtn = new Button("AHV");
		this.doctorBtn = new Button("Hausarzt");
		this.healthInsBtn = new Button("Krankenkasse");
		this.relativesBtn = new Button("Angehörige");

		// Network image ///
		this.resource = new ThemeResource("Netzwerk.png");
		this.image = new Image("", resource);

		absolute.addComponent(ahvBtn, "left: 260px; top: 440px; z-index: 2");
		absolute.addComponent(doctorBtn, "left: 60px; top: 260px; z-index: 2");
		absolute.addComponent(healthInsBtn, "left: 220px; top: 90px; z-index: 2");
		absolute.addComponent(relativesBtn, "right: 60px; top: 260px; z-index: 2");
		absolute.addComponent(image, "z-index: 1");

		ahvBtn.addClickListener(e -> {
			this.showDynamicContent(new Ahv(this));
		});
		
		doctorBtn.addClickListener(e -> {
			this.showDynamicContent(new Doctor(this));
		});
		
		healthInsBtn.addClickListener(e -> {
			this.showDynamicContent(new Insurance(this));
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
	private void showDynamicContent(VerticalLayout view){
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