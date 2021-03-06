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

import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

/**
 * This class contains several buttons, which redirect the user to its chosen site.
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class HomeScreen extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 	
	
	private static final long serialVersionUID = -7098205660635338078L;
	
	
	
	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	private GridLayout grid1 = new GridLayout(2, 1);
	
	/*=========== Images ===========*/
	private Image hvManagerLogo = new Image("", new ThemeResource("HVmanagerLogoNeu.png"));
	

	/*=========== View-Size ===========*/	
	final static String WIDTH = "280";
	final static String HEIGHT = "570";
	
	final static String BUTTONWIDTH = "85";
	final static String BUTTONHEIGHT = "60";
	
	/*=========== Buttons ===========*/	
	private Button clientBtn = createButton(FontAwesome.USERS);
	private Button helpBtn = createButton(FontAwesome.QUESTION);
	private Button statsBtn = createButton(FontAwesome.BAR_CHART);
	private Button billingBtn = createButton(FontAwesome.DOLLAR);
	private Button myAppointmentsBtn = createButton(FontAwesome.CALENDAR);
	private Button substituteBtn = createButton(FontAwesome.LIST);

	
/*==============================================
 *    Constructor
 *==============================================
 */
	
	/**
	 * All components are added in this constructor and there are click listeners, which redirects the
	 * user to the desired views.
	 * 
	 * @param myui
	 */
	//@SuppressWarnings("static-access")
	public HomeScreen(MyUI myui) {
				
		
		
		/*=========== set Layout / addComponents ===========*/
		
		horizontal1.addComponent(hvManagerLogo);
				
		grid1.addComponents(clientBtn, myAppointmentsBtn, substituteBtn, billingBtn, statsBtn, helpBtn);

		
		grid1.setSpacing(true);
		
		vertical1.addComponents(horizontal1, horizontal2, grid1);
		vertical1.setSpacing(true);
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical1);
		this.setWidth(WIDTH);;;
		this.setHeight(HEIGHT);		
		this.setMargin(true);
		this.setSpacing(true);
		
				
		/*=========== Buttons.addClickListener ===========*/
							
			clientBtn.addClickListener(e -> {
				myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.CLIENT_DIRECTORY));
			});
	
			helpBtn.addClickListener(e -> {
				myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.HELP));
			});
	
			statsBtn.addClickListener(e -> {
				myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.STATISTICS));
			});
	
			billingBtn.addClickListener(e -> {
				myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.BILLING));
			});
			
			myAppointmentsBtn.addClickListener(e -> {
				myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.MY_APPOINTMENTS));
			});
			
			substituteBtn.addClickListener(e -> {
				myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.SUBSTITUTE));
			});
	
//			testViewBtn.addClickListener(e -> {
//				myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.TEST_VIEW));
//			});
				
	}
	
	
/*==============================================
 *    Setter
 *==============================================
 */
	
	@Override
	public void enter(ViewChangeEvent event) {

	}

	
/*==============================================
 *    Helper
 *==============================================
 */
	
	/*
	 * create home screen button with define width and height
	 */
	private Button createButton(FontAwesome fontAwesome){
		Button button = new Button(fontAwesome);
		button.setWidth(BUTTONWIDTH);
		button.setHeight(BUTTONHEIGHT);
		
		return button;
	}
	
}