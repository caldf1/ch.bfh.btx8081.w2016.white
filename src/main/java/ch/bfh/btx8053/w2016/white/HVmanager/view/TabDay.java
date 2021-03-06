package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;



/**
 * This class shows the user, what kind of things the client is doing during the day.
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class TabDay extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	
	private static final long serialVersionUID = 2228937876524596805L;

	
	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private VerticalLayout vertical2 = new VerticalLayout();
	private VerticalLayout vertical3 = new VerticalLayout();
	
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	

	private Grid gridAgreement  = new Grid("Vereinbarungen: ");
	private Grid gridDailiyActivity = new Grid("Tagesablauf: ");
	
	private Label label1 = new Label("=============================");

	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button addAgrmtBtn = new Button(FontAwesome.PLUS);
	private Button removeAgrmtBtn = new Button(FontAwesome.MINUS);
	private Button editAgrmtBtn = new Button(FontAwesome.EDIT);
	
	private Button addDailyBtn = new Button(FontAwesome.PLUS);;
	private Button removeDailyBtn = new Button(FontAwesome.MINUS);
	private Button editDailyBtn = new Button(FontAwesome.EDIT);


	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * All components are added in this constructor.
	 * 
	 * @param singleClientOverview
	 */
	public TabDay(SingleClientOverview singleClientOverview) {

	
		
		/*=========== set Layout / addComponents ===========*/
		
		gridAgreement.setWidth(WIDTH);
		
		
		gridDailiyActivity.setWidth(WIDTH);
		
		
		addFirstRow();
		addToGrid();
	
		horizontal1.addComponents(addAgrmtBtn, editAgrmtBtn, removeAgrmtBtn);
		horizontal1.setSpacing(true);
		
		horizontal2.addComponents(addDailyBtn, editDailyBtn, removeDailyBtn);
		horizontal2.setSpacing(true);
		
		vertical1.addComponents( horizontal1, gridAgreement);
		vertical1.setSpacing(true);
		
		vertical2.addComponents(horizontal2, gridDailiyActivity);
		vertical2.setSpacing(true);
		
		vertical3.addComponents(vertical1, label1, vertical2);
		vertical3.setSpacing(true);
	
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical3);
		this.setMargin(true);
		this.setSpacing(true);
		
		
		/*=========== addClickListener ===========*/
		

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
	 * generate columns for grid
	 */
	private void addFirstRow(){
		
	gridAgreement.addColumn("Zeit", String.class);
	gridAgreement.addColumn("Aktivität", String.class);
	
	gridDailiyActivity.addColumn("Zeit", String.class);
	gridDailiyActivity.addColumn("Aktivität", String.class);
		
	}
	
	
	/*
	 * fill rows for demo 
	 */
	private void addToGrid() {
		gridAgreement.addRow("11:00 Uhr", "Laufen gehen");
		gridAgreement.addRow("13:00 Uhr", "Medikamente einnehmen");
		gridAgreement.addRow("15:00 Uhr", "Bericht schreiben");
		

		gridDailiyActivity.addRow("08:00 Uhr", "Aufstehen");
		gridDailiyActivity.addRow("08:30 Uhr", "Morgenessen");
		gridDailiyActivity.addRow("11:00 Uhr", "Neue Ziele definieren");
		gridDailiyActivity.addRow("13:00 Uhr", "Mittagessen einnehmen");
		gridDailiyActivity.addRow("14:00 Uhr", "Freunde treffen");
		gridDailiyActivity.addRow("15:00 Uhr", "Mittagessen einnehmen");
		gridDailiyActivity.addRow("16:00 Uhr", "Einkaufen gehen");
		gridDailiyActivity.addRow("17:00 Uhr", "Laufen gehen");
		gridDailiyActivity.addRow("18:00 Uhr", "Fragebogen ausfüllen");
		
	}
	
	
}
