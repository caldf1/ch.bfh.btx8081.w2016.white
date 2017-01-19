package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;

import com.vaadin.ui.VerticalLayout;


/**
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class TabNetwork extends VerticalLayout implements View {
	
/*==============================================
 *    Attributes
 *==============================================
 */ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 5959111832198033331L;
	


	/*=========== Layouts ===========*/
	private AbsoluteLayout absolute = new AbsoluteLayout();
	private VerticalLayout vertical1 = new VerticalLayout();
	
	
	/*=========== Images ===========*/
	private Image image = new Image("", new ThemeResource("NetzwerkNeu.png"));
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button socialInsuranceBtn = new Button(FontAwesome.INSTITUTION);
	private Button doctorBtn = new Button(FontAwesome.USER_MD);
	private Button healthInsBtn = new Button(FontAwesome.HOSPITAL_O);
	private Button relativesBtn = new Button(FontAwesome.USERS);


	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * 
	 * @param patientOverview
	 */
	public TabNetwork(SingleClientOverview patientOverview) {

	
		/*=========== set Layout / addComponents ===========*/
		this.removeAllComponents();
		
		absolute.setWidth("581px");
		absolute.setHeight("560px");
		vertical1.setSizeFull();
		
		addComponentToAbsolut();
		
	
		/*=========== Root set Layout ===========*/
		this.addComponents(absolute);
		//this.addComponents(vertical1);
		this.setMargin(true);
		this.setSpacing(true);
		
		
		/*=========== addClickListener ===========*/
		
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

	}

	
	
/*==============================================
 *    Setter
 *==============================================
 */

	@Override
	public void enter(ViewChangeEvent event) {

	}
	
	
	/**
	 * 
	 */
	public void openNetwork() {
		new TabNetwork(null);
	}
	
	
	/**
	 * 
	 */
	public void displayNetworkScreen() {
		this.removeComponent(this.vertical1);
		this.addComponent(this.absolute);
	}
	
	
/*==============================================
 *    Helper
 *==============================================
 */
	
	
	/*
	 * 
	 */
	private void showDynamicContent(VerticalLayout view) {
		this.removeAllComponents();
		//this.removeComponent(absolute);
		this.addComponent(vertical1);
		vertical1.setSizeFull();
		vertical1.removeAllComponents();
		vertical1.addComponent(view);
	}

	/*
	 * 
	 */
	private void addComponentToAbsolut(){
	
		absolute.addComponent(socialInsuranceBtn, "left: 107px; top: 18px; z-index: 2");
		absolute.addComponent(doctorBtn, "left: 18px; top: 110px; z-index: 2");
		absolute.addComponent(healthInsBtn, "left: 202px; top: 110px; z-index: 2");
		absolute.addComponent(relativesBtn, "left: 107px; top: 203px; z-index: 2");
		absolute.addComponent(image, "z-index: 1");

	}
	
}