package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;



/**
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class SingleClientOverview extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7129355810869038384L;
	

	/*=========== Layouts ===========*/
	private TabSheet tabSheet = new TabSheet();
		
	private VerticalLayout vertical1 = new VerticalLayout();
	private VerticalLayout tablDay = new VerticalLayout();
	private VerticalLayout tablInfo = new VerticalLayout();
	private VerticalLayout tablMedi = new VerticalLayout();
	private VerticalLayout tablSpecial = new VerticalLayout();
	private VerticalLayout tablDocu = new VerticalLayout();
	private VerticalLayout tablNetwork = new VerticalLayout();
	
	private HorizontalLayout HLClient = new HorizontalLayout();
	private HorizontalLayout HLheader = new HorizontalLayout();
	
	private Label labelID = new Label("Client ID: ");
	private Label labelName = new Label("Nachname Vorname");


	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "570";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button homeBtn = new Button(FontAwesome.HOME);
	private Button returnBtn = new Button(FontAwesome.ARROW_LEFT);


	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * 
	 * @param myUI
	 */
	public SingleClientOverview(MyUI myui) {

		
		
		/*=========== set Layout / addComponents ===========*/
				
		

		HLheader.addComponents(returnBtn, homeBtn);
		HLheader.setSpacing(true);
		
		labelID.setValue("Client 10609: ");
		labelName.setValue("Brönnimann Elisabeth");		
		HLClient.addComponents(labelID, labelName);
		HLClient.setSpacing(true);

		addToolbar();
		tabSheet.setWidth(WIDTH);
		tabSheet.setHeight(HEIGHT);
		
		vertical1.addComponents(HLClient, HLheader, tabSheet);
		vertical1.setSpacing(true);
		
		
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical1);
		this.setMargin(true);
		this.setSpacing(true);
		
		
		/*=========== addClickListener ===========*/

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.HOMESCREEN));
		});
		
		returnBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.CLIENT_DIRECTORY2));
		});

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
	
	private void addToolbar(){
		
		this.tablDay = new TabDay(this);
		tabSheet.addTab(tablDay, "", FontAwesome.SUN_O); // Alltag
		
		this.tablInfo = new TabInfo(this);
		tabSheet.addTab(tablInfo, "", FontAwesome.INFO); // Info
		
		this.tablMedi = new TabMedication(this);
		tabSheet.addTab(tablMedi, "", FontAwesome.MEDKIT); // Medikation
		
		this.tablSpecial = new TabSpecial(this);
		tabSheet.addTab(tablSpecial, "", FontAwesome.EXCLAMATION); // Besonderes
		
		this.tablDocu = new TabActivityRecording(this);
		tabSheet.addTab(tablDocu, "", FontAwesome.FILE_TEXT_O); // Dokumente
		
		this.tablNetwork = new TabNetwork(this);	
		tabSheet.addTab(tablNetwork, "", FontAwesome.ARROWS); // Netzwerk
		
	}
	
	
}
